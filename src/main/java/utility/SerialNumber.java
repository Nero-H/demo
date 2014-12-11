package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;



public class SerialNumber implements Containsable{
	String serialNumber;
	public static String getSerialNumber(String prefix, int number){
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date(System.currentTimeMillis());
		String temp = format.format(today);
		//得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        //设置是否使用分组
        nf.setGroupingUsed(false);
        //设置最大整数位数
        nf.setMaximumIntegerDigits(5);
        //设置最小整数位数    
        nf.setMinimumIntegerDigits(5);
        prefix = prefix + temp + nf.format(number);
		return prefix;
	}
	
	static private HashMap<String,HashMap<String,Integer>> prefixMap;
	
	public static String getSerialNumber(String prefix){
		read();
		HashMap<String, Integer> dateMap = prefixMap.get(prefix);
		if(dateMap == null){
			dateMap = new HashMap<String, Integer>();
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date today = new Date(System.currentTimeMillis());
		String temp = format.format(today);
		Integer count = dateMap.get(temp);
		if(count == null){
			count = 0;
		}
		count++;
		String retStr = getSerialNumber(prefix, count);
		dateMap.put(temp, count);
		prefixMap.put(prefix, dateMap);
		save();
		return retStr;
	}
	
	@SuppressWarnings("unchecked")
	private static void read(){
		File file = new File("data/serialNumber.ser");
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			prefixMap = new HashMap<String,HashMap<String,Integer>>();
			save();
		}else{
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				prefixMap = (HashMap<String,HashMap<String,Integer>>)ois.readObject();
				ois.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	private static void save(){
		File file = new File("data/serialNumber.ser");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(prefixMap);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return serialNumber.contains(key);
	}
}
