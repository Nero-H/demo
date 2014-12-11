package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import vo.CaseReportVO;
import vo.HistoryReportVO;
import vo.ReceiptVO;
import vo.SalesReportVO;
import vo.SalesVO;
import businesslogicservice.financialblservice.ReportBLService;

public class ReportController implements ReportBLService{

	public HashMap<String, Double> viewCaseReport(CaseReportVO vo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return new Report().viewCaseReport(vo);
	}

	public ArrayList<Object> viewHistoryReport(HistoryReportVO vo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return new Report().viewHistoryReport(vo);
	}

	public ArrayList<SalesVO> viewSalesReport(SalesReportVO vo)
			throws RemoteException {
		// TODO Auto-generated method stub
		return new Report().viewSalesReport(vo);
	}

	public void hotStamp(ReceiptVO vo, boolean cpy) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
}
