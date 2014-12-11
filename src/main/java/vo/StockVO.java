package vo;



public class StockVO {

	String nameString ;
	String modelNum ;
	
	String state;
	int number ;
	double perPrice ;
	
	
	
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getModelNum() {
		return modelNum;
	}
	public void setModelNum(String modelNum) {
		this.modelNum = modelNum;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double  getPerPrice() {
		return perPrice;
	}
	public String isState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setPerPrice(double perPrice) {
		this.perPrice = perPrice;
	}
}
