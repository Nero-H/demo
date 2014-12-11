package po;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

//特价包销售策略
public class GoodsDiscountPromotionPO extends PromotionPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date startDate;
	Date endDate;
	double discount;
	ArrayList<GiftPO> goods= new ArrayList<GiftPO>();
	Promotiontype ptype=Promotiontype.GoodsDiscount;
	
	public ArrayList<GiftPO> getGoods() {
		return goods;
	}


	public void setGoods(ArrayList<GiftPO> goods) {
		this.goods = goods;
	}


	public Promotiontype getPtype() {
		return ptype;
	}


	public void setPtype(Promotiontype ptype) {
		this.ptype = ptype;
	}


	public GoodsDiscountPromotionPO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public void delGoods(GiftPO po){
		
	}
	
	public void addGoods(GiftPO po){
		
	}
	
	@Override
	public boolean test(SalesPO po) {
		ArrayList<GiftPO> clone = new ArrayList<GiftPO>();
		for(GoodsInfoPO goodsInfoPO:po.getGoodsPOs()){
			GiftPO giftPO=new GiftPO();
			giftPO.setId(goodsInfoPO.getNum());
			giftPO.setNumber(goodsInfoPO.getNumber());
		}
		boolean goon=true;
		while(goon){
			goon=true;
			for(GiftPO giftPO:goods){
				boolean contain=false;
				for(GiftPO infoPO:clone){
					if(giftPO.getId().equals(infoPO.getId())){
						if(infoPO.getNumber()>=giftPO.getNumber()){
							contain=true;
							infoPO.setNumber(infoPO.getNumber()-giftPO.getNumber());;
							break;
						}
					}
				}
				if(!contain){
					goon=false;
				}
			}
			if(goon){
				po.setAfterDiscount(po.getBeforeDiscount()-discount);
			}
		}
		return true;
	}

	public int compare(PromotionPO po){
		GoodsDiscountPromotionPO temp=(GoodsDiscountPromotionPO)po;
		if(goods.containsAll(temp.getGoods()))
			if(startDate.compareTo(temp.getStartDate())<=0)
				if(endDate.compareTo(temp.getEndDate())>=0)
					return -1;
		return 0;
		
	}
}
