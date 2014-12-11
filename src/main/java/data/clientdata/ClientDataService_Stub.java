package data.clientdata;

import java.util.ArrayList;

import po.ClientPO;
import dataservice.clientdataservice.ClientDataService;

public class ClientDataService_Stub implements ClientDataService{

	ArrayList<ClientPO> clientPOs;
	
	
	public boolean Insert(ClientPO po) {
		// TODO Auto-generated method stub
		System.out.println("Add a client.");
		return true;
	}

	public void delete(String num) {
		// TODO Auto-generated method stub
		System.out.println("Delete a client.");
	}

	public void update(ClientPO po) {
		// TODO Auto-generated method stub
		System.out.println("Update a client.");
	}

	public ClientPO findByNum(String Num) {
		// TODO Auto-generated method stub
		return new ClientPO();
	}

	public ArrayList<ClientPO> findByKey(String key) {
		// TODO Auto-generated method stub
		return new ArrayList<ClientPO>();
	}

	public void init() {
		// TODO Auto-generated method stub
		System.out.println("Initial clientData!");
	}

	public void finish() {
		// TODO Auto-generated method stub
		System.out.println("Finish!");
	}

	public void writeLog(String content) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ClientPO> getClientList() {
		// TODO Auto-generated method stub
		return null;
	}

}
