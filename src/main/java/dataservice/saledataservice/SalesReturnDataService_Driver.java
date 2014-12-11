package dataservice.saledataservice;

import po.SalesPO;
import po.SalesReturnPO;
import data.saledata.SalesReturnDataService_Stub;

public class SalesReturnDataService_Driver {
	public void driver(SalesReturnDataService salesReturnDataService){
		salesReturnDataService.insert(new SalesReturnPO(new SalesPO(), ""));
		salesReturnDataService.delete("XSTHD-20141025-00001");
		salesReturnDataService.update(new SalesReturnPO(new SalesPO(), ""));
		if(salesReturnDataService.find("XSTHD-20141025-00001") != null)
			System.out.println("Find by XSTHD-20141025-00001!");
		salesReturnDataService.init();
		salesReturnDataService.finish();
	}
	
	public static void main(String[] args) {
		SalesReturnDataService salesReturnDataController = new SalesReturnDataService_Stub();
		new SalesReturnDataService_Driver().driver(salesReturnDataController);
	}
}
