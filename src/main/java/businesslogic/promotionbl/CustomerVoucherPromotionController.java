package businesslogic.promotionbl;

import vo.CustomerVoucherPromotionVO;

public class CustomerVoucherPromotionController {
	
	CustomerVoucherPromotion promotion=new CustomerVoucherPromotion();
	Promotion list;
	
	public CustomerVoucherPromotionController(Promotion promotion) {
		// TODO Auto-generated constructor stub
		list=promotion;
	}
	
	public boolean add(CustomerVoucherPromotionVO vo) {
		promotion.add(list, vo);
		return true;
		
	}

}
