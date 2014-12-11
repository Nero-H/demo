package businesslogicservice.clientblservice;

import java.rmi.RemoteException;

import vo.ClientVO;
import businesslogic.clientbl.ClientBLService_Stub;

public class ClientBLService_Driver {
	public void drive(ClientBLService clientBLService) throws RemoteException{
		boolean result = clientBLService.addClient(new ClientVO());
		if (result) {
			System.out.println("Add successfully!");
		}
	}
	
	public static void main(String[] args) throws RemoteException {
		ClientBLService clientController = new ClientBLService_Stub();
		new ClientBLService_Driver().drive(clientController);;
	}
}

