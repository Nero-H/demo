package starry;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.importbl.Import;
import businesslogic.salebl.MockGoods;

public class ImportGetTotalTest {

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
		Import import1 = new Import();
		import1.addGoods(goods1.getLoc(), goods1.getNumber(), goods1.getUnitPrice(), goods1.getNotes());
		import1.addGoods(goods2.getLoc(), goods2.getNumber(), goods2.getUnitPrice(), goods2.getNotes());
		assertEquals(220.0, import1.getTotal(), 0.0001);
	}

}
