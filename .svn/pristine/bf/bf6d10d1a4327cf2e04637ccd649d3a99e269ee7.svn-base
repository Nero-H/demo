package dataservice.financialdataservice;

import java.util.ArrayList;

import po.MoneyPO;
import po.PayReceiptPO;
import po.ReceiveReceiptPO;
import utility.TimePeriod;
import vo.ReceiptType;

public interface MoneyDataService {

	public boolean addPay(PayReceiptPO po);

	public boolean addReceive(ReceiveReceiptPO po);

	public PayReceiptPO findPay(String id);
	
	public ReceiveReceiptPO findReceive(String id);

	public ArrayList<MoneyPO> mutipleConditionFindPay(TimePeriod period, String clientName,String userName,String accountName);
	
	public ArrayList<MoneyPO> mutipleConditionFindReceive(TimePeriod period, String clientName,String userName,String accountName);
	
	public void init();

	public void finish(ReceiptType type);
	
	public void writeLog(String string);
	
	public ArrayList<MoneyPO> getPayList();
	
	public ArrayList<MoneyPO> getReceiveList();
}
