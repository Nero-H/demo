package data.examingdata;

import java.util.ArrayList;

import vo.ReceiptVO;
import data.databaseutility.FileOperate;
import dataservice.examingdataservice.ExamingDataService;

public class ExamingDataServiceImpl implements ExamingDataService{

	ArrayList<ReceiptVO> receiptVOs;
	
	private static ExamingDataServiceImpl examingDataServiceImpl;
	
	private ExamingDataServiceImpl(){
		init();
	}
	
	public static ExamingDataService getInstance(){
		if(examingDataServiceImpl==null)
			examingDataServiceImpl=new ExamingDataServiceImpl();
		return examingDataServiceImpl;
	}
	
	public boolean insert(ReceiptVO vo) {
		// TODO Auto-generated method stub
		receiptVOs.add(vo);
		finish();
		return true;
	}

	public boolean delete(String id) {
		// TODO Auto-generated method stub
		for(ReceiptVO temp:receiptVOs){
			if(temp.getId().equals(id)){
				ArrayList<ReceiptVO> tempList=new ArrayList<ReceiptVO>();
				tempList.add(temp);
				receiptVOs.removeAll(tempList);
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean init() {
		// TODO Auto-generated method stub
		receiptVOs=(ArrayList<ReceiptVO>) new FileOperate("src/receipt.ser").read();
		if(receiptVOs==null)
			receiptVOs=new ArrayList<ReceiptVO>();
		return true;
	}

	public ArrayList<ReceiptVO> getReceiptVOs() {
		return receiptVOs;
		
	}

	public boolean finish() {
		// TODO Auto-generated method stub
		new FileOperate("src/receipt.ser").write(receiptVOs);
		return true;
	}


}
