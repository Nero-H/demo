package dataservice.saledataservice;

import po.SalesPO;
import data.saledata.SalesDateService_Stub;

public class SalesDataService_Driver {
	public void drive(SalesDataService salesDataService){
		salesDataService.insert(new SalesPO());
		salesDataService.delete("XSD-20141025-00001");
		salesDataService.update(new SalesPO());
		if(salesDataService.find("XSD-20141025-00001") != null)
			System.out.println("Find by XSD-20141025-00001!");
		salesDataService.init();
		salesDataService.finish();
	}
	
	public static void main(String[] args) {
		SalesDataService salesDataController = new SalesDateService_Stub();
		new SalesDataService_Driver().drive(salesDataController);
	}
}
