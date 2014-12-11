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

import po.CashRecordReceiptPO;
import utility.LikeHashMap;
import utility.TimePeriod;
import businesslogic.financialbl.RecordController;
import dataservice.financialdataservice.CashRecordDataService;

public class CashRecordDataServiceSerializeableImpl implements
		CashRecordDataService {
	static CashRecordDataServiceSerializeableImpl unique;

	public static CashRecordDataServiceSerializeableImpl getInstance() {
		if (unique != null) {
			return unique;
		} else {
			return unique = new CashRecordDataServiceSerializeableImpl();
		}
	}

	LikeHashMap<String, CashRecordReceiptPO> list;
	File file;
	ObjectInputStream ois;

	private CashRecordDataServiceSerializeableImpl() {
		init();
	}

	public boolean addCashRecord(CashRecordReceiptPO po) {
		// TODO Auto-generated method stub
		list.put(po.getSerialNumber(), po);
		finish();
		return false;
	}

	public CashRecordReceiptPO find(String id) {
		// TODO Auto-generated method stub
		return list.get(id);
	}

	@SuppressWarnings("unchecked")
	public void init() {
		// TODO Auto-generated method stub
		file = new File("data/" + new RecordController().getRecordName()
				+ "/cashRecord.ser");
		File dir = new File("data/" + new RecordController().getRecordName());
		if (!dir.exists()) {
			dir.mkdirs();
		}
		if (file.exists()) {
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				if (file.length() > 0) {
					list = (LikeHashMap<String, CashRecordReceiptPO>) ois
							.readObject();
				} else {
					list = new LikeHashMap<String, CashRecordReceiptPO>();
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
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list = new LikeHashMap<String, CashRecordReceiptPO>();
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

	public void writeLog(String log) {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter("data/"
					+ new RecordController().getRecordName()
					+ "/CashRecordLog.txt", true));
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

	public ArrayList<CashRecordReceiptPO> mutipleConditionSearch(
			TimePeriod period, String userName, String accountName) {
		// TODO Auto-generated method stub
		ArrayList<CashRecordReceiptPO> returnList = new ArrayList<CashRecordReceiptPO>();
		for (CashRecordReceiptPO po : list.values()) {
			if (period.timeCheck(po.getSerialNumber().substring(5, 13))
					&& (po.getUserName().equals(userName) || userName
							.equals(""))
					&& (po.getAccountName().equals(accountName) || accountName
							.equals(""))) {
					returnList.add(po);
			}
		}
		return returnList;
	}

	public ArrayList<CashRecordReceiptPO> getList() {
		// TODO Auto-generated method stub
		ArrayList<CashRecordReceiptPO> returnList = new ArrayList<CashRecordReceiptPO>();
		returnList.addAll(list.values());
		return returnList;
	}
}
