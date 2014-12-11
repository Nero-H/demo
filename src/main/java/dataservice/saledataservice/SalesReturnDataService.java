package dataservice.saledataservice;

import java.util.ArrayList;

import po.SalesReturnPO;

public interface SalesReturnDataService {
	public boolean insert(SalesReturnPO po);
	public void delete(String receipts);
	public void update(SalesReturnPO po);
	public SalesReturnPO find(String receiptsID);
	public ArrayList<SalesReturnPO> getSalesReturnList();
	public void init();
	public void finish();
	public int getTodayNum();
}
