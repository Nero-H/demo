package businesslogic.financialbl;

import po.CashRecordLineItemPO;

public class MockCashRecordLineItem extends CashRecordLineItemPO{
	String name;
	double sum;
	String comment;
	
	public MockCashRecordLineItem(String name, double sum, String comment) {
		super(name, sum, comment);
		this.name = name;
		this.sum = sum;
		this.comment = comment;
	}
	
	@Override
	public void set(String name, double sum, String comment) {
		this.name = name;
		this.sum = sum;
		this.comment = comment;
	}
	
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public double getSum() {
		return sum;
	}
	@Override
	public void setSum(double sum) {
		this.sum = sum;
	}
	@Override
	public String getComment() {
		return comment;
	}
	@Override
	public void setComment(String comment) {
		this.comment = comment;
	}
}
