package po;

import java.io.Serializable;

import businesslogic.financialbl.MoneyList;

public interface MoneyPO extends Serializable{
	public String getClientName();
	
	public MoneyList getList();

	public double getSum();

	public String getUserName();
	
	public String getSerialNumber();	
}
