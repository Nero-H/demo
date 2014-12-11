package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.AccountGiftPromotionPO;
import po.AccountVoucherPromotionPO;
import po.CustomerDiscountPromotionPO;
import po.CustomerGiftPromotionPO;
import po.CustomerVoucherPromotionPO;
import po.GoodsDiscountPromotionPO;
import vo.AccountGiftPromotionVO;
import vo.AccountVoucherPromotionVO;
import vo.CustomerDiscountPromotionVO;
import vo.CustomerGiftPromotionVO;
import vo.CustomerVoucherPromotionVO;
import vo.GoodsDiscountPromotionVO;
import vo.PromotionVO;
import businesslogicservice.promotionblservice.PromotionBLService;

public class PromotionController extends UnicastRemoteObject implements PromotionBLService{

	public PromotionController() throws RemoteException {
		super();
		promotion=new Promotion();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Promotion promotion;
	
	


	public boolean addCustomerDiscount(CustomerDiscountPromotionVO vo) {
		// TODO Auto-generated method stub
		CustomerDiscountPromotionPO po=(CustomerDiscountPromotionPO) new TransformPromotionPV().transform_vo_to_po(vo);
		if(promotion.addCustomerDiscount(po)) 
			return true;
		return false;
	}

	public boolean addCustomerGift(CustomerGiftPromotionVO vo) {
		// TODO Auto-generated method stub
		CustomerGiftPromotionPO po=(CustomerGiftPromotionPO)new TransformPromotionPV().transform_vo_to_po(vo);
		if(promotion.addCustomerGift(po))
			return true;
		return false;
	}

	public boolean addGoodsDiscount(GoodsDiscountPromotionVO vo) {
		// TODO Auto-generated method stub
		GoodsDiscountPromotionPO po=(GoodsDiscountPromotionPO) new TransformPromotionPV().transform_vo_to_po(vo);
		if(promotion.addGoodsDiscount(po))
			return true;
		return false;
	}

	public boolean addAccountVoucher(AccountVoucherPromotionVO vo) {
		// TODO Auto-generated method stub
		AccountVoucherPromotionPO po=(AccountVoucherPromotionPO)new TransformPromotionPV().transform_vo_to_po(vo);
		if(promotion.addAccountVoucher(po))
			return true;
		return false;
	}

	public boolean addAccountGift(AccountGiftPromotionVO vo) {
		// TODO Auto-generated method stub
		AccountGiftPromotionPO po=(AccountGiftPromotionPO)new TransformPromotionPV().transform_vo_to_po(vo);
		if(promotion.addAccountGift(po))
			return true;
		return false;
	}

	public boolean addCustomerVoucher(CustomerVoucherPromotionVO vo) {
		// TODO Auto-generated method stub
		CustomerVoucherPromotionPO po=(CustomerVoucherPromotionPO)new TransformPromotionPV().transform_vo_to_po(vo);
		if(promotion.addCustomerVoucher(po))
			return true;
			
		return false;
	}

	public ArrayList<PromotionVO> getPromotionVOs() {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> vos=new ArrayList<PromotionVO>();
		vos.addAll(new TransformPromotionPV().transformArrayList_promotion_po_to_vo(promotion.getPromotions()));
		return vos;
	}

	
	
	
}
