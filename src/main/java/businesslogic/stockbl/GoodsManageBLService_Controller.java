package businesslogic.stockbl;

import java.rmi.RemoteException;

import utility.MyTreeNode;
import vo.GoodsVO;
import businesslogicservice.stockblservice.GoodsManageBLService;

public class GoodsManageBLService_Controller implements GoodsManageBLService{

	public boolean addGoods(GoodsVO vo) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean deleteGoods(GoodsVO vo ) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean updateGoods (GoodsVO vo) {
		// TODO Auto-generated method stub
		return true;
	}
	public GoodsVO findGoods(GoodsVO ID) {
		// TODO Auto-generated method stub
		return null;
	}
	public GoodsVO findGoods(String ID) {
		// TODO Auto-generated method stub
		return null;
	}
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	public MyTreeNode getRoot() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setRoot(MyTreeNode node) throws RemoteException {
		// TODO Auto-generated method stub
	}
	public MyTreeNode getGoodsList() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean importGoods(String goodsID, int number, double unitPrice) {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean saleGoods(String goodsID, int number, double unitPrice) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
