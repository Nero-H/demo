package businesslogic.promotionbl;

import po.AccountGiftPromotionPO;
import po.GiftPO;
import vo.AccountGiftPromotionVO;

public class AccountGiftPromotion {
	
	AccountGiftPromotionPO accountGiftPromotionPO=new AccountGiftPromotionPO();

    GoodsList goods=new GoodsList();
	
    public boolean add(Promotion list,AccountGiftPromotionVO vo) {
    	accountGiftPromotionPO.setAccount(vo.getAccount());
    	accountGiftPromotionPO.setEndDate(vo.getEndDate());
    	accountGiftPromotionPO.setStartDate(vo.getStartDate());
    	accountGiftPromotionPO.setGifts(goods.getGoods());
		list.addAccountGift(accountGiftPromotionPO);
		return true;
		
	}
    
    public boolean addGoods(String id,int number) {
    	GiftPO giftPO=new GiftPO();
    	giftPO.setId(id);
    	giftPO.setNumber(number);
    	goods.add(giftPO);
		return true;
		
	}

    public boolean  delGoods(String id) {
    	goods.del(id);
		return true;
		
	}

}
