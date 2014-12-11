package data.financialdata.stub;

import java.util.ArrayList;

import po.CashRecordLineItemPO;
import po.CashRecordReceiptPO;
import po.UserPO;
import utility.LikeHashMap;
import utility.TimePeriod;
import businesslogic.financialbl.CashRecordList;
import dataservice.financialdataservice.CashRecordDataService;

public class CashReportDataServiceSerializableImplStub implements CashRecordDataService{
	LikeHashMap<String,CashRecordReceiptPO> cashRecordList = new LikeHashMap<String,CashRecordReceiptPO>();
	
	public boolean addCashRecord(CashRecordReceiptPO po) {
		// TODO Auto-generated method stub
		cashRecordList.put(po.getSerialNumber().toString(),po);
		System.out.println("add CashRecord successfully");
		return true;
	}

	public CashRecordReceiptPO find(String id) {
		// TODO Auto-generated method stub
		return cashRecordList.get(id);
	}

	public ArrayList<CashRecordReceiptPO> mutipleConditionSearch(TimePeriod period,
			UserPO user) {
		// TODO Auto-generated method stub
		ArrayList<CashRecordReceiptPO> list = new ArrayList<CashRecordReceiptPO>();
		CashRecordList itemList = new CashRecordList();
		itemList.add(new CashRecordLineItemPO("name", 23, "comment"));
		list.add(new CashRecordReceiptPO("accountId",itemList,123,"wqe","sdfju"));
		return list;
	}
	
	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void finish() {
		// TODO Auto-generated method stub
		
	}

	public void writeLog(String string) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<CashRecordReceiptPO> mutipleConditionSearch(
			TimePeriod period, String userName, String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<CashRecordReceiptPO> getList() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
