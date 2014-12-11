package data.financialdata.stub;

import po.CaseReportInfoPO;
import po.CaseReportPO;
import po.HistoryReportInfoPO;
import po.HistoryReportPO;
import po.SalesReportInfoPO;
import po.SalesReportPO;
import dataservice.financialdataservice.ReportDataService;

public class ReportDataServiceSerializableImplStub implements ReportDataService {

	public CaseReportPO fetchCaseReport(CaseReportInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("fetch casereport successfully");
		return new CaseReportPO();
	}

	public HistoryReportPO fetchHistoryReport(HistoryReportInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("fetch historyreport successfully");
		return new HistoryReportPO();
	}

	public SalesReportPO fetchSalesReport(SalesReportInfoPO po) {
		// TODO Auto-generated method stub
		System.out.println("fetch salesreport successfully");
		return new SalesReportPO();
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void finish() {
		// TODO Auto-generated method stub
		
	}

}
