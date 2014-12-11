package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vo.AccountVO;
import vo.UpdateAccountVO;
import businesslogicservice.financialblservice.AccountBLService;

public class AccountController extends UnicastRemoteObject implements AccountBLService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountController() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */

	public boolean addAccount(AccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return new Account().addAccount(vo);
	}

	public boolean delAccount(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return new Account().delAccount(name);
	}

	public boolean updateAccount(UpdateAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return new Account().updateAccount(vo);
	}

	public AccountVO findAccount(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return new Account().findAccount(id);
	}

	public boolean in(String accountName, double sum) {
		// TODO Auto-generated method stub
		return new Account().in(accountName, sum);
	}

	public boolean out(String accountName, double sum) {
		// TODO Auto-generated method stub
		return new Account().out(accountName, sum);
	}

	public ArrayList<AccountVO> getList() {
		// TODO Auto-generated method stub
		return new Account().getList();
	}

}
