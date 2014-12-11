package po;

import java.io.Serializable;

import utility.Containsable;


public class UserPO implements Containsable,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String name="";
	String id;
	String passward;
	UserIdentity identity=UserIdentity.NOONE;
	int level=0;
	
	public UserPO(String name, String id, String passward,UserIdentity identity) {
		this.name = name;
		this.id = id;
		this.passward = passward;
		this.identity=identity;
		
	}

	public UserPO(String name, String id, String passward,UserIdentity identity,int level) {
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

	public UserIdentity getIdentity() {
		return identity;
	}

	public void setIdentity(UserIdentity identity) {
		this.identity = identity;
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

	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return name.contains(key)||id.contains(key);
	}
}
