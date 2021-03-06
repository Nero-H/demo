package businesslogic.financialbl;


import java.io.Serializable;
import java.util.ArrayList;

import po.CashRecordLineItemPO;

public class CashRecordList implements Serializable{
	ArrayList<CashRecordLineItemPO>  list;
	
	public CashRecordList(){
		list = new ArrayList<CashRecordLineItemPO>();
	}
	public double getTotal(){
		double total = 0;
		for(CashRecordLineItemPO po : list){
			total += po.getSum();
		}
		return total;
	}
	
	public boolean add(CashRecordLineItemPO item){
		return list.add(item);
	}

	public boolean delete(int index){
		return list.remove(index) != null;
	}
	
	public boolean update(Object value,int row,int col){
		if((row > list.size() - 1)||(col > 2)){
			return false;
		}else{
			CashRecordLineItemPO item = list.get(row);
			switch (col) {
			case 0:
				item.setName((String)value);
				break;
			case 1:
				item.setSum((Double)value);
				break;
			case 2:
				item.setComment((String)value);
				break;
			default:
				System.out.println("CashRecordUpdateError!");
				break;
			}
			return true;
		}
	}
	
	public CashRecordLineItemPO find(String name,double sum,String comment){
		for(CashRecordLineItemPO item : list){
			if(item.match(name, sum, comment)){
				return item;
			}
		}
		return null;
	}
	public ArrayList<CashRecordLineItemPO> getList() {
		return list;
	}
	
	
}
