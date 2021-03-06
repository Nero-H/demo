package businesslogic.salebl;

import java.util.ArrayList;

import po.GoodsInfoPO;


public class SalesList {
	private ArrayList<SalesLineItem> salesList;
	private double total;
	
	public SalesList() {
		// TODO Auto-generated constructor stub
		salesList = new ArrayList<SalesLineItem>();
	}
	
	public SalesLineItem addOneGoods(String goodsNumber, int number, double unitPrice, String notes){
		SalesLineItem lineItem = new SalesLineItem();
		boolean isSuccess = lineItem.addGoods(goodsNumber, number, unitPrice, notes);
		if (isSuccess) {
			salesList.add(lineItem);
			return lineItem;
		}
		return null;
	}
	
	public double getTotal(){
		total = 0;
		for (int i = 0; i < salesList.size(); i++) {
			total += salesList.get(i).getTotal();
		} 
		
		return total;
	}
	
	public boolean removeGoods(int loc){
		salesList.remove(loc);
		return true;
	}

	public ArrayList<SalesLineItem> getSalesList() {
		return salesList;
	}

	public void setSalesList(ArrayList<GoodsInfoPO> salesList) {
		ArrayList<SalesLineItem> temp = new ArrayList<SalesLineItem>();
		for (int i = 0; i < salesList.size(); i++) {
			temp.add((SalesLineItem)salesList.get(i));
		}
		this.salesList = temp;
	}
	
}
