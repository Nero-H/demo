package starry;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.AccountVO;
import vo.UpdateAccountVO;
import businesslogic.financialbl.AccountController;

public class AccountManageTest {

	@Test
	public void test() {
		AccountVO vo = new AccountVO("Nero", 123124);
		try {
			assertTrue(new AccountController().addAccount(vo));
			assertTrue((new AccountController().findAccount("Nero")).getBalance() == 123124);
			assertTrue((new AccountController().findAccount("Nero")).getName().equals("Nero"));
			
			assertTrue(new AccountController().updateAccount(new UpdateAccountVO("Nero", "H")));
			assertTrue((new AccountController().findAccount("H")).getBalance() == 123124);
			assertTrue((new AccountController().findAccount("H")).getName().equals("H"));
			
			assertTrue(new AccountController().delAccount("H"));
			assertTrue(new AccountController().findAccount("H") == null);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
