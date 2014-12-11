package businesslogic.stockbl;

import po.GoodsPO;

public class MockBreak {

	boolean compare(int number ,GoodsPO goodsPO){
		return number< goodsPO.getStockNumber();
	}
}
