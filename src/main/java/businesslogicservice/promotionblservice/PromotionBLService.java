package businesslogicservice.promotionblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.AccountGiftPromotionVO;
import vo.AccountVoucherPromotionVO;
import vo.CustomerDiscountPromotionVO;
import vo.CustomerGiftPromotionVO;
import vo.CustomerVoucherPromotionVO;
import vo.GoodsDiscountPromotionVO;
import vo.PromotionVO;

public interface PromotionBLService extends Remote{
	public boolean addCustomerDiscount(CustomerDiscountPromotionVO vo) throws RemoteException;
	public boolean addCustomerGift(CustomerGiftPromotionVO vo)throws RemoteException;
	public boolean addGoodsDiscount(GoodsDiscountPromotionVO vo)throws RemoteException;
	public boolean addAccountVoucher (AccountVoucherPromotionVO vo)throws RemoteException;
	public boolean addAccountGift (AccountGiftPromotionVO vo) throws RemoteException;
	public boolean addCustomerVoucher(CustomerVoucherPromotionVO vo)throws RemoteException;
	public ArrayList<PromotionVO> getPromotionVOs()throws RemoteException;

}
