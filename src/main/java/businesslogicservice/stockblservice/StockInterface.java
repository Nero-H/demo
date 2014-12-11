package businesslogicservice.stockblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import java.util.ArrayList;

import businesslogic.stockbl.StockDailyCheckListVO;
import vo.StockCheckListVO;
import vo.StockVO;

public interface StockInterface extends Remote{
	
	public ArrayList<StockCheckListVO> getStockCheckDate(java.util.Date d1, java.util.Date d2) throws RemoteException ;
	public ArrayList<StockDailyCheckListVO> getStockDailyCheck(int n) throws RemoteException;

	public ArrayList<StockVO> getSumList(ArrayList<StockCheckListVO> stockCheckListVOs) throws RemoteException ;
		
	

}
