package po;

import java.io.Serializable;
import java.util.Date;

public abstract class PromotionPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date startDate;
	Date endDate;
	String id;
	String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	PromotionPO(){
		
	}
	
   public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Promotiontype getPtype() {
		return null;
	}



	public void setPtype(Promotiontype type) {
		
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


	public int compare(PromotionPO po){
		
		return 0;
		
	}

	//检测销售单据是否满足该促销策略所有的条件
	public boolean test(SalesPO po) {
		return true;
	}



	

}
