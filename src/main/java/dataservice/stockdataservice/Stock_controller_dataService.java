package dataservice.stockdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.StockCheckListPO;



public interface Stock_controller_dataService {

	public ArrayList<StockCheckListPO>  checkStock (Date d1,Date d2) ;
	
	
	public boolean addStock(StockCheckListPO stockCheckListPO) ;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}