package businesslogicservice.importblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import utility.MyTreeNode;
import vo.ClientVO;
import vo.ImportInfoVO;
import vo.ImportVO;

public class ImportBLService_Driver {
	public void drive(ImportBLService importBLService) throws RemoteException{
		ArrayList<ClientVO> clientVOs = importBLService.showClientList();
		if(clientVOs != null)
			System.out.println("Show clientList successfully!");
		
		
		boolean resultOfAddClient = importBLService.addClient(new ClientVO());
		if(resultOfAddClient)
			System.out.println("Add client successfully!");
		
		boolean resultOfAddGoods = importBLService.addGoods("", 1, 1, "test");
		if(resultOfAddGoods)
			System.out.println("Add goods successfully!");
		
		boolean resultOfAddOtherInfo = importBLService.addOtherInfo(new ImportInfoVO());
		if(resultOfAddOtherInfo)
			System.out.println("Add other import infomation successfully!");
		
		ArrayList<ImportVO> importVOs = importBLService.showImport();
		if(importVOs != null)
			System.out.println("Show import list successfully!");
		
		boolean resultOfImportReturn = importBLService.importReturn(0);
		if(resultOfImportReturn)
			System.out.println("Import return successfully!");
		
		double total = importBLService.getTotal();
		if(total == 0)
			System.out.println("Get total success!"+ " The total is " + total);
		
		boolean resultOfCreateImport = importBLService.creatImport();
		if (resultOfCreateImport)
			System.out.println("Creat import successfully!");
		
	}
	
	public static void main(String[] args) throws RemoteException {
	}
}
