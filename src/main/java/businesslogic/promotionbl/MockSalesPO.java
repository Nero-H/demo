package businesslogic.promotionbl;

import java.util.ArrayList;

import po.ClientLevel;
import po.ClientPO;
import po.GoodsInfoPO;
import po.SalesPO;

public class MockSalesPO extends SalesPO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<GoodsInfoPO> goods=new ArrayList<GoodsInfoPO>();
	
	ClientPO client;
	
	double total;	//折让前总额
	
	public ClientLevel  getClintLevel() {
		
		return client.getLevel();
		
	}
	
	@Override
	public double getTotal(){
		return total;
	}
	
	public ArrayList<GoodsInfoPO> getGoods(){
		return goods;
	}
	
	

}
