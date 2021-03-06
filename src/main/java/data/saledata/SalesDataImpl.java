package data.saledata;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import po.SalesPO;
import data.databaseutility.FileOperate;
import data.databaseutility.TimeNumber;
import dataservice.saledataservice.SalesDataService;

public class SalesDataImpl implements SalesDataService{
	private static SalesDataService salesDatabase;
	HashMap<String, SalesPO> salesList;
	private int todayNumber;
	
	private SalesDataImpl() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public static SalesDataService getInstance(){
		if (salesDatabase == null) {
			salesDatabase = new SalesDataImpl();
		}
		return salesDatabase;
	}
	
	public boolean insert(SalesPO po) {
		// TODO Auto-generated method stub
		if (salesList.containsKey(po.getReceiptsID())) {
			return false;
		}
		salesList.put(po.getReceiptsID(), po);
		todayNumber++;
		return true;
	}

	public void delete(String receipts) {
		// TODO Auto-generated method stub
		salesList.remove(receipts);
	}

	public void update(SalesPO po) {
		// TODO Auto-generated method stub
		salesList.put(po.getReceiptsID(), po);
	}

	public SalesPO find(String receiptsID) {
		// TODO Auto-generated method stub
		return salesList.get(receiptsID);
	}

	public ArrayList<SalesPO> getSalesList() {
		// TODO Auto-generated method stub
		ArrayList<SalesPO> salesPOs = new ArrayList<SalesPO>();
		salesPOs.addAll(salesList.values());
		return salesPOs;
	}

	@SuppressWarnings("unchecked")
	public void init() {
		// TODO Auto-generated method stub
		TimeNumber timeNumber = (TimeNumber) new FileOperate("salesNumber.ser").read();
		if (timeNumber == null || timeNumber.isBeforeToday(Calendar.getInstance())) {
			todayNumber = 0;
		}else {
			todayNumber = timeNumber.getTodayNumber();
		}
		salesList = (HashMap<String, SalesPO>)new FileOperate("src/sales.ser").read();
		if (salesList == null) {
			salesList = new HashMap<String, SalesPO>();
		}
	}

	public void finish() {
		// TODO Auto-generated method stub
		TimeNumber timeNumber = new TimeNumber(todayNumber, Calendar.getInstance());
		new FileOperate("salesNumber.ser").write(timeNumber);
		new FileOperate("src/sales.ser").write(salesList);;
	}

	public int getTodayNum() {
		// TODO Auto-generated method stub
		return todayNumber;
	}

}
