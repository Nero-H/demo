package businesslogic.promotionbl;

import po.ClientLevel;
import po.CustomerDiscountPromotionPO;
import vo.CustomerDiscountPromotionVO;

public class CustomerDiscountPromotion {
	
	CustomerDiscountPromotionPO po=new CustomerDiscountPromotionPO();
	
    public boolean add(Promotion list,CustomerDiscountPromotionVO vo) {
    	po.setCustomerLevel(ClientLevel.valueOf(vo.getCustomerLevel().toString()));
		po.setStartDate(vo.getStartDate());
		po.setEndDate(vo.getEndDate());
		po.setDiscount(vo.getDiscount());
		list.addCustomerDiscount(po);
		
		return true;
		
	}



}
