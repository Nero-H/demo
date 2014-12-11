package businesslogic.userbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import data.userdata.UserDataServiceSerializableIml;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import businesslogicservice.userblservice.LoginBLService;

public class LoginController extends UnicastRemoteObject implements
		LoginBLService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserPO po;
	UserDataService dataService;

	public LoginController() throws RemoteException {
		dataService = UserDataServiceSerializableIml.getInstance();
	}

	public boolean login(String id, String password) throws RemoteException {
		// TODO Auto-generated method stub
		po = dataService.findUser(id);
		if (po == null)
			return false;
		else {
			if (!po.getPassward().equals(password))
				return false;
		}

		return true;
	}

	public String getUserName() throws RemoteException {
		if (po != null) {
			return po.getName();
		} else {
			return "DefaultName";
		}
	}

	public String getUserIdentity() throws RemoteException {
		if (po != null) {
			return po.getIdentity().toString();
		}else {
			return "DefaultIdentity";
		}
	}

	public int getUserLevel() throws RemoteException {
		// TODO Auto-generated method stub
		if (po!=null) {
			return po.getLevel();
		}
		else
		    return -1;
	}

}
