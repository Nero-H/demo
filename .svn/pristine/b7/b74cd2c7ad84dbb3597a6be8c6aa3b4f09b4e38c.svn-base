package data.databaseutility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileOperate {
	private String path;
	
	public FileOperate(String filepath) {
		// TODO Auto-generated constructor stub
		this.path = filepath;
	}
	
	public Object read(){
		Object temp = null;
		File file = new File(path);
		try{
			if (file.exists()) {
				FileInputStream store =  new FileInputStream(file);
				ObjectInputStream hasStore = new ObjectInputStream(store);
				temp = hasStore.readObject();
				hasStore.close();
			}else {
				file.createNewFile();//不存在就创建一个
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return null;
		}
		return temp;
	}
	
	public void write(Object object){
		File file = new File(path);
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			FileOutputStream importFileOutputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(importFileOutputStream);
			objectOutputStream.writeObject(object);
			objectOutputStream.close();
			importFileOutputStream.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
