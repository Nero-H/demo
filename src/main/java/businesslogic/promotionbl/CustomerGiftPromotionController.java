package businesslogic.promotionbl;

import vo.CustomerGiftPromotionVO;

public class CustomerGiftPromotionController {
	
	CustomerGiftPromotion promotion=new CustomerGiftPromotion();
	Promotion list;
	
	public CustomerGiftPromotionController(Promotion promotion) {
		// TODO Auto-generated constructor stub
		list=promotion;
	}
	
    public boolean add(CustomerGiftPromotionVO vo) {
		promotion.add(list, vo);
		return true;
		
	}
    
    public boolean addGoods(String id,int num) {
    	promotion.addGoods(id, num);
		return true;
		
	}

    public boolean  delGoods(String id) {
    	promotion.delGoods(id);
		return true;
		
	}

}
