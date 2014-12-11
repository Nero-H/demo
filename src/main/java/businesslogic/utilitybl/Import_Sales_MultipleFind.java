package businesslogic.utilitybl;

import java.util.ArrayList;

import po.GoodsInfoPO;
import po.Import_Sales_FatherPO;
import po.SalesFatherPO;
import utility.TimePeriod;

public class Import_Sales_MultipleFind {
	private Import_Sales_FatherPO import_salesPO;
	TimePeriod period;
	String goodsName;
	String clientId;
	String salesman;
	String storehouse;
	
	public Import_Sales_MultipleFind(Import_Sales_FatherPO po, TimePeriod period,String goodsName,String clientId,String salesman,String storehouse) {
		// TODO Auto-generated constructor stub
		this.import_salesPO = po;
		initial(period, goodsName, clientId, salesman, storehouse);
	}
	
	private void initial(TimePeriod period,String goodsName,String clientId,String salesman,String storehouse){
		this.period = period;
		this.goodsName = goodsName;
		this.clientId = clientId;
		this.salesman = salesman;
		this.storehouse = storehouse;
	}
	
	public boolean check(){
		//不满足条件则全部跳过
		if (period != null) {
			//传入的时间区间存在
			if (import_salesPO.getDate().before(period.getBefore()) || import_salesPO.getDate().after(period.getAfter())) {
				return false;
			}
		}
		
		if ((!clientId.equals("")) && (!import_salesPO.getClient().getName().equals(clientId))) {
			return false;
		}
		if (!salesman.equals("")) {
			//若有salesman参数
			SalesFatherPO po = (SalesFatherPO) import_salesPO;
			if (!(po.getSalesman().equals(salesman))) {
				return false;
			}
		}
		if ((!storehouse.equals("")) && (!import_salesPO.getStorehouse().equals(storehouse))) {
			return false;
		}
		
		//判断商品
		if(!goodsName.equals("")){
			ArrayList<GoodsInfoPO> goodsList = import_salesPO.getGoodsPOs();
			for (int j = 0; j < goodsList.size(); j++) {
				if (goodsList.get(j).getName().equals(goodsName)) {
					return true;
				}
			}
		}
		return false;
	}
}
