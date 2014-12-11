package po;


public class SalesPO extends SalesFatherPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ReceiptType type=ReceiptType.Sales;
	boolean isReturn = false;
	
	public ReceiptType getType() {
		return type;
	}
	public void setType(ReceiptType type) {
		this.type = type;
	}
	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return getReceiptsID();
	}
	public boolean isReturn() {
		return isReturn;
	}
	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}
	

}
