package dataservice.saledataservice;

import java.util.ArrayList;

import po.SalesPO;


public interface SalesDataService {
	public boolean insert(SalesPO po);
	public void delete(String receipts);
	public void update(SalesPO po);
	public SalesPO find(String receiptsID);
	public ArrayList<SalesPO> getSalesList();
	public void init();
	public void finish();
	public int getTodayNum();
}
