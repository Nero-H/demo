package businesslogic.salebl;

import businesslogic.stockbl.GoodsManage;
import businesslogicservice.stockblservice.GoodsInterface;
import po.GoodsInfoPO;
import vo.GoodsVO;


public class SalesLineItem extends GoodsInfoPO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public double getTotal(){
		setSum(getUnitPrice() * getNumber());
		return getSum();
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
		int currentGoodsNumber = goods.getStockNumber();
		if (currentGoodsNumber < number) {
			return false;
		}else {
//			goodsInterface.saleGoods(goodsNumber, number, unitPrice);
			return true;
		}
	}

	
}
