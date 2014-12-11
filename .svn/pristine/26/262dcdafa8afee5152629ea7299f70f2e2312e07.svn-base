package businesslogic.promotionbl;

import po.ClientLevel;
import po.CustomerVoucherPromotionPO;
import vo.CustomerVoucherPromotionVO;



public class CustomerVoucherPromotion {
	
	CustomerVoucherPromotionPO po=new CustomerVoucherPromotionPO();
	
	public boolean add(Promotion list,CustomerVoucherPromotionVO vo) {
		po.setCustomerLevel(ClientLevel.valueOf(vo.getCustomerLevel().toString()));
		po.setStartDate(vo.getStartDate());
		po.setEndDate(vo.getEndDate());
		po.setVoucher(vo.getVoucher());
		list.addCustomerVoucher(po);
		return true;
	}

}
