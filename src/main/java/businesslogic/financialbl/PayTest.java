package businesslogic.financialbl;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import po.AccountPO;
import po.ClientPO;
import vo.MoneyLineItemVO;
import vo.ReceiptType;

public class PayTest {

	@Test
	public void test() throws RemoteException {
		ClientPO client = new ClientPO();
		Money money = new Money(ReceiptType.Receive);
		money.addItem(new MoneyLineItemVO("event1", 123, "no"));
		money.addItem(new MoneyLineItemVO("event2", 13, "no"));
		money.addItem(new MoneyLineItemVO("event3", 23, "no"));
		double originClientMoney = client.getPayable();
		client.setPayable(client.getPayable() - money.getSum());;
		assertEquals(originClientMoney - 123 - 13 -23, client.getPayable(),0.0001);
		AccountPO account = new MockAccount("sad", 21321);
		double originAccountMoney = account.getBalance();
		account.setBalance(account.getBalance() - money.getSum());
		assertEquals(originAccountMoney - 123 - 13 -23, account.getBalance(),0.0001);
	}

}
