package po;

import java.util.ArrayList;

public class SalesFatherPO extends Import_Sales_FatherPO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//基本属性
	private String salesman;    //业务员
	private	String operatorID;	//操作员
	private ArrayList<GiftPO> giftGoods;	//赠品
	private double beforeDiscount;	//折让前总额
	private double Discount;		//折让
	private double afterDiscount;	//折让后总额
	private double ticketsPrice;	//使用的代金券金额
	private double voucher;			//生成的代金券金额
	
	
	public SalesFatherPO() {
		// TODO Auto-generated constructor stub
		giftGoods = new ArrayList<GiftPO>();
		beforeDiscount = 0;
		Discount = 0;
		afterDiscount = 0;
		ticketsPrice = 0;
		voucher = 0;
	}
	
	public String getSalesman() {
		return salesman;
	}
	public void setSalesman(String salesman) {
		this.salesman = salesman;
	}
	public String getOperatorID() {
		return operatorID;
	}
	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}
	public ArrayList<GiftPO> getGiftGoods() {
		return giftGoods;
	}
	public void setGiftGoods(ArrayList<GiftPO> giftGoods) {
		this.giftGoods = giftGoods;
	}
	public double getBeforeDiscount() {
		return beforeDiscount;
	}
	public void setBeforeDiscount(double beforeDiscount) {
		this.beforeDiscount = beforeDiscount;
	}
	public double getDiscount() {
		return Discount;
	}
	public void setDiscount(double discount) {
		Discount = discount;
	}
	public double getAfterDiscount() {
		return afterDiscount;
	}
	public void setAfterDiscount(double afterDiscount) {
		this.afterDiscount = afterDiscount;
	}
	public double getTicketsPrice() {
		return ticketsPrice;
	}
	public void setTicketsPrice(double ticketsPrice) {
		this.ticketsPrice = ticketsPrice;
	}
	public double getVoucher() {
		return voucher;
	}
	public void setVoucher(double voucher) {
		this.voucher = voucher;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
//--------------------------------------------------------
	
}
