package businesslogic.promotionbl;


import po.ClientLevel;
import po.CustomerGiftPromotionPO;
import po.GiftPO;
import vo.CustomerGiftPromotionVO;

public class CustomerGiftPromotion {
	
	GoodsList goods=new GoodsList();
	CustomerGiftPromotionPO po=new CustomerGiftPromotionPO();;
	
    public boolean add(Promotion list,CustomerGiftPromotionVO vo) {
    	po.setCustomerlevel(ClientLevel.valueOf(vo.getCustomerlevel().toString()));
		po.setStartDate(vo.getStartDate());
		po.setEndDate(vo.getEndDate());
		po.setGifts(goods.getGoods());
		return true;
		
	}
    
    public boolean addGoods(String id,int num) {
    	GiftPO giftPO=new GiftPO();
    	giftPO.setId(id);
    	giftPO.setNumber(num);
    	goods.add(giftPO);
		return true;
		
	}

    public boolean  delGoods(String id) {
    	goods.del(id);
		return true;
		
	}

}
