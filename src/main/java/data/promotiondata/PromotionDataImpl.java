package data.promotiondata;

import java.util.Date;
import java.util.ArrayList;

import po.PromotionPO;
import data.databaseutility.FileOperate;
import dataservice.promotiondataservice.PromotionDataService;

public class PromotionDataImpl implements PromotionDataService{
	
	private static PromotionDataImpl promotionDataManager;
	ArrayList<PromotionPO> promotionPOs;
	Date today=new Date();
	
	private PromotionDataImpl() {
		init();
	}

	public boolean insert(PromotionPO po) {
		// TODO Auto-generated method stub
		promotionPOs.add(po);
		finish();
		return true;
	}

	public void delete(PromotionPO po) {
		// TODO Auto-generated method stub
		
	}
	
	public static PromotionDataImpl getInstance() {
		if(promotionDataManager==null)
			promotionDataManager=new PromotionDataImpl();
		return promotionDataManager;
	}

	public ArrayList<PromotionPO> getList() {
		// TODO Auto-generated method stub
		return promotionPOs;
	}

	
	public void dailyUpdate() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public boolean init() {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> temp=(ArrayList<PromotionPO>)new FileOperate("src/promotion.ser").read();
		if(temp==null)
			promotionPOs=new ArrayList<PromotionPO>();
		else {
			promotionPOs=new ArrayList<PromotionPO>();
			for(PromotionPO po:temp){
				if(po.getEndDate().compareTo(today)>=0)
					promotionPOs.add(po);
			}
		}
		return true;
	}

	public boolean finish() {
		// TODO Auto-generated method stub
		new FileOperate("src/promotion.ser").write(promotionPOs);
		return true;
	}

	public boolean test(PromotionPO po) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
