package data.stockdata;

import java.util.ArrayList;
import java.util.Date;

import po.StockCheckListPO;
import po.StockDailyCheckListPO;
import data.databaseutility.FileOperate;
import dataservice.stockdataservice.Stock_controller_dataService;

public class StockDataImpl implements Stock_controller_dataService{

	private static StockDataImpl unique =null;
	ArrayList<StockCheckListPO> stockCheckList ;
	ArrayList<StockDailyCheckListPO> stockDailyCheckList ;
	private StockDataImpl()  {
		init();
	}
	
	public static  Stock_controller_dataService getInstance() {
		// TODO Auto-generated method stub
		if (unique == null) {
			unique = new StockDataImpl();
		}
			return unique;
	}
	
	
	@SuppressWarnings("unchecked")
	public void init()  {
		// TODO Auto-generated method stub
		FileOperate operate = new FileOperate("src/stockcheck.ser");
		stockCheckList = (ArrayList< StockCheckListPO>) operate.read();
		if (stockCheckList == null) {
			stockCheckList = new ArrayList<StockCheckListPO>();
		}
	}

	public void finish()  {
		// TODO Auto-generated method stub
		FileOperate operate = new FileOperate("src/stockcheck.ser");
		operate.write(stockCheckList);
		
	}

	
	public ArrayList<StockCheckListPO> checkStock(Date d1, Date d2) {
		// TODO Auto-generated method stub
		ArrayList<StockCheckListPO> list =new ArrayList< StockCheckListPO>();
		if (d1.after(d2)) {
			return null;
		} else {
			if (stockCheckList.isEmpty()||stockCheckList == null) {
				return null;
			} 
			
			for(StockCheckListPO stockCheckListPOs:stockCheckList){
				if ((stockCheckListPOs.getDate().after(d1)&&stockCheckListPOs.getDate().before(d2))||stockCheckListPOs.getDate().equals(d1)||stockCheckListPOs.getDate().equals(d2)) {
					list.add(stockCheckListPOs);
					
				}
			}
			return list;
		}
		
		
	}

	

	

	public boolean addStock(StockCheckListPO stockCheckListPO) {
		// TODO Auto-generated method stub
		stockCheckList.add( stockCheckListPO);
		return true;
	}

	

}
