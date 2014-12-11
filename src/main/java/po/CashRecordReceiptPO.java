package po;

import java.io.Serializable;

import utility.Containsable;
import businesslogic.financialbl.CashRecordList;


public class CashRecordReceiptPO extends ReceiptPO implements Serializable,Containsable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ReceiptType type=ReceiptType.CashRecord;
	public ReceiptType getType() {
		return type;
	}


	public void setType(ReceiptType type) {
		this.type = type;
	}



	String accountName;
	CashRecordList itemList;
	double sum = 0;
	String serialNumber;
	String userName;
	
	


	public CashRecordReceiptPO(String accountName, CashRecordList itemList,
			double sum, String serialNumber, String userName) {
		super();
		this.accountName = accountName;
		this.itemList = itemList;
		this.sum = sum;
		this.serialNumber = serialNumber;
		this.userName = userName;
	}


	public String getAccountName() {
		return accountName;
	}


	public CashRecordList getItemList() {
		return itemList;
	}


	public double getSum() {
		return sum;
	}



	public void setSum(double sum) {
		this.sum = sum;
	}



	public String getSerialNumber() {
		return serialNumber;
	}

	public String getUserName() {
		return userName;
	}


	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

}
