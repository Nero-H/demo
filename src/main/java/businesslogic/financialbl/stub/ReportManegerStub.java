package businesslogic.financialbl.stub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import vo.CaseReportVO;
import vo.HistoryReportVO;
import vo.ReceiptVO;
import vo.SalesReportVO;
import vo.SalesVO;
import businesslogicservice.financialblservice.ReportBLService;

public class ReportManegerStub implements ReportBLService{

	public HashMap<String, Double> viewCaseReport(CaseReportVO vo) {
		System.out.println("showCaseReport");
		return new HashMap<String, Double>();
	}

	public ArrayList<Object> viewHistoryReport(HistoryReportVO vo) {
		System.out.println("showHistoryReport");
		return new ArrayList<Object>();
	}

	public ArrayList<SalesVO> viewSalesReport(SalesReportVO vo) {
		System.out.println("showSalesReport");
		return new ArrayList<SalesVO>();
	}

	public void hotStamp(ReceiptVO vo, boolean cpy) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
