package businesslogic.promotionbl;

import java.util.ArrayList;

import po.GiftPO;
import vo.GoodsVO;
import businesslogic.stockbl.GoodsManage;

public class GoodsList {

	private ArrayList<GiftPO> goods=new ArrayList<GiftPO>();
	
	public void add(GiftPO lineItem){
		goods.add(lineItem);
	}
	
	public void del(String id){
		ArrayList<GiftPO> temp=new ArrayList<GiftPO>();
		for(GiftPO item:goods){
			if(item.getId().equals(id)){
				temp.add(item);
			}
		}
		goods.removeAll(temp);
		
	}
	
	public ArrayList<GiftPO> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<GiftPO> goods) {
		this.goods = goods;
	}

	public double total() {
		double result=0;
		GoodsManage manager=new GoodsManage();
		for(GiftPO po:goods){
			GoodsVO goodsVO= (GoodsVO)manager.findGoods(po.getId());
			result+=goodsVO.getRecentPrice()*po.getNumber();
		}
		return result;
	}
}
