package po;


public class ReportReceiptPO extends ReceiptPO{
	String name ;
	String modelNUmberString ;
	int number ;
	ReceiptType type=ReceiptType.Report;
	
	public ReceiptType getType() {
		return type;
	}
	public void setType(ReceiptType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getModelNUmberString() {
		return modelNUmberString;
	}
	public void setModelNUmberString(String modelNUmberString) {
		this.modelNUmberString = modelNUmberString;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	
	
}
