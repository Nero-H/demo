package data.financialdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import po.AccountPO;
import po.UpdateAccountPO;
import utility.LikeHashMap;
import businesslogic.financialbl.RecordController;
import dataservice.financialdataservice.AccountDataService;

public class AccountDataServiceSerializableImpl implements AccountDataService {
	public static AccountDataServiceSerializableImpl unique;
	public static AccountDataServiceSerializableImpl getInstance(){
		if(unique != null){
			return unique;
		}else{
			return unique = new AccountDataServiceSerializableImpl();
		}
	}
	
	LikeHashMap<String, AccountPO> list;
	File file;

	private AccountDataServiceSerializableImpl() {
		init();
	}

	public boolean addAccount(AccountPO po) {
		if (list.containsKey(po.getName())) {
			return false;
		} else {
			list.put(po.getName(), po);
			finish();
			return true;
		}
	}


	public AccountPO findAccount(String name) {
		// TODO Auto-generated method stub
		AccountPO account = list.get(name);
		return account;
	}


	public boolean delAccount(String name) {
		// TODO Auto-generated method stub
		if (list.remove(name) != null) {
			finish();
			return true;
		} else {
			return false;
		}
	}


	public boolean updateAccount(UpdateAccountPO po) {
		// TODO Auto-generated method stub
		AccountPO account = list.get(po.getOldName());
		if (account != null) {
			list.remove(po.getOldName());
			account.setName(po.getNewName());
			list.put(po.getNewName(), account);
			finish();
			return true;
		} else {
			return false;
		}
	}


	public ArrayList<AccountPO> getList() {
		// TODO Auto-generated method stub
		ArrayList<AccountPO> returnList =  new ArrayList<AccountPO>();
		returnList.addAll(list.values());
		return returnList;
	}
	
	public ArrayList<AccountPO> fuzzySearch(String name) {
		return list.fuzzySearch(name);
	}

	@SuppressWarnings("unchecked")
	public void init() {
		file = new File("data/" + new RecordController().getRecordName()
				+ "/account.ser");
		File dir = new File("data/" + new RecordController().getRecordName());
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(file.exists()){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			if (file.length() > 0) {
				list = (LikeHashMap<String, AccountPO>) ois.readObject();
			} else {
				list = new LikeHashMap<String, AccountPO>();
			}
			ois.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list = new LikeHashMap<String, AccountPO>();
		}
	}

	public void finish() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(
					new FileOutputStream(file));
			oos.writeObject(list);
			oos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean in(String accountName, double sum) {
		AccountPO account = findAccount(accountName);
		if (account != null) {
			account.setBalance(account.getBalance() + sum);
			finish();
			return true;
		} else {
			return false;
		}
	}

	public boolean out(String accountName, double sum) {
		return in(accountName, -sum);
	}

	public void writeLog(String log) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("data/"
					+ new RecordController().getRecordName()
					+ "/accountLog.txt",true));
			pw.println(log);
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
