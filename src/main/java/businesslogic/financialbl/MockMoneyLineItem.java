package businesslogic.financialbl;

import po.MoneyLineItemPO;

public class MockMoneyLineItem extends MoneyLineItemPO{
	String accountId;
	double sum;
	String comment;

	public MockMoneyLineItem(String accountId, double sum, String comment) {
		super(accountId, sum, comment);
		this.accountId = accountId;
		this.sum = sum;
		this.comment = comment;
	}

	@Override
	public void set(String accountId, double sum, String comment) {
		this.accountId = accountId;
		this.sum = sum;
		this.comment = comment;
	}

	@Override
	public String getAccountName() {
		return accountId;
	}

	@Override
	public void setAccountName(String accountId) {
		this.accountId = accountId;
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

	@Override
	public boolean match(String accountId, double sum, String comment) {
		return (this.accountId.equals(accountId)) && (this.sum == sum)
				&& (this.comment.equals(comment));
	}
}
