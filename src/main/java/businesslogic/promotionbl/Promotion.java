package businesslogic.promotionbl;

import java.util.ArrayList;

import data.promotiondata.PromotionDataImpl;
import dataservice.promotiondataservice.PromotionDataService;
import po.AccountVoucherPromotionPO;
import po.AccountGiftPromotionPO;
import po.CustomerDiscountPromotionPO;
import po.CustomerGiftPromotionPO;
import po.CustomerVoucherPromotionPO;
import po.GoodsDiscountPromotionPO;
import po.PromotionPO;
import po.SalesPO;

public class Promotion {
	
     ArrayList<PromotionPO> promotions;
     PromotionDataService dataService;
     
     public Promotion() {
		// TODO Auto-generated constructor stub
    	 dataService=PromotionDataImpl.getInstance();
    	 promotions=dataService.getList();
	}
	
	public boolean addCustomerDiscount(CustomerDiscountPromotionPO po) {
		// TODO Auto-generated method stub
		if(test(po)){
			promotions.add(po);
			dataService.insert(po);
			return true;
		}
		
		return false;
	}

	public boolean addCustomerGift(CustomerGiftPromotionPO po) {
		// TODO Auto-generated method stub
		if(test(po)){
			promotions.add(po);
			dataService.insert(po);
			return true;
		}
		
		return false;
	}

	public boolean addGoodsDiscount(GoodsDiscountPromotionPO po) {
		// TODO Auto-generated method stub
		if(test(po)){
			promotions.add(po);
			dataService.insert(po);
			return true;
		}
		
		return false;
	}

	public boolean addAccountVoucher(AccountVoucherPromotionPO po) {
		// TODO Auto-generated method stub
		if(test(po)){
			promotions.add(po);
			dataService.insert(po);
			return true;
		}
		
		return false;
	}

	public boolean addAccountGift(AccountGiftPromotionPO po) {
		// TODO Auto-generated method stub
		if(test(po)){
			promotions.add(po);
			dataService.insert(po);
			return true;
		}
		
		return false;
	}
	
	public boolean addCustomerVoucher(CustomerVoucherPromotionPO po) {
		if(test(po)){
			promotions.add(po);
			dataService.insert(po);
			return true;
		}
		
		return false;
	}

	public boolean test(SalesPO po) {
		// TODO Auto-generated method stub
		for(PromotionPO promotionPO:promotions){
			promotionPO.test(po);
		}
		return true;
		
	}

	public ArrayList<PromotionPO> getPromotions() {
		return promotions;
	}

	public void setPromotions(ArrayList<PromotionPO> promotions) {
		this.promotions = promotions;
	}

	public boolean test(PromotionPO po) {
		// TODO Auto-generated method stub
		for(PromotionPO promotion:promotions){
			if(promotion.getPtype()==po.getPtype())
				if(promotion.compare(po)<0)
					return false;
		}
		return true;
	}


}
