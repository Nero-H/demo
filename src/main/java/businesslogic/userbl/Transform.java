package businesslogic.userbl;

import java.util.ArrayList;

import po.UserPO;
import vo.UserVO;

public class Transform {

	public UserVO po_to_vo(UserPO userPO) {
		UserVO userVO=new UserVO(userPO.getName(), userPO.getId(), userPO.getPassward(),vo.UserIdentity.valueOf(userPO.getIdentity().toString()),userPO.getLevel());
		return userVO;
	}
	
	public UserPO vo_to_po(UserVO userVO){
		UserPO userPO=new UserPO(userVO.getName(), userVO.getId(), userVO.getPassward(), po.UserIdentity.valueOf(userVO.getIdentity().toString()),userVO.getLevel());
		return userPO;
	}
	
	public ArrayList<UserPO> vo_to_po_list(ArrayList<UserVO> vos){
		ArrayList<UserPO> pos=new ArrayList<UserPO>();
		for(UserVO vo:vos){
			UserPO po=vo_to_po(vo);
			pos.add(po);
		}
		return pos;
	}
	
	public ArrayList<UserVO> po_to_vo_list(ArrayList<UserPO> pos){
		ArrayList<UserVO> vos=new ArrayList<UserVO>();
		for(UserPO po:pos){
			UserVO vo=po_to_vo(po);
			vos.add(vo);
		}
		return vos;
	}
}
