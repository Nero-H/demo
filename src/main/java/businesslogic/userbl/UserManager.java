package businesslogic.userbl;

import java.rmi.RemoteException;

import po.UserPO;
import vo.UserVO;

public class UserManager{

	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public UserPO findUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean updateUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public String getUserIdentity() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
