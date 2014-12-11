package businesslogic.userbl;

import java.rmi.RemoteException;

import vo.UserIdentity;
import vo.UserVO;

public class Tset {

	public static void main(String[] args) throws RemoteException {
		UserController userController=new UserController();
		UserVO vo=new UserVO("Admin", "Admin", "Admin", UserIdentity.Administrator);
		UserVO vo2=new UserVO("wang", "sales", "00000", UserIdentity.SalesManager, 1);
		UserVO vo3=new UserVO("he","financial","00000",UserIdentity.FinancialManager,1);
		UserVO vo4=new UserVO("rong","stock","00000",UserIdentity.StockManager);
		UserVO vo5=new UserVO("heng","manager","00000",UserIdentity.Manager);
		userController.addUser(vo);
		userController.addUser(vo5);
		userController.addUser(vo4);
		userController.addUser(vo3);
		userController.addUser(vo2);
		userController.updateUser(vo);
		userController.findUser("M9999");
		userController.deleteUser("A5555");
	}
}
