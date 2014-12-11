package businesslogic.utilitybl;

import po.GiftPO;
import vo.GiftVO;

public class TransGiftPOToGiftVO {
	GiftPO giftPO;
	public TransGiftPOToGiftVO(GiftPO po) {
		// TODO Auto-generated constructor stub
		giftPO = po;
	}
	
	public GiftVO trans(){
		GiftVO vo = new GiftVO();
		vo.setId(giftPO.getId());
		vo.setName(giftPO.getName());
		vo.setNumber(giftPO.getNumber());
		vo.setPrice(giftPO.getLatestImportPrice());
		vo.setSum(giftPO.getNumber() * giftPO.getLatestImportPrice());
		vo.setType(giftPO.getType());
		return vo;
	}
}
