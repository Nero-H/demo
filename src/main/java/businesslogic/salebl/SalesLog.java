package businesslogic.salebl;

import vo.ClientVO;
import data.databaseutility.SerializableDataFactory;
import dataservice.clientdataservice.ClientDataService;
import dataservice.utility.DataFactory;

public class SalesLog {
	private SalesOperation operation;
	private DataFactory factory;
	public SalesLog() {
		// TODO Auto-generated constructor stub
		factory = new SerializableDataFactory();
	}
	
	//写日志
	public void writeLog(SalesOperation operation, ClientVO vo){
		this.operation = operation;
		ClientDataService clientDataController = factory.getClientDataService();
		clientDataController.writeLog("");
	}

	public SalesOperation getOperation() {
		return operation;
	}
	
}
