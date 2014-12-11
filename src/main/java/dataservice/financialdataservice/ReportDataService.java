package dataservice.financialdataservice;

import po.CaseReportInfoPO;
import po.CaseReportPO;
import po.HistoryReportInfoPO;
import po.HistoryReportPO;
import po.SalesReportInfoPO;
import po.SalesReportPO;

public interface ReportDataService {
	
	public CaseReportPO fetchCaseReport (CaseReportInfoPO po);

	public HistoryReportPO fetchHistoryReport (HistoryReportInfoPO po);

	public SalesReportPO fetchSalesReport (SalesReportInfoPO po);

	public void init();

	public void finish();
}
