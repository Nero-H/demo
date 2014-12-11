package businesslogic.promotionbl;

import java.util.ArrayList;

import vo.AccountGiftPromotionVO;
import vo.AccountVoucherPromotionVO;
import vo.CustomerDiscountPromotionVO;
import vo.CustomerGiftPromotionVO;
import vo.CustomerVoucherPromotionVO;
import vo.GoodsDiscountPromotionVO;
import vo.PromotionVO;
import businesslogicservice.promotionblservice.PromotionBLService;

public class PromotionManagerStub implements PromotionBLService{

	
	public PromotionManagerStub() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean addCustomerDiscount(CustomerDiscountPromotionVO cdpv) {
		// TODO Auto-generated method stub
		System.out.println("Add a CustomerDiscountPromotion successfully");
		return true;
	}

	public boolean addCustomerGift(CustomerGiftPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addGoodsDiscount(GoodsDiscountPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAccountVoucher(AccountVoucherPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addAccountGift(AccountGiftPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addCustomerVoucher(CustomerVoucherPromotionVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<PromotionVO> getPromotionVOs() {
		// TODO Auto-generated method stub
		return null;
	}



	

}
