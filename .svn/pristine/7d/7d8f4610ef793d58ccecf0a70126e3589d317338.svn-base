package dataservice.financialdataservice.driver;

import po.RecordPO;
import data.financialdata.stub.RecordDataServiceSerializableImplStub;
import dataservice.financialdataservice.RecordDataService;

public class RecordDataService_Driver {
	public void drive(RecordDataService recordDataService){
		recordDataService.addNewRecord(new RecordPO());
		recordDataService.init();
		recordDataService.finish();
	}
	
	public static void main(String[] args) {
		RecordDataService_Driver driver = new RecordDataService_Driver();
		RecordDataService recordDataService = new RecordDataServiceSerializableImplStub();
		driver.drive(recordDataService);
	}
}
