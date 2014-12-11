package data.financialdata.stub;


import java.util.ArrayList;

import po.AccountPO;
import po.ClientPO;
import po.MoneyLineItemPO;
import po.MoneyPO;
import po.PayReceiptPO;
import po.ReceiveReceiptPO;
import po.UserIdentity;
import po.UserPO;
import utility.LikeHashMap;
import utility.TimePeriod;
import vo.ReceiptType;
import businesslogic.financialbl.MoneyList;
import dataservice.financialdataservice.MoneyDataService;

public class MoneyDataServiceSerializableImplStub implements MoneyDataService{
	LikeHashMap<String,PayReceiptPO> payList = new LikeHashMap<String,PayReceiptPO>();
	ClientPO client = new ClientPO();
	ArrayList<MoneyLineItemPO> lineItemList = new ArrayList<MoneyLineItemPO>();
	UserPO user = new UserPO("User1","x007","325400",UserIdentity.Manager);
	AccountPO account = new AccountPO("Nero",2133);
	ArrayList<MoneyLineItemPO> MoneyLineItemList = new ArrayList<MoneyLineItemPO>();

	public boolean addPay(PayReceiptPO po) {
		// TODO Auto-generated method stub
		boolean isIn = payList.containsValue(po);
		if(isIn){
			payList.put(po.getSerialNumber().toString(),po);
			System.out.println("add pay receipt successfully");
		}else{
			System.out.println("add pay receipt failed");
		}
		return isIn;
	}

	public boolean addReceive(ReceiveReceiptPO po) {
		// TODO Auto-generated method stub
		System.out.println("add receive receipt successfully");
		return true;
	}
	
	public PayReceiptPO findPay(String id) {
		// TODO Auto-generated method stub
		System.out.println("findPay successfully");
		lineItemList.add(new MoneyLineItemPO("accountId",1231,"comment"));
		MoneyList list = new MoneyList();
		return new PayReceiptPO("clientName", list, 123, "serialNumber", "userName");
	}


	public ReceiveReceiptPO findReceive(String id) {
		// TODO Auto-generated method stub
		System.out.println("findReceive successfully");
		MoneyLineItemList.add(new MoneyLineItemPO("accountId",1231,"comment"));
		return new ReceiveReceiptPO("clientName", new MoneyList(), 123, "serialNumber", "userName");
	}

	public ArrayList<PayReceiptPO> mutipleConditionFindPay(TimePeriod period,
			String clientName, String userName) {
		// TODO Auto-generated method stub
		ArrayList<PayReceiptPO> list = new ArrayList<PayReceiptPO>();
		return list;
	}

	public ArrayList<ReceiveReceiptPO> mutipleConditionFindReceive(TimePeriod period,
			String clientName, String userName) {
		// TODO Auto-generated method stub
		ArrayList<ReceiveReceiptPO> list = new ArrayList<ReceiveReceiptPO>();
		return list;
	}
	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void finish(ReceiptType type) {
		// TODO Auto-generated method stub
		
	}

	public void writeLog(String string) {
		// TODO Auto-generated method stub
		
	}


	public ArrayList<MoneyPO> getPayList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MoneyPO> getReceiveList() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MoneyPO> mutipleConditionFindPay(TimePeriod period,
			String clientName, String userName, String accountName) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MoneyPO> mutipleConditionFindReceive(TimePeriod period,
			String clientName, String userName, String accountName) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
