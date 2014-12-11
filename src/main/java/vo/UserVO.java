package vo;

import java.io.Serializable;

public class UserVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name;
	String id;
	String passward;
	UserIdentity identity;
	int level=0;

	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(UserIdentity identity) {
		this.identity = identity;
	}

	public UserVO(String name, String id, String passward,UserIdentity identity) {
		this.name = name;
		this.id = id;
		this.passward = passward;
		this.identity=identity;
		
	}

	public UserVO(String name, String id, String passward,UserIdentity identity,int level) {
		this.name = name;
		this.id = id;
		this.passward = passward;
		this.identity=identity;
		this.level=level;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}
}
