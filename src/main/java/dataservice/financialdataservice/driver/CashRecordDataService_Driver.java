package dataservice.financialdataservice.driver;

import java.util.ArrayList;

import po.CashRecordLineItemPO;
import po.CashRecordReceiptPO;
import utility.TimePeriod;
import businesslogic.financialbl.CashRecordList;
import data.financialdata.stub.CashReportDataServiceSerializableImplStub;
import dataservice.financialdataservice.CashRecordDataService;

public class CashRecordDataService_Driver {
	public void drive(CashRecordDataService cashRecordService){
		CashRecordList list = new CashRecordList();
		list.add(new CashRecordLineItemPO("name", 12312, "comment"));
		CashRecordReceiptPO po = new CashRecordReceiptPO("accountId",list,123,"1s","sad2");
		boolean result = cashRecordService.addCashRecord(po);
		if(result){
			System.out.println("add CashRecord pass");
		}else{
			System.out.println("add CashRecord failed");
		}
		
		CashRecordReceiptPO findResult = cashRecordService.find("XJFYD-yyyyMMdd-xxxxx");
		if(findResult != null){
			System.out.println("find cashrecord successfully");
		}else{
			System.out.println("find cashrecord failed");
		}
		ArrayList<CashRecordReceiptPO> cashRecordList = null;
		try {
			cashRecordList = cashRecordService.mutipleConditionSearch(new TimePeriod("2014-02-12","2014-03-13"),"userName","accountName");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!cashRecordList.isEmpty()){
			System.out.println("mutiple condition find cashrecord successfully");
		}else{

			System.out.println("mutiple condition find cashrecord failed");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CashRecordDataService cashRecordService = new CashReportDataServiceSerializableImplStub();
		CashRecordDataService_Driver driver = new CashRecordDataService_Driver();
		driver.drive(cashRecordService);
	}

}
