package businesslogic.promotionbl;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import po.AccountVoucherPromotionPO;
import po.SalesPO;

public class PromotionTest {

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
		Promotion promotion=new Promotion();
		promotion.addAccountVoucher(new AccountVoucherPromotionPO());
		SalesPO mockSalesPO=new MockSalesPO();
		if (promotion.test(mockSalesPO)) {
			System.out.println("Success");
		}
		
		MockAccountDiscountPromotionPO mockAccountDiscountPromotionPO=new MockAccountDiscountPromotionPO();
		if(promotion.addAccountVoucher(mockAccountDiscountPromotionPO)){
			System.out.println("Success");
		}
	}

}
