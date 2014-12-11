package data.saledata;

import java.util.ArrayList;

import po.SalesPO;
import po.SalesReturnPO;
import dataservice.saledataservice.SalesReturnDataService;

public class SalesReturnDataService_Stub implements SalesReturnDataService{

	ArrayList<SalesReturnPO> salesReturnPOs;
	
	public boolean insert(SalesReturnPO po) {
		// TODO Auto-generated method stub
		System.out.println("Add a sales return receipts.");
		return true;
	}

	public void delete(String receipts) {
		// TODO Auto-generated method stub
		System.out.println("Delete a sales return receipts.");
	}

	public void update(SalesReturnPO po) {
		// TODO Auto-generated method stub
		System.out.println("Update a sales return receipts.");
	}

	public SalesReturnPO find(String receiptsID) {
		// TODO Auto-generated method stub
		return new SalesReturnPO(new SalesPO(), "");
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Initial salesReturnData!");
	}

	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("Finish!");
	}

	public ArrayList<SalesReturnPO> getSalesReturnList() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getTodayNum() {
		// TODO Auto-generated method stub
		return 0;
	}

}
