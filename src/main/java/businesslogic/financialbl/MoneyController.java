package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import utility.TimePeriod;
import vo.MoneyLineItemVO;
import vo.MoneyVO;
import vo.ReceiptType;
import businesslogicservice.financialblservice.MoneyBLService;

public class MoneyController extends UnicastRemoteObject implements MoneyBLService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Money money;
	ReceiptType type;
	
	public MoneyController(ReceiptType type) throws RemoteException{
		money = new Money(type);
		this.type = type;
	}
	
	public boolean addItem(MoneyLineItemVO vo) throws RemoteException {
		return money.addItem(vo);
	}

	public boolean delItem(int row) {
		return money.delItem(row);
	}

	public boolean updateItem(Object value, int row, int col) {
		return money.updateItem(value, row, col);
	}

	public String getSerialNumber() {
		return money.getSerialNumber();
	}

	public boolean setClient(String clientName) {
		return money.setClient(clientName);
	}

	public boolean setUser(String userName){
		return money.setUser(userName);
	}
	
	public String getUser() {
		return money.getUser();
	}

	public double getSum() {
		return money.getSum();
	}

	public ArrayList<MoneyVO> mutipleConditionFindPay(TimePeriod period,
			String clientName, String userName,String accountName) {
		return money.mutipleConditionFindPay(period, clientName, userName,accountName);
	}

	public ArrayList<MoneyVO> mutipleConditionFindReceive(TimePeriod period,
			String clientName, String userName,String accountName) {
		return money.mutipleConditionFindReceive(period, clientName, userName,accountName);
	}

	public boolean finish() {
		return money.finish();
	}

	public ArrayList<MoneyVO> getList() throws RemoteException {
		return money.getList();
	}

	@Override
	public String getSerialNumberInitial() throws RemoteException {
		// TODO Auto-generated method stub
		return money.getSerialNumberInitial();
	}



}
