package starry;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.importbl.MockGoods;
import businesslogic.salebl.Sales;

public class SalesGetTotalTest {

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
		MockGoods goods1 = new MockGoods("", 2, 10.0, "Goods1");
		MockGoods goods2 = new MockGoods("", 5, 40.0, "Goods2");
		Sales sales = new Sales();
		sales.addGoods(goods1.getLoc(), goods1.getNumber(), goods1.getUnitPrice(), goods1.getNotes());
		sales.addGoods(goods2.getLoc(), goods2.getNumber(), goods2.getUnitPrice(), goods2.getNotes());
		assertEquals(220.0, sales.getTotal(), 0.0001);
	}

}
