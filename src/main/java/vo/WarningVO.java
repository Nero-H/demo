package vo;

import java.io.Serializable;

public class WarningVO extends ReceiptVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int number ;
	boolean warning ;

	public int getNumber() {
		return number;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}
