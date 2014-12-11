package dataservice.userdataservice;

import java.util.ArrayList;

import po.UserPO;

public interface UserDataService {
	public boolean addUser (UserPO po);
	public boolean deleteUser(String id);
	public boolean updateUser(UserPO po);
	public UserPO findUser (String ID);
	public void init();
	public void finish();
	public ArrayList<UserPO> getUserPOs();
}
