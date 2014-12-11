package businesslogic.financialbl.stub;


import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.AccountVO;
import vo.UpdateAccountVO;
import businesslogicservice.financialblservice.AccountBLService;

public class AccountManagerStub implements AccountBLService{
	String name;
	double balance;
	String id;
	public AccountManagerStub(String name,double balance,String id){
		this.name = name;
		this.balance = balance;
		this.id = id;
	}
	
	public boolean addAccount(AccountVO vo){
		System.out.println("add account succeed!");
		return true;
	}
	
	public boolean delAccount(String name){
		System.out.println();
		return true;
	}
	
	public boolean updateAccount(AccountVO vo){
		System.out.println("update account succeed!");
		return true;
	}
	
	public AccountVO findAccount(String id){
		System.out.println("find account succeed!");
		return new AccountVO(name,balance);
	}

	public boolean updateAccount(UpdateAccountVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean in(String accountName, double sum) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean out(String accountName, double sum) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<AccountVO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getIndexOf(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

}
