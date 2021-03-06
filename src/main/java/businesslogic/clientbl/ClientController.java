package businesslogic.clientbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vo.ClientVO;
import businesslogicservice.clientblservice.ClientBLService;

public class ClientController extends UnicastRemoteObject implements ClientBLService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client client;
	private ClientLog log;

	public ClientController() throws RemoteException {
		super();
		client = new Client();
		log = new ClientLog();
		// TODO Auto-generated constructor stub
	}

	public boolean addClient(ClientVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result = client.addClient(vo);
		if (result) {
			log.writeLog(ClientOperation.ADD, vo);
		}
		return result;
	}

	public boolean deleteClient(String num) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result = client.deleteClient(num);
		if (result) {
			ClientVO vo = findClientByNum(num);
			log.writeLog(ClientOperation.DEL, vo);
		}
		return result;
	}

	public boolean changeClient(ClientVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		boolean result = client.changeClient(vo);
		if (result) {
			log.writeLog(ClientOperation.CHANGE, vo);
		}
		return result;
	}

	public ClientVO findClientByNum(String num) throws RemoteException {
		// TODO Auto-generated method stub
		return client.findClientByNum(num);
	}

	public ArrayList<ClientVO> findCientByKey(String key) throws RemoteException {
		// TODO Auto-generated method stub
		return client.findCientByKey(key);
	}


	public ArrayList<ClientVO> getClientList() throws RemoteException {
		// TODO Auto-generated method stub
		return client.getClientList();
	}

	

}
