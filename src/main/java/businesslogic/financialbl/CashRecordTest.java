package businesslogic.financialbl;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.junit.Test;

import vo.CashRecordLineItemVO;

public class CashRecordTest {

	@SuppressWarnings("unused")
	@Test
	public void test() throws RemoteException {
		MockAccount account = new MockAccount("Nero",1000);
		CashRecordList list = new CashRecordList();
		CashRecord cashRecord = new CashRecord();
		cashRecord.addItem(new CashRecordLineItemVO("event1", 123, "no"));
		cashRecord.addItem(new CashRecordLineItemVO("event2", 13, "no"));
		cashRecord.addItem(new CashRecordLineItemVO("event3", 23, "no"));
		double originAccountMoney = account.money;
		account.pay(cashRecord.getSum());
		assertEquals(originAccountMoney - 123 - 13 -23, account.money,0.0001);
	}

}
