package po;

import java.sql.Date;

public class StockDailyCheckListPO {
	 	Date date;
	 	int batch ;
	 	int batchNum ;
        String nameString ;
        String id;
        int number;
        double perPrice;
		public Date getDate() {
			return date;
		}
		public void setDate(Date date) {
			this.date = date;
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
		public String getNameString() {
			return nameString;
		}
		public void setNameString(String nameString) {
			this.nameString = nameString;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public int getNumber() {
			return number;
		}
		public void setNumber(int number) {
			this.number = number;
		}
		public double getPerPrice() {
			return perPrice;
		}
		public void setPerPrice(double perPrice) {
			this.perPrice = perPrice;
		}
        
		
         
}
