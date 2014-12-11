package businesslogic.userbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserIdentity;
import po.UserPO;
import vo.ReceiptVO;
import vo.UserVO;
import businesslogic.userbl.Transform;
import businesslogicservice.userblservice.UserBLService;

public class UserManagerStub implements UserBLService{

	public boolean addUser(UserVO vo) {
		// TODO Auto-generated method stub
		System.out.println("add successfully!");
		return true;
	}

	public boolean deleteUser(UserVO vo) {
		// TODO Auto-generated method stub
		System.out.println("delete successfully!");
		return true;
	}

	public boolean login(String ID, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
	
	public boolean updateUser(UserVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	public UserVO findUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new Transform().po_to_vo(new UserPO("Nero","sada","sf2",UserIdentity.FinancialManager)) ;
	}

	public void hotStamp(ReceiptVO vo, boolean cpy) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public String getUserIdentity() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUserName() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deleteUser(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<UserVO> getUserVOs() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
