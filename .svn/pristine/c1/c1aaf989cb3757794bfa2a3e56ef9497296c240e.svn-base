package businesslogic.examingbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vo.ReceiptVO;
import businesslogicservice.examingblservice.Examingblservice;

public class ExamingController extends UnicastRemoteObject implements Examingblservice{

	public ExamingController() throws RemoteException {
		super();
		examing=new Examing();
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	Examing examing;
	
	public boolean pass(String id) {
		// TODO Auto-generated method stub
		return examing.pass(id);
	}

	public boolean notPass(String id) {
		// TODO Auto-generated method stub
		return examing.notPass(id);
	}

	public boolean modify(String id) {
		// TODO Auto-generated method stub
		return examing.modify(id);
	}


	public ArrayList<ReceiptVO> getReceipts() {
		// TODO Auto-generated method stub
		return examing.getReceipts();
	}

	
}
