package businesslogic.importbl;

import businesslogic.stockbl.GoodsManage;
import businesslogicservice.stockblservice.GoodsInterface;
import po.GoodsInfoPO;
import vo.GoodsVO;


public class ImportLineItem extends GoodsInfoPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public double getTotal(){
		double total = getNumber() * getUnitPrice();
		setSum(total);
		return total;
	}
	
	public boolean addGoods(String goodsNumber, int number, double unitPrice, String notes){
		setNum(goodsNumber);
		setNumber(number);
		setUnitPrice(unitPrice);
		setNotes(notes);
		GoodsInterface goodsInterface = new GoodsManage();
		GoodsVO goods = goodsInterface.findGoods(goodsNumber);
		setName(goods.getGoodsName());
		setModel(goods.getGoodsModelNumber());
		return true;
	}

}
