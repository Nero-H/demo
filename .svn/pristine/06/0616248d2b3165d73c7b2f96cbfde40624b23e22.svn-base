package po;


public class SalesReturnPO extends SalesFatherPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ReceiptType type=ReceiptType.SalesReturn;

	
	public ReceiptType getType() {
		return type;
	}


	public void setType(ReceiptType type) {
		this.type = type;
	}


	public SalesReturnPO(SalesPO po, String receiptID) {
		// TODO Auto-generated constructor stub
		setReceiptsID(receiptID);
		setClient(po.getClient());
		setStorehouse(po.getStorehouse());
		setSalesman(po.getSalesman());
		setGoodsPOs(po.getGoodsPOs());
		setBeforeDiscount(po.getBeforeDiscount());
		setDiscount(po.getDiscount());
		setAfterDiscount(po.getAfterDiscount());
		setTicketsPrice(po.getTicketsPrice());
		setTotal(po.getTotal());
	}


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return getOperatorID();
	}

}
