package businesslogic.importbl;

import vo.ClientVO;
import data.databaseutility.SerializableDataFactory;
import dataservice.clientdataservice.ClientDataService;
import dataservice.utility.DataFactory;

public class ImportLog {
	
	private ImportOperation operation;
	private DataFactory factory;
	
	public ImportLog() {
		// TODO Auto-generated constructor stub
		factory = new SerializableDataFactory();
	}
	
	//写日志
	public void writeLog(ImportOperation operation, ClientVO vo){
		this.operation = operation;
		ClientDataService clientDataController = factory.getClientDataService();
		clientDataController.writeLog("");
	}

	public ImportOperation getOperation() {
		return operation;
	}
	
}
