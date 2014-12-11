package po;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

public class AccountGiftPromotionPO extends PromotionPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date startDate;
	Date endDate;
	double account; 
	ArrayList<GiftPO> gifts=new ArrayList<GiftPO>();
	Promotiontype ptype=Promotiontype.AccountGift;
	
	public ArrayList<GiftPO> getGifts() {
		return gifts;
	}


	public void setGifts(ArrayList<GiftPO> gifts) {
		this.gifts = gifts;
	}


	public Promotiontype getPtype() {
		return ptype;
	}


	public void setPtype(Promotiontype ptype) {
		this.ptype = ptype;
	}


	public AccountGiftPromotionPO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}


	public void delGoods(GoodsPO po){
		
	}
	
	
	public void addGoods(GoodsPO po,Integer i){
		
	}
	
	@Override
	public boolean test(SalesPO po){
		if(po.getBeforeDiscount()>=account)
			if(po.getDate().compareTo(endDate)<=0){
				po.setGiftGoods(gifts);;
			}
		return true;
	}
	
   public int compare(PromotionPO po){
	   AccountGiftPromotionPO temp=(AccountGiftPromotionPO)po;
		if(temp.getAccount()==account)
			if(startDate.compareTo(temp.getStartDate())<=0)
				if(endDate.compareTo(temp.getEndDate())>=0)
						return -1;
		return 0;
		
	}
	
}
