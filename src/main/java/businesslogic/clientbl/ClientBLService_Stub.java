package businesslogic.clientbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vo.ClientVO;
import businesslogicservice.clientblservice.ClientBLService;

public class ClientBLService_Stub extends UnicastRemoteObject implements ClientBLService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClientBLService_Stub() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean addClient(ClientVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return true;
	}


	public boolean changeClient(ClientVO vo) throws RemoteException{
		// TODO Auto-generated method stub
		return true;
	}

	public ClientVO findClientByNum(String num) throws RemoteException{
		// TODO Auto-generated method stub
		return new ClientVO();
	}

	public ArrayList<ClientVO> findCientByKey(String key) throws RemoteException{
		// TODO Auto-generated method stub
		return new ArrayList<ClientVO>();
	}

	public ClientVO getMessage() throws RemoteException{
		// TODO Auto-generated method stub
		return new ClientVO();
	}

	public boolean deleteClient(String num) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ClientVO> getClientList() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean end() throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

}
