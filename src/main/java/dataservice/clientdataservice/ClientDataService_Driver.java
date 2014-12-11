package dataservice.clientdataservice;

import po.ClientPO;
import data.clientdata.ClientDataService_Stub;

public class ClientDataService_Driver {
	public void drive(ClientDataService clientDataservice){
		clientDataservice.Insert(new ClientPO());
		clientDataservice.delete("");
		clientDataservice.update(new ClientPO());
		if(clientDataservice.findByNum("") != null)
			System.out.println("Find by number!");
		if(clientDataservice.findByKey("demo") != null)
			System.out.println("Find by key!");
		clientDataservice.init();
		clientDataservice.finish();
	}
	
	public static void main(String[] args) {
		ClientDataService clientDataController = new ClientDataService_Stub();
		new ClientDataService_Driver().drive(clientDataController);
	}
}
