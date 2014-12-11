package businesslogic.utilitybl;

import java.util.ArrayList;

import po.GoodsInfoPO;
import vo.GoodsInfoVO;

public class TransForm_GoodsInfo {
	private ArrayList<GoodsInfoPO> pos;

	public TransForm_GoodsInfo(ArrayList<GoodsInfoPO> goodsInfoPOs) {
		// TODO Auto-generated constructor stub
		this.pos = goodsInfoPOs;
	}

	public ArrayList<GoodsInfoVO> transPOs_to_VOs() {
		ArrayList<GoodsInfoVO> vos = new ArrayList<GoodsInfoVO>();
		// 为每个po进行转换
		for (int i = 0; i < pos.size(); i++) {
			GoodsInfoVO vo = new GoodsInfoVO();
			GoodsInfoPO po = pos.get(i);
			transform_GoodsInfoPO_to_GoodsInfoVO(po, vo);
			// 添加
			vos.add(vo);
		}
		return vos;
	}
	
	public void transform_GoodsInfoPO_to_GoodsInfoVO(GoodsInfoPO po, GoodsInfoVO vo){
		vo.setModel(po.getModel());
		vo.setName(po.getName());
		vo.setNotes(po.getNotes());
		vo.setNum(po.getNum());
		vo.setNumber(po.getNumber());
		vo.setSum(po.getSum());
		vo.setUnitPrice(po.getUnitPrice());
	}
}
