package businesslogic.salebl;

import vo.GoodsInfoVO;

public class MockGoods extends GoodsInfoVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String loc;
	int number;
	double unitPrice;
	String notes;
	
	public MockGoods(String loc, int number, double unitPrice, String notes) {
		// TODO Auto-generated constructor stub
		this.loc = loc;
		this.number = number;
		this.unitPrice = unitPrice;
		this.notes = notes;
	}

	public String getLoc() {
		return loc;
	}


	@Override
	public double getUnitPrice() {
		return unitPrice;
	}

	@Override
	public String getNotes() {
		return notes;
	}
	
	@Override
	public int getNumber(){
		return number;
	}
	
}
