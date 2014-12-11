package server;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import vo.ReceiptType;
import businesslogic.clientbl.ClientController;
import businesslogic.examingbl.ExamingController;
import businesslogic.financialbl.AccountController;
import businesslogic.financialbl.CashRecordController;
import businesslogic.financialbl.MoneyController;
import businesslogic.importbl.ImportController;
import businesslogic.promotionbl.PromotionController;
import businesslogic.salebl.SalesController;
import businesslogic.stockbl.GoodsManageController;
import businesslogic.userbl.LoginController;
import businesslogic.userbl.UserController;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.examingblservice.Examingblservice;
import businesslogicservice.financialblservice.AccountBLService;
import businesslogicservice.financialblservice.CashRecordBLService;
import businesslogicservice.financialblservice.MoneyBLService;
import businesslogicservice.importblservice.ImportBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.saleblservice.SalesBLService;
import businesslogicservice.stockblservice.GoodsManageBLService;
import businesslogicservice.userblservice.LoginBLService;
import businesslogicservice.userblservice.UserBLService;

public class Server extends UnicastRemoteObject implements ServerInterface, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public static void main(String[] args) {
		//注册通讯端口
		try {
			ServerInterface server = new Server();
			LocateRegistry.createRegistry(5000);
			Naming.rebind("rmi://127.0.0.1:5000/ServerInterface", server);
			System.out.println("Service Start!");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ClientBLService getClientService() throws RemoteException{
		ClientBLService clientBLService = new ClientController();
		return clientBLService;
	}


	public AccountBLService getAccountBLService() throws RemoteException {
		// TODO Auto-generated method stub
		AccountBLService accountBLService = new AccountController();
		return accountBLService;
	}


	public ImportBLService getImportBLService() throws RemoteException {
		// TODO Auto-generated method stub
		ImportBLService importBLService = new ImportController();
		return importBLService;
	}


	public SalesBLService getSalesBLService() throws RemoteException {
		// TODO Auto-generated method stub
		SalesBLService salesBLService = new SalesController();
		return salesBLService;
	}


	public MoneyBLService getMoneyBLService(ReceiptType type) throws RemoteException {
		// TODO Auto-generated method stub
		MoneyBLService moneyBLService = new MoneyController(type);
		return moneyBLService;
	}



	public CashRecordBLService getCashRecordBLService() throws RemoteException {
		CashRecordBLService cashRecordBLService = new CashRecordController();
		return cashRecordBLService;
	}


	public UserBLService getUserBLservice() throws RemoteException {
		// TODO Auto-generated method stub
		UserBLService userBLService=new UserController();
		return userBLService;
	}


	public PromotionBLService getPromotionBLService() throws RemoteException {
		// TODO Auto-generated method stub
		PromotionBLService promotionBLService=new PromotionController();
		return promotionBLService;
	}


	public Examingblservice getExamingblservice() throws RemoteException {
		// TODO Auto-generated method stub
		Examingblservice examingblservice=new ExamingController();
		return examingblservice;
	}


	public LoginBLService getLoginBLService() throws RemoteException {
		// TODO Auto-generated method stub
		LoginBLService loginBLService=new LoginController();
		return loginBLService;
	}


	public GoodsManageBLService getGoodsManageBLService()
			throws RemoteException {
		// TODO Auto-generated method stub
		GoodsManageBLService goodsManageBLService = new GoodsManageController();
		return goodsManageBLService;
	}
}
