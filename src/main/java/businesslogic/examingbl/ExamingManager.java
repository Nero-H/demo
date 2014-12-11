package businesslogic.examingbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.examingdataservice.ExamingDataService;
import vo.ReceiptVO;

public class ExamingManager {
	
	ArrayList<ReceiptVO> receiptVOs;
	ExamingDataService dataService;
	ExamingController controller;

	public ExamingManager() {
		
	}
	
	public void examing(ReceiptVO vo) throws RemoteException {
        controller=new ExamingController();
	}

	public ArrayList<ReceiptVO> getReceiptPOs() {
		return receiptVOs;
	}

	public void setReceiptPOs( ArrayList<ReceiptVO> receiptVOs) {
		this.receiptVOs = receiptVOs;
	}

	public ExamingController getController() {
		return controller;
	}

	public void setController(ExamingController controller) {
		this.controller = controller;
	}
	
	
	
	
	

}
