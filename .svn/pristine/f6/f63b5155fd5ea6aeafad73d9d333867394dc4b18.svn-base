package dataservice.financialdataservice;

import java.util.ArrayList;

import po.AccountPO;
import po.UpdateAccountPO;

public interface AccountDataService {

	public boolean addAccount(AccountPO po);

	public AccountPO findAccount(String name);

	public boolean delAccount(String name);

	public boolean updateAccount(UpdateAccountPO po);

	public ArrayList<AccountPO> fuzzySearch(String name);

	public void init();

	public void finish();

	public boolean in(String accountName, double sum);

	public boolean out(String accountName, double sum);
	
	public ArrayList<AccountPO> getList();
	
	public void writeLog(String string);
}
