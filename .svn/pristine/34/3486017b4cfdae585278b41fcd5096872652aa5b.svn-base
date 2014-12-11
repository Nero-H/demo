package po;

import java.io.Serializable;
import java.util.Date;

public class CustomerDiscountPromotionPO extends PromotionPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date startDate;
	Date endDate;
	ClientLevel customerLevel;
	double discount;
	Promotiontype ptype=Promotiontype.CustomerDiscount;
	

	public Promotiontype getPtype() {
		return ptype;
	}

	public void setPtype(Promotiontype ptype) {
		this.ptype = ptype;
	}

	public CustomerDiscountPromotionPO() {
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

	public ClientLevel getCustomerLevel() {
		return customerLevel;
	}

	public void setCustomerLevel(ClientLevel clientLevel) {
		this.customerLevel = clientLevel;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	
	@Override
	public boolean test(SalesPO po) {
		if(po.getDate().compareTo(endDate)<=0)
			if(po.getClient().getLevel().ordinal()>(customerLevel.ordinal()))
					po.setAfterDiscount(po.getBeforeDiscount()*discount/10);
				
		return true;
	}
	
	public int compare(PromotionPO po){
		CustomerDiscountPromotionPO temp=(CustomerDiscountPromotionPO)po;
		if(customerLevel==temp.getCustomerLevel())
			if(startDate.compareTo(temp.getStartDate())<=0)
				if(endDate.compareTo(temp.getEndDate())>=0)
					return -1;
		return 0;
		
	}


}
