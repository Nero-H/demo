package data.clientdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import po.ClientPO;
import data.databaseutility.FileOperate;
import data.databaseutility.Log;
import dataservice.clientdataservice.ClientDataService;

public class ClientDataImpl implements ClientDataService{
	private static ClientDataService clientDatabase = null;
	HashMap<String , ClientPO> clientList;
	
	
	private ClientDataImpl(){
		init();
	}

	public static ClientDataService getInstance(){
		if (clientDatabase == null) {
			clientDatabase = new ClientDataImpl();
		}
		return  clientDatabase;
	}
	
	public boolean Insert(ClientPO po) {
		// TODO Auto-generated method stub
		if (clientList.containsKey(po.getNum())) {
			return false;
		}
		else {
			clientList.put(po.getNum(), po);
			return true;
		}
	}

	public void delete(String num) {
		// TODO Auto-generated method stub
		clientList.remove(num);
	}

	public void update(ClientPO po) {
		// TODO Auto-generated method stub
		clientList.put(po.getNum(), po);
	}

	public ClientPO findByNum(String num) {
		// TODO Auto-generated method stub
		return clientList.get(num);
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<ClientPO> findByKey(String key) {
		// TODO Auto-generated method stub
		clientList = new HashMap<String, ClientPO>();
		if (clientList.isEmpty() || clientList == null) {
			return null;
		}
		ArrayList<ClientPO> clientPOs = new ArrayList<ClientPO>();
		Iterator iterator = clientList.entrySet().iterator();
		while (iterator.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) iterator.next();
			ClientPO po = (ClientPO) entry.getValue();
			if (po.getAddress().contains(key)||
				po.getDefaultSalesman().contains(key)||
				po.getClassification().toString().contains(key)||
				po.getEmail().contains(key)||
				po.getLevel().toString().contains(key)||
				po.getName().contains(key)||
				po.getTelephone().contains(key)
				) {
				clientPOs.add(po);
			}
		}
		if (clientPOs.size() == 0) {
			return null;
		}
		return clientPOs;
	}

	@SuppressWarnings("unchecked")
	public void init() {
		// TODO Auto-generated method stub
		FileOperate operate = new FileOperate("src/clients.ser");
		clientList = (HashMap<String, ClientPO>)operate.read();
		if (clientList == null) {
			clientList = new HashMap<String, ClientPO>();//不存在就创建一个
		}
	}

	public void finish() {
		// TODO Auto-generated method stub
		FileOperate operate = new FileOperate("src/clients.ser");
		operate.write(clientList);
	}

	public void writeLog(String content) {
		// TODO Auto-generated method stub
		Log.writeLog(content);
	}

	@SuppressWarnings("rawtypes")
	public ArrayList<ClientPO> getClientList() {
		// TODO Auto-generated method stub
		
		ArrayList<ClientPO> clientPOs = new ArrayList<ClientPO>();
		Iterator iterator = clientList.entrySet().iterator();
		while (iterator.hasNext()) {
			java.util.Map.Entry entry = (java.util.Map.Entry) iterator.next();
			clientPOs.add((ClientPO)entry.getValue());
		}
		return clientPOs;
	}

}
