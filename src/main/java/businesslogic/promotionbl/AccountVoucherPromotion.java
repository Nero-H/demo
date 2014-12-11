package businesslogic.promotionbl;

import po.AccountVoucherPromotionPO;
import vo.AccountVoucherPromotionVO;

public class AccountVoucherPromotion {

 
	AccountVoucherPromotionPO accountVoucherPromotionPO=new AccountVoucherPromotionPO();
	
    public boolean add(Promotion list,AccountVoucherPromotionVO vo) {
		accountVoucherPromotionPO.setAccount(vo.getAccount());
		accountVoucherPromotionPO.setEndDate(vo.getEndDate());
		accountVoucherPromotionPO.setStartDate(vo.getStartDate());
		accountVoucherPromotionPO.setVoucher(vo.getVoucher());
		list.addAccountVoucher(accountVoucherPromotionPO);
		return true;
		
	}
}
