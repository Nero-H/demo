package businesslogic.examingbl;

import java.util.ArrayList;

import vo.ReceiptType;
import vo.ReceiptVO;
import data.examingdata.ExamingDataServiceImpl;
import dataservice.examingdataservice.ExamingDataService;

public class Examing {

	ArrayList<ReceiptVO> receiptVOs;
	ExamingDataService dataService;
	
	
	public Examing(){
		dataService=ExamingDataServiceImpl.getInstance();
		receiptVOs=dataService.getReceiptVOs();
	}
	
	
	public boolean pass(String id) {
		// TODO Auto-generated method stub
		
		
		dataService.delete(id);
		receiptVOs=dataService.getReceiptVOs();
		return true;
	}

	public boolean notPass(String id) {
		// TODO Auto-generated method stub
		dataService.delete(id);
		receiptVOs=dataService.getReceiptVOs();
		return true;
	}

	public boolean modify(String id) {
		// TODO Auto-generated method stub
		dataService.delete(id);
		receiptVOs=dataService.getReceiptVOs();
		return true;
	}



	public ArrayList<ReceiptVO> getReceipts() {
		// TODO Auto-generated method stub
		return receiptVOs;
	}

	public boolean addReceiptVO(ReceiptVO vo){
		dataService.insert(vo);
		dataService.getReceiptVOs();
		return true;
	}
	
	public ReceiptType getType(String id){
		for(ReceiptVO vo:receiptVOs)
			if (vo.getId().equals(id)) {
				return vo.getType();
			}
		return null;
		
	}
}
