package po;

import java.sql.Date;
import java.util.ArrayList;

public class StockCheckPO {
	Date fromDate;
	Date toDate;
	ArrayList<StockCheckListPO> stockCheckListPOs ;
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}
	public ArrayList<StockCheckListPO> getStockCheckListVOs() {
		return stockCheckListPOs;
	}
	public void setStockCheckListVOs(ArrayList<StockCheckListPO> stockCheckListVOs) {
		this.stockCheckListPOs = stockCheckListVOs;
	}
	
	

}
