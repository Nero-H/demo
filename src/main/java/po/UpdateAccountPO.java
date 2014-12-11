package po;

public class UpdateAccountPO {
	String oldName;
	String newName;
	public UpdateAccountPO(String oldName, String newName) {
		super();
		this.oldName = oldName;
		this.newName = newName;
	}
	public String getOldName() {
		return oldName;
	}
	public String getNewName() {
		return newName;
	}
}
