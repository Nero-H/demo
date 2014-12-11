package businesslogic.promotionbl;

import vo.CustomerDiscountPromotionVO;

public class CustomerDiscountPromotionController {
	
	CustomerDiscountPromotion promotion=new CustomerDiscountPromotion();
	Promotion list;
	
	public CustomerDiscountPromotionController(Promotion promotion) {
		// TODO Auto-generated constructor stub
		list=promotion;
	}
	
	public boolean add(CustomerDiscountPromotionVO vo) {
		promotion.add(list, vo);
		return true;
		
	}


}
