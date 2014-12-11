package po;

import vo.GoodsVO;
import businesslogic.stockbl.GoodsManage;
import businesslogicservice.stockblservice.GoodsInterface;

public class GiftPO {

	private String id ;
	private int number ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public double getLatestImportPrice(){
		GoodsInterface goodsInterface = new GoodsManage();
		GoodsVO vo = goodsInterface.findGoods(id);
		return vo.getRecentPrice();
	}
	
	public String getName(){
		GoodsInterface goodsInterface = new GoodsManage();
		GoodsVO vo = goodsInterface.findGoods(id);
		return vo.getGoodsName();
	}
	
	public String getType(){
		GoodsInterface goodsInterface = new GoodsManage();
		GoodsVO vo = goodsInterface.findGoods(id);
		return vo.getGoodsModelNumber();
	}
}
