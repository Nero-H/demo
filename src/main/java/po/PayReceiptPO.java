package po;

import utility.Containsable;
import businesslogic.financialbl.MoneyList;


public class PayReceiptPO extends ReceiptPO implements Containsable,MoneyPO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String clientName;
	MoneyList list;
	double sum;
	String serialNumber;
	String userName;
	ReceiptType type=ReceiptType.Pay;
	

	public PayReceiptPO(String clientName, MoneyList list, double sum,
			String serialNumber, String userName) {
		super();
		this.clientName = clientName;
		this.list = list;
		this.sum = sum;
		this.serialNumber = serialNumber;
		this.userName = userName;
	}


	public String getClientName() {
		return clientName;
	}


	public ReceiptType getType() {
		return type;
	}


	public void setType(ReceiptType type) {
		this.type = type;
	}


	public MoneyList getList() {
		return list;
	}



	public void setList(MoneyList list) {
		this.list = list;
	}



	public double getSum() {
		return sum;
	}



	public void setSum(double sum) {
		this.sum = sum;
	}



	public String getUserName() {
		return userName;
	}

	public String getSerialNumber() {
		return serialNumber;
	}


	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}
}
