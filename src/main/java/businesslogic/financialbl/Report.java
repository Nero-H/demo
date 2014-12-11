package businesslogic.financialbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import po.SalesFatherPO;
import po.SalesPO;
import vo.CaseReportVO;
import vo.HistoryReportType;
import vo.HistoryReportVO;
import vo.ReceiptType;
import vo.ReceiptVO;
import vo.SalesReportVO;
import vo.SalesVO;
import businesslogic.importbl.Import;
import businesslogic.salebl.Sales;
import businesslogicservice.financialblservice.ReportBLService;
import businesslogicservice.importblservice.ImportInterface;
import businesslogicservice.saleblservice.SalesInterface;

public class Report implements ReportBLService {

	public HashMap<String, Double> viewCaseReport(CaseReportVO vo)
			throws RemoteException {
		return null;
	}

	public ArrayList<Object> viewHistoryReport(HistoryReportVO vo) throws RemoteException {
		ArrayList<Object> list = new ArrayList<Object>();
		if(vo.getHistoryReportType() == HistoryReportType.IMPORT){
			ImportInterface importInterface = new Import();
			list.addAll(importInterface.multipleConditionFindImport(vo.getPeriod(), "", vo.getClientName(), vo.getWareHouse()));
			list.addAll(importInterface.multipleConditionFindImportReturn(vo.getPeriod(), "", vo.getClientName(), vo.getWareHouse()));
		}else if(vo.getHistoryReportType() == HistoryReportType.SALES){
			SalesInterface salesInterface = new Sales();
			list.addAll(salesInterface.multipleConditionFindSales(vo.getPeriod(), "", vo.getClientName(), vo.getSalesMan(), vo.getWareHouse()));
			list.addAll(salesInterface.multipleConditionFindSalesReturn(vo.getPeriod(), "", vo.getClientName(), vo.getSalesMan(), vo.getWareHouse()));
		}else if(vo.getHistoryReportType() == HistoryReportType.FINANCIAL){
			list.addAll(new Money(ReceiptType.Pay).mutipleConditionFindPay(vo.getPeriod(), vo.getClientName(), vo.getUserName(), vo.getAccountName()));
			list.addAll(new Money(ReceiptType.Receive).mutipleConditionFindReceive(vo.getPeriod(), vo.getClientName(), vo.getUserName(), vo.getAccountName()));
		}else if(vo.getHistoryReportType() == HistoryReportType.STOCK){
			
		}
			
		return list;
	}

	public ArrayList<SalesVO> viewSalesReport(SalesReportVO vo) throws RemoteException {
		SalesInterface salesInterface = new Sales();
		ArrayList<SalesVO> voList = new ArrayList<SalesVO>();
		ArrayList<SalesFatherPO> result = new ArrayList<SalesFatherPO>();
		ArrayList<SalesPO> temp = salesInterface.multipleConditionFindSales(vo.getPeriod(), vo.getGoodName(), vo.getClientName(), vo.getSalesMan(), vo.getWareHouse());
		for (int i = 0; i < temp.size(); i++) {
			result.add((SalesFatherPO)temp.get(i));
		}
		salesInterface.transform_SalesPOs_to_SalesVOs(result,voList);
		return voList;
	}

	public void hotStamp(ReceiptVO vo, boolean cpy) throws RemoteException {
		
	}

}
