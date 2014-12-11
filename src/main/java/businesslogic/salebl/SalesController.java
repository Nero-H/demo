package businesslogic.salebl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vo.ClientVO;
import vo.GiftVO;
import vo.SalesInfo;
import vo.SalesInfoVO;
import vo.SalesVO;
import businesslogic.clientbl.Client;
import businesslogic.stockbl.GoodsManage;
import businesslogicservice.saleblservice.SalesBLService;
import businesslogicservice.stockblservice.GoodsInterface;

public class SalesController extends UnicastRemoteObject implements SalesBLService{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sales sales;
	private Client client;
	private GoodsInterface goodsManage;
	
	public SalesController() throws RemoteException {
		super();
		sales = new Sales();
		client = new Client();
		goodsManage = new GoodsManage();
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<ClientVO> showClientList() throws RemoteException {
		// TODO Auto-generated method stub
		return client.getClientList();
	}


	public boolean addClient(ClientVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.addClient(vo);
	}

	public boolean addGoods(String goodsNumber, int number, double unitPrice, String notes) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.addGoods(goodsNumber, number, unitPrice, notes);
	}

	public boolean addOtherInfo(SalesInfoVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.addOtherInfo(vo);
	}

	public ArrayList<SalesVO> showSales() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.showSales();
	}


	public ArrayList<SalesVO> showSalesReturn() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.showSalesReturn();
	}

	
	public boolean salesReturn(int loc) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.salesReturn(loc);
	}

	public double getTotal() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.getTotal();
	}

	public boolean creatSales() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.creatSales();
	}

	public void endSales() throws RemoteException {
		// TODO Auto-generated method stub
		sales.endSales();
	}

	public boolean removeClient() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.removeClient();
	}

	public boolean removeGoods(int loc) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.removeGoods(loc);
	}

	public boolean updateSales(String receiptsID, boolean isPass) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.updateSales(receiptsID, isPass);
	}

	public boolean updateSalesReturn(String receiptsID, boolean isPass) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.updateSalesReturn(receiptsID, isPass);
	}

	public boolean updateSalesStart(String receiptsID) throws RemoteException {
		// TODO Auto-generated method stub
		return sales.updateSalesStart(receiptsID);
	}

	public ArrayList<GiftVO> getGiftList() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.getGiftList();
	}

	public SalesInfo getSalesInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return sales.getSalesInfo();
	}

	@Override
	public boolean updateSales() throws RemoteException{
		// TODO Auto-generated method stub
		return sales.update();
	}

}
