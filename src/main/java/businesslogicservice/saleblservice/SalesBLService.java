package businesslogicservice.saleblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ClientVO;
import vo.GiftVO;
import vo.SalesInfo;
import vo.SalesInfoVO;
import vo.SalesVO;

public interface SalesBLService extends Remote{
	public ArrayList<ClientVO> showClientList() throws RemoteException;	//显示客户列表
	public boolean addClient(ClientVO vo) throws RemoteException;	//添加销售商
	public boolean removeClient() throws RemoteException;			//remove client
	public boolean addGoods(String loc, int number, double unitPrice, String notes) throws RemoteException;	//添加销售商品
	public boolean removeGoods(int loc) throws RemoteException;
	public boolean addOtherInfo(SalesInfoVO vo) throws RemoteException;
	public ArrayList<SalesVO> showSales() throws RemoteException;	//显示销售单
	public ArrayList<SalesVO> showSalesReturn() throws RemoteException;	//显示销售退货单
	public boolean salesReturn(int loc) throws RemoteException;	//销售的退货
	public double getTotal() throws RemoteException;	//计算总价
	public SalesInfo getSalesInfo() throws RemoteException;	//获得折让等信息
	public boolean creatSales() throws RemoteException;//生成销售单
	public void endSales() throws RemoteException;	//结束销售回合
	public boolean updateSales(String receiptsID, boolean isPass) throws RemoteException;	//更新销售单
	public boolean updateSales() throws RemoteException;
	public boolean updateSalesStart(String receiptsID) throws RemoteException;	//更新开始
	public boolean updateSalesReturn(String receiptsID , boolean isPass) throws RemoteException;	//更新销售退货单
	public ArrayList<GiftVO> getGiftList() throws RemoteException;	//获得赠品列表
}
