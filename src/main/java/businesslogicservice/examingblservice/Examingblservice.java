package businesslogicservice.examingblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ReceiptVO;


public interface Examingblservice extends Remote{

	public boolean pass(String id)throws RemoteException ;
	
	public boolean notPass(String id)throws RemoteException;
	
	public boolean modify(String id)throws RemoteException;
	
	
	public ArrayList<ReceiptVO> getReceipts()throws RemoteException;
}
