package dataservice.importdataservice;


import po.ImportPO;
import data.importdata.ImportDataService_Stub;

public class ImportDataService_Driver {
	public void drive(ImportDataService importDataService){
		importDataService.insert(new ImportPO());
		importDataService.delete("JHD-20141025-00001");
		importDataService.update(new ImportPO());
		if(importDataService.find("JHD-20141025-00001") != null)
			System.out.println("Find JHD-20141025-00001!");
		importDataService.init();
		importDataService.finish();
	}
	
	public static void main(String[] args) {
		ImportDataService importDataController = new ImportDataService_Stub();
		new ImportDataService_Driver().drive(importDataController);
	}
}
