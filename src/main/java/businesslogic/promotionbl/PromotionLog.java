package businesslogic.promotionbl;

import vo.PromotionVO;

public class PromotionLog {
	
	PromotionVO vo;
	String operation;
	
	public PromotionLog() {
		// TODO Auto-generated constructor stub
	}
	
	public void writeLog(PromotionOperation operation,PromotionVO vo) {
		this.vo=vo;
		this.operation=operation.toString();
	}

}
