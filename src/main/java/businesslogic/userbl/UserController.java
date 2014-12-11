package businesslogic.userbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.userdata.UserDataServiceSerializableIml;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import vo.UserVO;
import businesslogicservice.userblservice.UserBLService;

public class UserController extends UnicastRemoteObject implements UserBLService{

	
	public UserController() throws RemoteException {
		super();
		userDataService=UserDataServiceSerializableIml.getInstance();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserDataService userDataService;
	
	

	public boolean addUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO userPO=new Transform().vo_to_po(vo);
		
		
		return userDataService.addUser(userPO);
	}

	public boolean deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		
		return userDataService.deleteUser(id);
	}

	public UserVO findUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO userPO=userDataService.findUser(id);
		if(userPO!=null)
			return new Transform().po_to_vo(userPO);
		return null;
	}

	public boolean updateUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		UserPO po=new Transform().vo_to_po(vo);
		return userDataService.updateUser(po);
	}

	public ArrayList<UserVO> getUserVOs() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserVO> vos=new Transform().po_to_vo_list(userDataService.getUserPOs());
		return vos;
	}
}
