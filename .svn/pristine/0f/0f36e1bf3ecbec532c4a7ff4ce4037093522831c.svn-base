package po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Import_Sales_FatherPO extends ReceiptPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 基本的属性
	private String receiptsID; // 单据编号
	private ClientPO client; // 供应商
	private String storehouse; // 仓库
	private String operator; // 操作员
	private ArrayList<GoodsInfoPO> goodsPOs = new ArrayList<GoodsInfoPO>(); // 商品列表
	private String notes; // 备注
	private double total; // 总额
	private Date date; // 日期
	
	public Import_Sales_FatherPO(){
		date = new Date();
	}
	public String getReceiptsID() {
		return receiptsID;
	}
	public void setReceiptsID(String receiptsID) {
		this.receiptsID = receiptsID;
	}
	public ClientPO getClient() {
		return client;
	}
	public void setClient(ClientPO client) {
		this.client = client;
	}
	public String getStorehouse() {
		return storehouse;
	}
	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public ArrayList<GoodsInfoPO> getGoodsPOs() {
		return goodsPOs;
	}
	public void setGoodsPOs(ArrayList<GoodsInfoPO> goodsPOs) {
		this.goodsPOs = goodsPOs;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
