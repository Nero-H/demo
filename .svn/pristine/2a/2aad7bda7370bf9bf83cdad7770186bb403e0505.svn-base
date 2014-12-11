package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class CustomerGiftPromotionPO extends PromotionPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date startDate;
	Date endDate;
	ClientLevel customerlevel; //客户等级  ，customerLevel大于一，小于五
	ArrayList<GiftPO> gifts=new ArrayList<GiftPO>();
	Promotiontype ptype=Promotiontype.CustomerGift;
	
	public CustomerGiftPromotionPO() {
		// TODO Auto-generated constructor stub
	}
	
	
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

	public ClientLevel getCustomerlevel() {
		return customerlevel;
	}

	public void setCustomerlevel(ClientLevel customerlevel) {
		this.customerlevel = customerlevel;
	}

	public void delGoods(GoodsPO po){
		
	}
	
	public void addGoods(GoodsPO po,Integer i){
		
	}
	
	@Override
	public boolean test(SalesPO po) {
		if(po.getDate().compareTo(endDate)<=0)
			if(po.getClient().getLevel().ordinal()>(customerlevel.ordinal()))
				po.setGiftGoods(gifts);
		return true;
	}


	public int compare(PromotionPO po){
		CustomerGiftPromotionPO temp=(CustomerGiftPromotionPO)po;
		if(customerlevel==temp.getCustomerlevel())
			if(startDate.compareTo(temp.getStartDate())<=0)
				if(endDate.compareTo(temp.getEndDate())>=0)
					return -1;
		return 0;
		
	}

}
