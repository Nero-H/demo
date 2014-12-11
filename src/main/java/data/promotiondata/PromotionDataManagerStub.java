package data.promotiondata;

import java.util.ArrayList;
import java.util.HashMap;

import po.PromotionPO;
import po.SalesPO;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataManagerStub implements PromotionDataService{

	HashMap<PromotionPO, String> promotions=new HashMap<PromotionPO, String>();
	
	public boolean insert(PromotionPO po) {
		// TODO Auto-generated method stub
		System.out.println("Insert Successfully");
		return true;
	}

	public void delete(PromotionPO po) {
		// TODO Auto-generated method stub
		System.out.println("Delete Successfully");
	}

	

	public boolean test(PromotionPO po) {
		
		// TODO Auto-generated method stub
		System.out.println("Test Successfully");
		return true;
	}

	public boolean testSalesPO(SalesPO sp) {
		
		// TODO Auto-generated method stub
		System.out.println("The salespo is corresponding");
		return true;
	}

	public void dailyUpdate() {
		// TODO Auto-generated method stub
		System.out.println("DailyUpdate successfully");
	}

	public boolean init() {
		
		// TODO Auto-generated method stub
		System.out.println("init successfully");
		return true;
	}

	public boolean finish() {
		
		// TODO Auto-generated method stub
		System.out.println("Finish successfully");
		return true;
	}

	public ArrayList<PromotionPO> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
