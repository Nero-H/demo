package dataservice.importdataservice;

import po.ImportPO;
import po.ImportReturnPO;
import data.importdata.ImportReturnDataService_Stub;

public class ImportReturnDataService_Driver {
	public void drive(ImportReturnDataService importReturnDataService){
		importReturnDataService.insert(new ImportReturnPO(new ImportPO(), ""));
		importReturnDataService.delete("JHTHD-20141025-00001");
		importReturnDataService.update(new ImportReturnPO(new ImportPO(), ""));
		if(importReturnDataService.find("JHTHD-20141025-00001") != null)
			System.out.println("Find by JHTHD-20141025-00001!");
		importReturnDataService.init();
		importReturnDataService.finish();
	}
	
	public static void main(String[] args) {
		ImportReturnDataService importReturnDataController = new ImportReturnDataService_Stub();
		new ImportReturnDataService_Driver().drive(importReturnDataController);
	}
}
