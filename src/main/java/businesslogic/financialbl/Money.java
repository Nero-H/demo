package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import po.MoneyLineItemPO;
import po.MoneyPO;
import po.PayReceiptPO;
import po.ReceiptPO;
import po.ReceiveReceiptPO;
import utility.SerialNumber;
import utility.TimePeriod;
import vo.MoneyLineItemVO;
import vo.MoneyVO;
import vo.PayVO;
import vo.ReceiptType;
import businesslogic.clientbl.Client;
import businesslogic.userbl.LoginController;
import businesslogicservice.clientblservice.ClientInterface;
import businesslogicservice.financialblservice.MoneyBLService;
import data.databaseutility.SerializableDataFactory;
import dataservice.financialdataservice.MoneyDataService;
import dataservice.utility.DataFactory;

public class Money{
	String clientId;
	MoneyList list;
	String serialNumber;
	String userName;
	ReceiptType type;

	public Money(ReceiptType type) {
		super();
		this.type = type;
		list = new MoneyList();
	}

	public boolean addItem(MoneyLineItemVO vo) throws RemoteException {
		// TODO Auto-generated method stub
		list.addItem(new MoneyLineItemPO(vo.getAccountId(), vo.getSum(), vo
				.getComment()));
		return true;
	}

	public boolean delItem(int row) {
		return list.delete(row);
	}

	public boolean updateItem(Object value, int row, int col) {
		return list.update(value, row, col);
	}

	public String getSerialNumber() {
		// TODO Auto-generated method stub
		return serialNumber;
	}

	public boolean setClient(String clientId) {
		// TODO Auto-generated method stub
		this.clientId = clientId;
		return true;
	}
	
	public boolean setUser(String userName){
		this.userName = userName;
		return true;
	}

	public String getUser() {
		// TODO Auto-generated method stub
		return userName;
	}

	public double getSum() {
		// TODO Auto-generated method stub
		return list.getTotal();
	}

	public ArrayList<MoneyVO> mutipleConditionFindPay(TimePeriod period,
			String clientName, String userName, String accountName) {
		DataFactory factory = new SerializableDataFactory();
		MoneyDataService moneyDataService = factory.getMoneyDataService();
		ArrayList<MoneyPO> list = moneyDataService.mutipleConditionFindPay(
				period, clientName, userName, accountName);
		return convertList(list);
	}

	public ArrayList<MoneyVO> mutipleConditionFindReceive(TimePeriod period,
			String clientName, String userName, String accountName) {
		DataFactory factory = new SerializableDataFactory();
		MoneyDataService moneyDataService = factory.getMoneyDataService();
		ArrayList<MoneyPO> list = moneyDataService.mutipleConditionFindReceive(
				period, clientName, userName, accountName);
		return convertList(list);
	}

	ArrayList<MoneyVO> convertList(ArrayList<MoneyPO> poList) {
		ArrayList<MoneyVO> voList = new ArrayList<MoneyVO>();
		for (MoneyPO po : poList) {
			voList.add(new PayVO(po.getClientName(), convertMoneyListToVO(po
					.getList().getList()), po.getSum(), po.getSerialNumber(),
					po.getUserName()));
		}
		return voList;
	}

	private ArrayList<MoneyLineItemVO> convertMoneyListToVO(
			ArrayList<MoneyLineItemPO> poList) {
		ArrayList<MoneyLineItemVO> voList = new ArrayList<MoneyLineItemVO>();
		for (MoneyLineItemPO po : poList) {
			voList.add(new MoneyLineItemVO(po.getAccountName(), po.getSum(), po
					.getComment()));
		}
		return voList;
	}

	public boolean finish() {
		// TODO Auto-generated method stub
		DataFactory factory = new SerializableDataFactory();
		MoneyDataService moneyDataService = factory.getMoneyDataService();
		if (type == ReceiptType.Pay) {
			moneyDataService.addPay(new PayReceiptPO(clientId, list, list
					.getTotal(), serialNumber, userName));
		} else {
			moneyDataService.addReceive(new ReceiveReceiptPO(clientId, list,
					list.getTotal(), serialNumber, userName));
		}
		return true;
	}
	
	public void pass(ReceiptPO receipt){
		DataFactory factory = new SerializableDataFactory();
		MoneyDataService moneyDataService = factory.getMoneyDataService();
		ClientInterface clientInterface = new Client();
		if(receipt.getType() == po.ReceiptType.Pay){
			clientInterface.payToCLient(clientId, getSum());
			writeLog(moneyDataService, "从" + clientId + "处收取金额" + getSum());
		}else{
			clientInterface.receiveFromeClient(clientId, getSum());
			writeLog(moneyDataService, "支付给" + clientId + "金额" + getSum());
		}
	}
	

	void writeLog(MoneyDataService moneyDataService, String log) {
		try {
			moneyDataService.writeLog(new Date() + "\t"
					+ new LoginController().getUserIdentity() + " "
					+ new LoginController().getUserName() + " " + log);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ArrayList<MoneyVO> getList() throws RemoteException {
		DataFactory factory = new SerializableDataFactory();
		MoneyDataService moneyDataService = factory.getMoneyDataService();
		if (type == ReceiptType.Pay) {
			return convertList(moneyDataService.getPayList());
		} else {
			return convertList(moneyDataService.getReceiveList());
		}
	}

	public String getSerialNumberInitial() throws RemoteException {
		if (type == ReceiptType.Pay) {
			serialNumber = SerialNumber.getSerialNumber("FKD");
		} else {
			serialNumber = SerialNumber.getSerialNumber("SKD");
		}
		return getSerialNumber();
	}
}
