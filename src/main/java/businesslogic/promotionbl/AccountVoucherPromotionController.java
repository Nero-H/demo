package businesslogic.promotionbl;

import vo.AccountVoucherPromotionVO;

public class AccountVoucherPromotionController {
	
	AccountVoucherPromotion accountVoucherPromotion=new AccountVoucherPromotion();
	Promotion list;
	
	public AccountVoucherPromotionController(Promotion promotion) {
		// TODO Auto-generated constructor stub
		list=promotion;
	}
	
	public boolean add(AccountVoucherPromotionVO vo) {
		accountVoucherPromotion.add(list, vo);
		return true;
		
	}

}
