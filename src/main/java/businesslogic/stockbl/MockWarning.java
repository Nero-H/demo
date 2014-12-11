package businesslogic.stockbl;

import po.GoodsPO;

public class MockWarning {

	
	
	boolean compare(GoodsPO good){
		return good.getStockNumber() < good.getWarningNumber();
	}
	
	

}
