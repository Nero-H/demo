package dataservice.financialdataservice;

import java.util.ArrayList;

import po.CashRecordReceiptPO;
import utility.TimePeriod;

public interface CashRecordDataService {

	public boolean addCashRecord(CashRecordReceiptPO po);

	public CashRecordReceiptPO find(String id);

	public ArrayList<CashRecordReceiptPO> mutipleConditionSearch(
			TimePeriod period, String userName, String accountName);
	
	public void init();

	public void finish();

	public ArrayList<CashRecordReceiptPO> getList();
	
	public void writeLog(String string);
}
