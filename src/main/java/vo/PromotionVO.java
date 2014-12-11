package vo;

import java.io.Serializable;
import java.util.Date;

public class PromotionVO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	PromotionType type;


    String username;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public PromotionType getType() {
		return type;
	}

	
	public Date getStartDate(){
		return null;
	}
	
	public Date getEndDate(){
		return null;
	}
	
}
