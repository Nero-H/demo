package po;


public class ReceiptPO {

	ReceiptState state;
	public String getId() {
		return null;
	}

	
	ReceiptType type;
	
	
	public ReceiptState getState() {
		return state;
	}

	public void setState(ReceiptState state) {
		this.state = state;
	}

	public void updatedatabase(){
		
	}

	public ReceiptType getType() {
		return type;
	}

	public void setType(ReceiptType type) {
		this.type = type;
	}
	
	
}
