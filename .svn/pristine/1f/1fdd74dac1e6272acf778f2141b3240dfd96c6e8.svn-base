package businesslogic.promotionbl;


import po.GiftPO;
import po.GoodsDiscountPromotionPO;
import vo.GoodsDiscountPromotionVO;

public class GoodsDiscountPromotion {

	GoodsList goods=new GoodsList();
	GoodsDiscountPromotionPO po=new GoodsDiscountPromotionPO();
	
	
	public boolean add(Promotion list,GoodsDiscountPromotionVO vo) {
		po.setDiscount(vo.getDiscount());
		po.setStartDate(vo.getStartDate());
		po.setEndDate(vo.getEndDate());
		po.setGoods(goods.getGoods());
		list.addGoodsDiscount(po);
		return true;
		
	}
	
	public boolean addGoods(String id,int number) {
		GiftPO giftPO=new GiftPO();
		giftPO.setId(id);
		giftPO.setNumber(number);
		goods.add(giftPO);
		return true;
		
	}
	
	public boolean delGoods(String id){
		goods.del(id);
		return true;
	}
}
