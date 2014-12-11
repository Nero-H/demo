package businesslogic.stockbl;

import businesslogicservice.stockblservice.GoodsManageBLService;

public class GoodsManageBLService_Driver {
	public void drive(GoodsManageBLService goodsManageService){
		
	}

	public static void main(String[] args){
		GoodsManageBLService goodManageController =  new GoodsManageBLService_Controller();
		GoodsManageBLService_Driver drive = new GoodsManageBLService_Driver();
		drive.drive(goodManageController);
	}

	
}
