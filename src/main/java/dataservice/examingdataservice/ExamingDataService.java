package dataservice.examingdataservice;

import java.util.ArrayList;

import po.ReceiptPO;
import vo.ReceiptVO;

public interface ExamingDataService {

	//将已审批的单据插入已审批的单据中
	public boolean insert(ReceiptVO vo);
	//在未审批单据列表中删除已审批的单据
	public boolean delete(String id) ;
	public boolean init() ;
	public ArrayList<ReceiptVO> getReceiptVOs();
	public boolean finish();
}
