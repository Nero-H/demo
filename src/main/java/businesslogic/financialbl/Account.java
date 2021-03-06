package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.AccountPO;
import po.UpdateAccountPO;
import vo.AccountVO;
import vo.UpdateAccountVO;
import businesslogic.userbl.LoginController;
import businesslogicservice.financialblservice.AccountBLService;
import data.databaseutility.SerializableDataFactory;
import dataservice.financialdataservice.AccountDataService;

public class Account implements AccountBLService{

	public boolean addAccount(AccountVO vo)  {
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		boolean result = accountDataService.addAccount(convertPO(vo));
		if(result){
			writeLog(accountDataService,"添加账户 " + vo.getName() + " 并初始化余额为" + vo.getBalance());
		}
		return result;
	}
	
	public boolean delAccount(String name)  {
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		boolean result = accountDataService.delAccount(name);
		if(result){
			writeLog(accountDataService,"删除账户 " + name);
		}
		return result;
	}

	public boolean updateAccount(UpdateAccountVO vo)  {
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		boolean result = accountDataService.updateAccount(new UpdateAccountPO(vo.getOldName(),vo.getNewName()));
		if(result){
			writeLog(accountDataService,"更新账户名称从 " + vo.getOldName() + "为 " + vo.getNewName());
		}
		return result;
	}

	public AccountVO findAccount(String name)  {
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		return convertVO(accountDataService.findAccount(name));
	}

	public boolean in(String accountName, double sum) {
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		boolean result = accountDataService.in(accountName, sum);
		return result;
		
	}

	public boolean out(String accountName, double sum) {
		// TODO Auto-generated method stub
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		boolean result = accountDataService.out(accountName, sum);
		return result;
	}
	
	AccountPO convertPO(AccountVO vo){
		if(vo == null){
			return null;
		}
		return new AccountPO(vo.getName(), vo.getBalance());
	}
	
	AccountVO convertVO(AccountPO po){
		if(po == null){
			return null;
		}
		return new AccountVO(po.getName(), po.getBalance());
	}
	
	void writeLog(AccountDataService accountDataService , String log){
		try {
			accountDataService.writeLog(new Date() + "\t" + new LoginController().getUserIdentity() + " " + new LoginController().getUserName() + " " + log);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<AccountVO> getList() {
		AccountDataService accountDataService = new SerializableDataFactory().getAccountDataService();
		ArrayList<AccountVO> returnList = new ArrayList<AccountVO>();
		for(AccountPO po : accountDataService.getList()){
			returnList.add(convertVO(po));
		}
		return returnList;
	}
	
}
