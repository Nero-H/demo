package dataservice.stockdataservice;

import java.rmi.RemoteException;
import po.WarningPO;

public interface StockDataService {

	
	public boolean giveGift(String ID ,int num) ;
	public WarningPO warning () ;
	public void init() throws RemoteException;
	public void finish() throws RemoteException;
}
