package businesslogic.stockbl;

import java.util.Date;

public class StockDailyCheckListVO {

	Date date;
	String goodsName;
	String goodsModelNumber;
	int stockNumber;
	double perPrice;
	int batch ;
 	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsModelNumber() {
		return goodsModelNumber;
	}

	public void setGoodsModelNumber(String goodsModelNumber) {
		this.goodsModelNumber = goodsModelNumber;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public double getPerPrice() {
		return perPrice;
	}

	public void setPerPrice(double perPrice) {
		this.perPrice = perPrice;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public int getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(int batchNum) {
		this.batchNum = batchNum;
	}

	int batchNum ;
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
