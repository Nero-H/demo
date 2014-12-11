package businesslogicservice.userblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.UserVO;

public interface UserBLService extends Remote{
	
	
	public boolean addUser(UserVO vo) throws RemoteException;
	
	public boolean deleteUser(String id) throws RemoteException;
	
	public UserVO findUser(String id) throws RemoteException;

	public boolean updateUser(UserVO vo) throws RemoteException;
	
	public ArrayList<UserVO> getUserVOs() throws RemoteException;
	
		
}
