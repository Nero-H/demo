package businesslogic.financialbl;

import po.AccountPO;

public class MockAccount extends AccountPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	double money;
	String id;
	
	public MockAccount(String name, double money) {
		super(name, money);
		this.name = name;
		this.money = money;
	}

	public double getMoney(){
		return money;
	}
	
	public void setMoney(double money){
		this.money = money;
	}
	
	void pay(double money){
		this.money -= money;
	}
}
