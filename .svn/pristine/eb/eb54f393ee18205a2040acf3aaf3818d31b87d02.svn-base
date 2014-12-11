package dataservice.financialdataservice.driver;

import po.AccountPO;
import data.financialdata.stub.AccountDataServiceSerializableImplStub;
import dataservice.financialdataservice.AccountDataService;

public class AccounDataService_Driver {
	public void drive(AccountDataService accountDataService){
		AccountPO po = new AccountPO("Nero",-2321412);
		boolean result = accountDataService.addAccount(po);
		if(result){
			System.out.println("add account pass");
		}else{
			System.out.println("add account failed");
		}
		
		accountDataService.init();
		accountDataService.finish();
		
	}
	
	public static void main(String[] args) {
		AccounDataService_Driver driver = new AccounDataService_Driver();
		AccountDataService accountDataService = new AccountDataServiceSerializableImplStub();
		driver.drive(accountDataService);
	}
}
