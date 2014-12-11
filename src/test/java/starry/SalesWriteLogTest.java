package starry;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.salebl.MockSalesLog;


public class SalesWriteLogTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String log = "SalesWriteLogTest";
		MockSalesLog test = new MockSalesLog(log);
		assertEquals(log, test.log);
	}

}
