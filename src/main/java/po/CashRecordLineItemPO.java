package po;

import java.io.Serializable;

public class CashRecordLineItemPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	double sum;
	String comment;
	public CashRecordLineItemPO(String name, double sum, String comment) {
		this.name = name;
		this.sum = sum;
		this.comment = comment;
	}
	
	public void set(String name, double sum, String comment) {
		this.name = name;
		this.sum = sum;
		this.comment = comment;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	
	public boolean match(String name,double sum,String comment){
		return (this.name.equals(name))&&(this.sum == sum)&&(this.comment.equals(comment));
	}
}
