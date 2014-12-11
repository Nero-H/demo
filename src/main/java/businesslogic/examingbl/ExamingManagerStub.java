package businesslogic.examingbl;

import java.util.ArrayList;

import vo.ReceiptVO;
import businesslogicservice.examingblservice.Examingblservice;

public class ExamingManagerStub implements Examingblservice{
	
	public ExamingManagerStub() {
		// TODO Auto-generated constructor stub
	}

	public boolean pass(String id) {
		// TODO Auto-generated method stub
		System.out.println("Pass");
		
		return true;
	}

	public boolean notPass(String id) {
		// TODO Auto-generated method stub
		System.out.println("Not Pass");
		return true;
	}


	public boolean modify(String id) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean examing(ReceiptVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ArrayList<ReceiptVO> getReceipts() {
		// TODO Auto-generated method stub
		return null;
	}

}
