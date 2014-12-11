package businesslogic.salebl;

import java.util.ArrayList;

import po.ClientPO;
import po.GiftPO;
import po.GoodsInfoPO;
import po.ReceiptState;
import po.ReceiptType;
import po.SalesFatherPO;
import po.SalesPO;
import po.SalesReturnPO;
import utility.SerialNumber;
import utility.TimePeriod;
import vo.ClientVO;
import vo.GiftVO;
import vo.GoodsInfoVO;
import vo.SalesInfo;
import vo.SalesInfoVO;
import vo.SalesVO;
import businesslogic.clientbl.Client;
import businesslogic.examingbl.Examing;
import businesslogic.promotionbl.Promotion;
import businesslogic.stockbl.GoodsManage;
import businesslogic.utilitybl.Import_Sales_MultipleFind;
import businesslogic.utilitybl.TransForm_GoodsInfo;
import businesslogic.utilitybl.TransGiftPOToGiftVO;
import businesslogicservice.saleblservice.SalesInterface;
import businesslogicservice.stockblservice.GoodsInterface;
import data.databaseutility.SerializableDataFactory;
import dataservice.clientdataservice.ClientDataService;
import dataservice.saledataservice.SalesDataService;
import dataservice.saledataservice.SalesReturnDataService;
import dataservice.utility.DataFactory;

public class Sales implements SalesInterface {
	private SalesPO salesPO;
	private SalesList salesList;
	private ArrayList<SalesPO> salesPOs;
	private Promotion promotion;
	private DataFactory factory;
	private int salesReceiptNumber;
	private int salesReturnReceiptNumber;
	private SalesDataService salesData;
	private ArrayList<GoodsInfoPO> goodsList;

	public Sales() {
		// TODO Auto-generated constructor stub
		factory = new SerializableDataFactory();
		salesPO = new SalesPO();
		salesList = new SalesList();
		goodsList = new ArrayList<GoodsInfoPO>();
		salesData = factory.getSalesDataService();
		salesPOs = salesData.getSalesList();
		promotion = new Promotion();
	}

	// 根据条件查找的对应的销售单
	public ArrayList<SalesPO> multipleConditionFindSales(TimePeriod period,
			String goodsName, String clientId, String salesman,
			String storehouse) {
		ArrayList<SalesPO> findsPOs = new ArrayList<SalesPO>();
		for (int i = 0; i < salesPOs.size(); i++) {
			SalesPO temp = salesPOs.get(i);
			if (new Import_Sales_MultipleFind(temp, period, goodsName,
					clientId, salesman, storehouse).check()) {
				findsPOs.add(temp);
			}
		}
		return findsPOs;
	}

	// 根据条件查找对应的销售退货单
	public ArrayList<SalesReturnPO> multipleConditionFindSalesReturn(
			TimePeriod period, String goodsName, String clientId,
			String salesman, String storehouse) {
		SalesReturnDataService salesReturnData = factory
				.getSalesReturnDataService();
		ArrayList<SalesReturnPO> salesReturnPOs = salesReturnData
				.getSalesReturnList();
		ArrayList<SalesReturnPO> findsPOs = new ArrayList<SalesReturnPO>();
		for (int i = 0; i < salesReturnPOs.size(); i++) {
			SalesReturnPO temp = salesReturnPOs.get(i);
			if (new Import_Sales_MultipleFind(salesPO, period, goodsName,
					clientId, salesman, storehouse).check()) {
				findsPOs.add(temp);
			}
		}
		return findsPOs;
	}

	public ArrayList<SalesPO> getSalesList() {
		// TODO Auto-generated method stub
		return salesData.getSalesList();
	}

	public ArrayList<SalesReturnPO> getSalesReturnList() {
		// TODO Auto-generated method stub
		SalesReturnDataService salesReturnData = factory
				.getSalesReturnDataService();
		return salesReturnData.getSalesReturnList();
	}

	public double getSalesIncome(TimePeriod period) {
		// TODO Auto-generated method stub
		double income = 0;
		for (int i = 0; i < salesPOs.size(); i++) {
			SalesPO temp = salesPOs.get(i);
			if (period.timeCheck(temp.getDate())) {
				income += temp.getTotal();
			}
		}
		return income;
	}

	public double getIncomeOfVoucherAndGain(TimePeriod period) {
		// TODO Auto-generated method stub
		double income = 0;
		for (int i = 0; i < salesPOs.size(); i++) {
			SalesPO temp = salesPOs.get(i);
			if (period.timeCheck(temp.getDate())) {
				double substract = temp.getTicketsPrice() - temp.getTotal();
				if (substract > 0) {
					income += substract;
				}
			}
		}
		return income;
	}

	public double getGiftPayout(TimePeriod period) {
		// TODO Auto-generated method stub
		double payout = 0;
		for (int i = 0; i < salesPOs.size(); i++) {
			SalesPO temp = salesPOs.get(i);
			if (period.timeCheck(temp.getDate())) {
				ArrayList<GiftPO> giftPOs = temp.getGiftGoods();
				for (int j = 0; j < giftPOs.size(); j++) {
					GiftPO giftGoods = giftPOs.get(j);
					payout += giftGoods.getLatestImportPrice()
							* giftGoods.getNumber();
				}
			}
		}
		return payout;
	}

	// 添加此次销售的客户
	public boolean addClient(ClientVO vo) {
		// TODO Auto-generated method stub
		ClientDataService clientData = factory.getClientDataService();
		ClientPO po = clientData.findByNum(vo.getNum());
		salesPO.setClient(po);
		return true;
	}

	// 添加一项商品
	public boolean addGoods(String goodsNumber, int number, double unitPrice,
			String notes) {
		// TODO Auto-generated method stub
		GoodsInfoPO result = salesList.addOneGoods(goodsNumber, number,
				unitPrice, notes);
		if (result == null) {
			return false;
		} else {
			goodsList.add(result);
			salesPO.setGoodsPOs(goodsList);
			return true;
		}
	}

	// 添加销售的其他信息
	public boolean addOtherInfo(SalesInfoVO vo) {
		// TODO Auto-generated method stub
		salesPO.setOperatorID(vo.getOperator());
		salesPO.setOperator(vo.getOperator());
		salesPO.setSalesman(vo.getSalesman());
		salesPO.setStorehouse(vo.getStorehouse());
		salesPO.setTicketsPrice(vo.getVoucher());
		salesPO.setNotes(vo.getNotes());
		salesPO.setDiscount(vo.getDiccount());
		salesPO.setType(ReceiptType.Sales);
		double temp = salesPO.getBeforeDiscount() - salesPO.getDiscount() - salesPO.getVoucher();
		if (temp < 0) {
			salesPO.setAfterDiscount(0);
		}else {
			salesPO.setAfterDiscount(temp);
		}
		return true; // receiptID
	}

	// 获得所有的销售单
	public ArrayList<SalesVO> showSales() {
		// TODO Auto-generated method stub
		ArrayList<SalesVO> vos = new ArrayList<SalesVO>();
		ArrayList<SalesPO> pos = factory.getSalesDataService().getSalesList();
		ArrayList<SalesFatherPO> temp = new ArrayList<SalesFatherPO>();
		for (int i = 0; i < pos.size(); i++) {
			temp.add((SalesFatherPO) pos.get(i));
		}
		transform_SalesPOs_to_SalesVOs(temp, vos);
		return vos;
	}

	public ArrayList<SalesVO> showSalesReturn() {
		// TODO Auto-generated method stub
		ArrayList<SalesVO> vos = new ArrayList<SalesVO>();
		ArrayList<SalesReturnPO> pos = factory.getSalesReturnDataService()
				.getSalesReturnList();
		ArrayList<SalesFatherPO> temp = new ArrayList<SalesFatherPO>();
		for (int i = 0; i < pos.size(); i++) {
			temp.add((SalesFatherPO) pos.get(i));
		}
		transform_SalesPOs_to_SalesVOs(temp, vos);
		return vos;
	}

	// 销售退货
	public boolean salesReturn(int loc) {
		// TODO Auto-generated method stub
		if (salesPOs.get(loc).isReturn()) {
			return false;
		}
		SalesReturnDataService salesReturnData = factory
				.getSalesReturnDataService();
		salesReturnReceiptNumber = salesReturnData.getTodayNum();
		SalesReturnPO po = new SalesReturnPO(salesPOs.get(loc),
				SerialNumber.getSerialNumber("XSTHD", salesReturnReceiptNumber));
		po.setType(ReceiptType.SalesReturn);
		salesPOs.get(loc).setReturn(true);
		salesData.update(salesPOs.get(loc));
		salesReturnData.insert(po);
		SalesVO vo = new SalesVO();
		transform_SalesPO_to_SalesVO(po, vo);
		new Examing().addReceiptVO(vo);
		return true;
	}

	// 计算总价
	public double getTotal() {
		// TODO Auto-generated method stub
		double total = salesList.getTotal();
		salesPO.setBeforeDiscount(total);
		salesPO.setTotal(total);
		promotion.test(salesPO); // 判断是否满足销售策略
		total -= salesPO.getDiscount();
		salesPO.setAfterDiscount(total);
		return total;
	}

	public ArrayList<GiftVO> getGiftList() {
		ArrayList<GiftPO> giftPOs = salesPO.getGiftGoods();
		ArrayList<GiftVO> result = new ArrayList<GiftVO>();
		if (giftPOs == null) {
			return result;
		}
		for (int i = 0; i < giftPOs.size(); i++) {
			GiftPO tempGiftPO = giftPOs.get(i);
			GiftVO tempGiftVO = new GiftVO();
			tempGiftVO.setId(tempGiftPO.getId());
			tempGiftVO.setName(tempGiftPO.getId());
			tempGiftVO.setNumber(tempGiftPO.getNumber());
			double price = tempGiftPO.getLatestImportPrice();
			tempGiftVO.setPrice(price);
			tempGiftVO.setSum(tempGiftPO.getNumber() * price);
			tempGiftVO.setType(tempGiftPO.getType());
			result.add(tempGiftVO);
		}
		return result;
	}

	// 创建销售单
	public boolean creatSales() {
		// TODO Auto-generated method stub
		if (salesPO.getClient() == null || salesPO.getOperator() == null
				|| salesPO.getOperator().equals("")
				|| salesPO.getStorehouse().equals("")
				|| salesPO.getStorehouse() == null)
			return false;
		SalesDataService salesData = factory.getSalesDataService();
		salesReceiptNumber = salesData.getTodayNum();
		salesPO.setReceiptsID(SerialNumber.getSerialNumber("XSD",
				salesReceiptNumber));
		SalesVO vo = new SalesVO();
		transform_SalesPO_to_SalesVO(salesPO, vo);
		new Examing().addReceiptVO(vo);
		return salesData.insert(salesPO);
	}

	// 结束此次销售
	public void endSales() {
		// TODO Auto-generated method stub
		SalesDataService salesData = factory.getSalesDataService();
		salesData.finish();
	}

	// 添加赠品列表
	public void addGift(ArrayList<GiftPO> goodsList) {
		salesPO.setGiftGoods(goodsList);
		;
	}

	/*
	 * //设置此次销售赠送的代金券 public void setVoucher(double price){
	 * salesPO.setVoucher(price); }
	 * 
	 * //设置此次销售应有的折让 public void setDiscount(double discount){
	 * salesPO.setDiscount(discount); }
	 */
	// 删除此次销售的客户
	public boolean removeClient() {
		// TODO Auto-generated method stub
		salesPO.setClient(null);
		return true;
	}

	// 删除此次销售的一项商品
	public boolean removeGoods(int loc) {
		// TODO Auto-generated method stub
		boolean result = salesList.removeGoods(loc);
		if (result) {
			goodsList.remove(loc);
			salesPO.setGoodsPOs(goodsList);
		} else {

		}
		return result;
	}

	// 转换方法
	public void transform_SalesPO_to_SalesVO(SalesFatherPO po, SalesVO vo1) {
		vo1.setClient(po.getClient().getName());
		ArrayList<GoodsInfoVO> vos = new TransForm_GoodsInfo(po.getGoodsPOs())
				.transPOs_to_VOs();
		vo1.setGoodsVOs(vos);
		vo1.setNotes(po.getNotes());
		vo1.setOperator(po.getOperatorID());
		vo1.setReceiptsID(po.getReceiptsID());
		if (po.getReceiptsID().substring(0, 3).equals("SXD")) {
			vo1.setType(vo.ReceiptType.Sales);
			vo1.setReturn(((SalesPO) (po)).isReturn());
		} else {
			vo1.setType(vo.ReceiptType.SalesReturn);
		}
		vo1.setStorehouse(po.getStorehouse());
		vo1.setSalesman(po.getSalesman());
		ArrayList<GiftVO> giftVOs = new ArrayList<GiftVO>();
		ArrayList<GiftPO> giftPOs = po.getGiftGoods();
		for (int i = 0; (giftPOs != null) && (i < giftPOs.size()); i++) {
			giftVOs.add(new TransGiftPOToGiftVO(giftPOs.get(i)).trans());
		}
		vo1.setGiftList(giftVOs);
		vo1.setBeforeDiscount(po.getBeforeDiscount());
		vo1.setDiscount(po.getDiscount());
		vo1.setAfterDiscount(po.getAfterDiscount());
		vo1.setVoucher(po.getVoucher());
		vo1.setTicketPrice(po.getTicketsPrice());
		vo1.setTotal(po.getTotal());
		vo1.setDate(po.getDate());
	}

	public void transform_SalesPOs_to_SalesVOs(ArrayList<SalesFatherPO> pos,
			ArrayList<SalesVO> vos) {
		// TODO Auto-generated method stub
		if (vos.size() != 0) {
			return;
		}
		for (int i = 0; i < pos.size(); i++) {
			SalesVO vo = new SalesVO();
			transform_SalesPO_to_SalesVO(pos.get(i), vo);
			vos.add(vo);
		}
	}

	public boolean updateSales(String receiptsID, boolean isPass) {
		// TODO Auto-generated method stub
		boolean result = false;
		salesPO = salesData.find(receiptsID);
		if (salesPO == null) {
			return false;
		}
		if (isPass) {
			salesPO.setState(ReceiptState.PASS);
			salesData.update(salesPO);
			result = salesUpdate();
		} else {
			salesPO.setState(ReceiptState.NOTPASS);
			salesData.update(salesPO);
		}
		return result;
	}

	public boolean updateSalesReturn(String receiptsID, boolean isPass) {
		// TODO Auto-generated method stub
		SalesReturnDataService salesReturnDataService = factory
				.getSalesReturnDataService();
		SalesReturnPO po = salesReturnDataService.find(receiptsID);
		if (po == null) {
			return false;
		}
		boolean result = false;
		if (isPass) {
			po.setState(ReceiptState.PASS);
			result = salesReturnUpdate(po);
		} else {
			po.setState(ReceiptState.NOTPASS);
		}
		if (result) {
			salesReturnDataService.update(po);
		}
		return result;
	}

	private boolean salesUpdate() {
		ClientPO client = salesPO.getClient();
		boolean result = new Client().saleGoods(client, salesPO.getTotal());
		if (result) {
			GoodsInterface goodsInterface = new GoodsManage();
			for (int i = 0; i < goodsList.size(); i++) {
				GoodsInfoPO po = goodsList.get(i);
				goodsInterface.saleGoods(po.getNum(), po.getNumber(),
						po.getUnitPrice());
			}
		}
		return result;
	}

	private boolean salesReturnUpdate(SalesReturnPO po) {
		ClientPO client = po.getClient();
		boolean result = new Client().importGoods(client, po.getTotal());
		if (result) {
			GoodsInterface goodsInterface = new GoodsManage();
			ArrayList<GoodsInfoPO> goodsInfoPOs = po.getGoodsPOs();
			for (int i = 0; i < goodsInfoPOs.size(); i++) {
				GoodsInfoPO temp = goodsInfoPOs.get(i);
				goodsInterface.saleReturnGoods(temp.getNum(), temp.getNumber(),
						temp.getUnitPrice());
			}
		}
		return result;
	}

	public boolean updateSalesStart(String receiptsID) {
		// TODO Auto-generated method stub
		salesPO = salesData.find(receiptsID);
		if (salesPO == null) {
			return false;
		}
		goodsList = salesPO.getGoodsPOs();
		salesList.setSalesList(goodsList);
		return true;
	}

	public SalesInfo getSalesInfo() {
		// TODO Auto-generated method stub
		//
		SalesInfo info = new SalesInfo();
		info.setDiscount(salesPO.getDiscount());
		info.setAfterDiscount(salesPO.getAfterDiscount());
		info.setVoucher(salesPO.getVoucher());
		info.setTicketsPrice(salesPO.getTicketsPrice());
		return info;
	}

	public boolean update() {
		// TODO Auto-generated method stub
		boolean result = false;
		salesPO.setState(ReceiptState.PASS);
		salesData.update(salesPO);
		result = true;
		return result;
	}

}
