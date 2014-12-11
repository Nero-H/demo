package data.stockdata;

import java.rmi.RemoteException;
import java.sql.Date;

import po.StatePO;
import po.StockCheckListPO;
import po.StockDailyCheckListPO;
import po.WarningPO;
import dataservice.stockdataservice.StockDataService;


public class StockDataService_Controller implements StockDataService{
	
	

	public StatePO reportStock() {
		// TODO Auto-generated method stub
		return new StatePO();
	}
	public boolean giveGift(String ID ,int num) {
		// TODO Auto-generated method stub
		return true;
	}
	public WarningPO warning () {
		
		return new WarningPO();
	}
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	public StockCheckListPO checkStock(Date d1, Date d2)  {
		// TODO Auto-generated method stub
		return null;
	}


	public StockDailyCheckListPO checkDailyStock(Date date, int n) {
		// TODO Auto-generated method stub
		return null;
	}

}
