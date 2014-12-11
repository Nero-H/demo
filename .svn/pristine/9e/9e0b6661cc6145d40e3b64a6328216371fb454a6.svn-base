package businesslogic.stockbl;

import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.junit.Test;

import po.GoodsPO;

public class CheckBroken {

	@Test
	public void test() {
		GoodsPO goodsPO = null;
		try {
			goodsPO = new GoodsPO("12","sada","A23",12,100,120,15);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(new MockBreak().compare(10,goodsPO));
	}

}
