package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import utility.MyTreeNode;
import data.databaseutility.SerializableDataFactory;
import businesslogicservice.stockblservice.GoodsManageBLService;

public class GoodsManageController extends UnicastRemoteObject implements GoodsManageBLService{

	public GoodsManageController() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyTreeNode getRoot() throws RemoteException {
		return new SerializableDataFactory().getGoodsManageDataService().getRoot();
	}

	public void setRoot(MyTreeNode node) throws RemoteException {
		new SerializableDataFactory().getGoodsManageDataService().setRoot(node);
	}
	

}
