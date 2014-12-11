package businesslogic.clientbl;

import java.util.ArrayList;

import businesslogicservice.clientblservice.ClientInterface;
import po.ClientPO;
import vo.ClientClassification;
import vo.ClientLevel;
import vo.ClientVO;
import data.databaseutility.SerializableDataFactory;
import dataservice.clientdataservice.ClientDataService;
import dataservice.utility.DataFactory;

public class Client implements ClientInterface{
	ArrayList<ClientPO> clients;
	DataFactory factory;
	ClientDataService clientData;
	
	public Client(){
		super();
		factory = new SerializableDataFactory();
		clientData = factory.getClientDataService();
		clients = clientData.getClientList();
	}

	public ArrayList<ClientPO> getClientPOList() {
		return clients;
	}
	
	public ArrayList<ClientVO> getClientVOList(){
		ArrayList<ClientVO> vos = new ArrayList<ClientVO>();
		transform_POs_to_VOs(clients, vos);
		return vos;
	}
	
	
	public boolean addClient(ClientVO vo) {
		// TODO Auto-generated method stub
		if (!isExist(vo)) {
			ClientPO po = new ClientPO();
			Client.transform_VO_to_PO(po, vo);
			clientData.Insert(po);
			clientData.finish();
			return true;
		}
		return false;
	}

	public boolean deleteClient(String num) {
		// TODO Auto-generated method stub
		ClientVO vo = findClientByNum(num);
		if (vo == null) {
			return false;
		}
		//该用户还有应收或者应付
		if ((vo.getPayable() != 0) || (vo.getReceivable() != 0)) {
			return false;
		}
		clientData.delete(num);
		clientData.finish();
		return true;
	}

	public boolean changeClient(ClientVO vo) {
		// TODO Auto-generated method stub
		if (isExist(vo)) {
			//该用户存在
			clientData = factory.getClientDataService();
			ClientPO po = new ClientPO();
			Client.transform_VO_to_PO(po, vo);
			clientData.update(po);
			clientData.finish();
			return true;
		}
		return false;
	}

	public ClientVO findClientByNum(String num) {
		// TODO Auto-generated method stub
		clientData = factory.getClientDataService();
		ClientPO po = clientData.findByNum(num);
		if (po == null) {
			return null;
		}
		
		ClientVO vo = new ClientVO();
		Client.transform_PO_to_VO(vo, po);
		return vo;
	}

	public ArrayList<ClientVO> findCientByKey(String key) {
		// TODO Auto-generated method stub
		clientData = factory.getClientDataService();
		ArrayList<ClientPO> pos = clientData.findByKey(key);
		ArrayList<ClientVO> vos = new ArrayList<ClientVO>();
		transform_POs_to_VOs(pos, vos);
		return vos;
	}

	public ArrayList<ClientVO> getClientList() {
		// TODO Auto-generated method stub
		clientData = factory.getClientDataService();
		ArrayList<ClientPO> pos = clientData.getClientList();
		ArrayList<ClientVO> vos = new ArrayList<ClientVO>();
		transform_POs_to_VOs(pos, vos);
		return vos;
	}
	
	
	public boolean changeReceivable(String clientNum, double price){
		clientData = factory.getClientDataService();
		ClientPO po = clientData.findByNum(clientNum);
		po.setNum(clientNum);
		clientData.update(po);
		clientData.finish();
		return true;
	}
	
	public boolean changePayable(String clientNum, double price){
		clientData = factory.getClientDataService();
		ClientPO po = clientData.findByNum(clientNum);
		po.setPayable(price);
		clientData.update(po);
		clientData.finish();
		return true;
	}
	
	public boolean changeQuota(String clientNum, double quota){
		clientData = factory.getClientDataService();
		ClientPO po = clientData.findByNum(clientNum);
		po.setQuota(quota);
		clientData.update(po);
		clientData.finish();
		return true;
	}
	
	public boolean importGoods(ClientPO po, double total){
		po.setPayable(po.getPayable() + total);
		clientData.update(po);
		return true;
	}
	
	public boolean saleGoods(ClientPO po, double total){
		po.setReceivable(po.getReceivable() + total);
		if (po.getReceivable() > po.getQuota()) {
			return false;
		}else {
			clientData.update(po);
			return true;
		}
	}
	
	static void transform_PO_to_VO(ClientVO vo, ClientPO po){
		vo.setAddress(po.getAddress());
		vo.setClassification(ClientClassification.values()[po.getClassification().ordinal()]);
		vo.setDefaultSalesman(po.getDefaultSalesman());
		vo.setEmail(po.getEmail());
		vo.setLevel(ClientLevel.values()[po.getLevel().ordinal()]);
		vo.setName(po.getName());
		vo.setNum(po.getNum());
		vo.setPayable(po.getPayable());
		vo.setPostCode(po.getPostCode());
		vo.setQuota(po.getQuota());
		vo.setReceivable(po.getReceivable());
		vo.setTelephone(po.getTelephone());
	}
	
	static void transform_VO_to_PO(ClientPO po1, ClientVO vo){
		po1.setAddress(vo.getAddress());
		po1.setClassification(po.ClientClassification.valueOf(vo.getClassification().toString()));
		po1.setDefaultSalesman(vo.getDefaultSalesman());
		po1.setEmail(vo.getEmail());
		po1.setLevel(po.ClientLevel.valueOf(vo.getLevel().toString()));
		po1.setName(vo.getName());
		po1.setNum(vo.getNum());
		po1.setPayable(vo.getPayable());
		po1.setPostCode(vo.getPostCode());
		po1.setQuota(vo.getQuota());
		po1.setReceivable(vo.getReceivable());
		po1.setTelephone(vo.getTelephone());
	}
	
	public void transform_VOs_to_POs(ArrayList<ClientVO> vos, ArrayList<ClientPO> pos) {
		if (pos.size() != 0) {
			return;
		}
		for (int i = 0; i < vos.size(); i++) {
			ClientPO po = new ClientPO();
			transform_VO_to_PO(po, vos.get(i));
			pos.add(po);
		}
	}
	
	public void transform_POs_to_VOs(ArrayList<ClientPO> pos, ArrayList<ClientVO> vos) {
		if (vos.size() != 0) {
			return;
		}
		for (int i = 0; i < pos.size(); i++) {
			ClientVO vo = new ClientVO();
			transform_PO_to_VO(vo, pos.get(i));
			vos.add(vo);
		}
	}
	
	//判断客户是否存在
	private boolean isExist(ClientVO vo){
		ClientDataService clientData = factory.getClientDataService();
		if (clientData.findByNum(vo.getNum()) != null) {
			return true;
		}
		
		return false;
	}

	public boolean payToCLient(String clientID, double price) {
		// TODO Auto-generated method stub
		ClientPO po = clientData.findByNum(clientID);
		double payable = po.getPayable();
		double temp = payable - price;
		if (temp < 0) {
			return false;
		}else {
			po.setPayable(temp);
			clientData.update(po);
			return true;
		}
	}

	public boolean receiveFromeClient(String clientID, double price) {
		// TODO Auto-generated method stub
		ClientPO po = clientData.findByNum(clientID);
		double substract = po.getReceivable() - price;
		if (substract >= 0) {
			po.setReceivable(substract);
		}else {
			po.setReceivable(0);
			po.setPayable(po.getPayable()-substract);
		}
		clientData.update(po);
		return true;
	}
	
}
