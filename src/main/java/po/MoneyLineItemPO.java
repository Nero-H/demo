package po;

import java.io.Serializable;

public class MoneyLineItemPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String accountName;
	double sum;
	String comment;

	public MoneyLineItemPO(String accountName, double sum, String comment) {
		this.accountName = accountName;
		this.sum = sum;
		this.comment = comment;
	}

	public void set(String accountName, double sum, String comment) {
		this.accountName = accountName;
		this.sum = sum;
		this.comment = comment;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean match(String accountName, double sum, String comment){
		return (this.accountName.equals(accountName))&&(this.sum == sum)&&(this.comment.equals(comment));
	}
}
