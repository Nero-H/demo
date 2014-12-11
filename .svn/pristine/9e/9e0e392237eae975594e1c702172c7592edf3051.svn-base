package businesslogic.promotionbl;

import vo.AccountGiftPromotionVO;

public class AccountGiftPromotionController {
	
	AccountGiftPromotion promotion=new AccountGiftPromotion();
	Promotion list;
	
	public AccountGiftPromotionController(Promotion promotion) {
		// TODO Auto-generated constructor stub
		list=promotion;
	}
	
    public boolean add(AccountGiftPromotionVO vo) {
		promotion.add(list,vo);
		return false;
		
	}
    
    public boolean addGoods(String id,int number) {
    	promotion.addGoods(id, number);
		return false;
		
	}

    public boolean  delGoods(String id) {
    	promotion.delGoods(id);
		return false;
		
	}

}
