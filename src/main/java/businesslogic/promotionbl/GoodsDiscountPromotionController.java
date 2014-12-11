package businesslogic.promotionbl;

import java.util.ArrayList;

import po.GoodsPO;
import vo.GoodsDiscountPromotionVO;

public class GoodsDiscountPromotionController {
	
	ArrayList<GoodsPO> goodslist=new ArrayList<GoodsPO>();
	GoodsDiscountPromotion promotion=new GoodsDiscountPromotion();
	Promotion list;
	
	public GoodsDiscountPromotionController(Promotion promotion) {
		// TODO Auto-generated constructor stub
		list=promotion;
	}
	
	public boolean add(GoodsDiscountPromotionVO vo) {
		promotion.add(list, vo);
		return true;
		
	}
	
	public boolean addGoods(String id,int number) {
		promotion.addGoods(id, number);
		return true;
		
	}
	
	public boolean delGoods(String id){
		promotion.delGoods(id);
		return true;
	}

}
