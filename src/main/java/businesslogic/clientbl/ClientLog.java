package businesslogic.clientbl;

import vo.ClientVO;
import data.databaseutility.SerializableDataFactory;
import dataservice.clientdataservice.ClientDataService;
import dataservice.utility.DataFactory;

public class ClientLog {
	String operation;
	ClientVO client;
	DataFactory factory;
	
	public ClientLog() {
		// TODO Auto-generated constructor stub
		factory = new SerializableDataFactory();
	}
	
	//写日志
	public void writeLog(ClientOperation operation, ClientVO vo){
		this.operation = operation.toString();
		this.client = vo;
		ClientDataService clientDataController = factory.getClientDataService();
		clientDataController.writeLog("");
	}
}
