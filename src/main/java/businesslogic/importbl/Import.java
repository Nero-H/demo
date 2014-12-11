package businesslogic.importbl;

import java.util.ArrayList;

import po.ClientPO;
import po.GoodsInfoPO;
import po.ImportPO;
import po.ImportReturnPO;
import po.Import_Sales_FatherPO;
import po.ReceiptState;
import po.ReceiptType;
import utility.SerialNumber;
import utility.TimePeriod;
import vo.ClientVO;
import vo.GoodsInfoVO;
import vo.ImportInfoVO;
import vo.ImportVO;
import businesslogic.clientbl.Client;
import businesslogic.examingbl.Examing;
import businesslogic.stockbl.GoodsManage;
import businesslogic.utilitybl.Import_Sales_MultipleFind;
import businesslogic.utilitybl.TransForm_GoodsInfo;
import businesslogicservice.importblservice.ImportInterface;
import businesslogicservice.stockblservice.GoodsInterface;
import data.databaseutility.SerializableDataFactory;
import dataservice.clientdataservice.ClientDataService;
import dataservice.importdataservice.ImportDataService;
import dataservice.importdataservice.ImportReturnDataService;
import dataservice.utility.DataFactory;

public class Import implements ImportInterface {
	private ImportList importList;
	private ArrayList<ImportPO> importPOs;
	private ImportPO importPO;
	private int importReceiptNumber;
	private int importReturnReceiptNumber;
	private DataFactory factory;
	private ArrayList<GoodsInfoPO> goodsList;

	public Import() {
		// TODO Auto-generated constructor stub
		factory = new SerializableDataFactory();
		importList = new ImportList();
		ImportDataService importData = factory.getImportDataService();
		importPOs = importData.getImportList();
		importPO = new ImportPO();
		goodsList = new ArrayList<GoodsInfoPO>();
	}

	public boolean addClient(ClientVO vo) {
		// TODO Auto-generated method stub
		ClientDataService clientData = factory.getClientDataService();
		ClientPO po = clientData.findByNum(vo.getNum());
		importPO.setClient(po);
		return true;
	}

	public boolean addGoods(String goodsNumber, int number, double unitPrice,
			String notes) {
		// TODO Auto-generated method stub
		GoodsInfoPO result = importList.addOneGoods(goodsNumber, number,
				unitPrice, notes);
		if (result == null) {
			return false;
		} else {
			goodsList.add(result);
			importPO.setGoodsPOs(goodsList);
			return true;
		}
	}

	public boolean addOtherInfo(ImportInfoVO vo) {
		// TODO Auto-generated method stub
		importPO.setNotes(vo.getNotes());
		importPO.setOperator(vo.getOperator());
		importPO.setStorehouse(vo.getStorehouse());
		importPO.setType(ReceiptType.Imoprt);
		return true;
	}

	public ArrayList<ImportVO> showImport() {
		// TODO Auto-generated method stub
		ArrayList<ImportVO> vos = new ArrayList<ImportVO>();
		ArrayList<ImportPO> pos = factory.getImportDataService()
				.getImportList();
		ArrayList<Import_Sales_FatherPO> temp = new ArrayList<Import_Sales_FatherPO>();
		for (int i = 0; i < pos.size(); i++) {
			temp.add((Import_Sales_FatherPO) pos.get(i));
		}
		transform_ImportPOs_to_ImportVOs(temp, vos);
		return vos;
	}

	public ArrayList<ImportVO> showImportReturn() {
		// TODO Auto-generated method stub
		ArrayList<ImportVO> vos = new ArrayList<ImportVO>();
		ArrayList<ImportReturnPO> pos = factory.getImportReturnDataService()
				.getImportReturnList();
		ArrayList<Import_Sales_FatherPO> temp = new ArrayList<Import_Sales_FatherPO>();
		for (int i = 0; i < pos.size(); i++) {
			temp.add((Import_Sales_FatherPO) pos.get(i));
		}
		transform_ImportPOs_to_ImportVOs(temp, vos);
		return vos;
	}

	public boolean importReturn(int loc) {
		// TODO Auto-generated method stub
		if (importPOs.get(loc).isReturn()) {
			return false;
		}
		ImportReturnDataService importReturnData = factory
				.getImportReturnDataService();
		importReturnReceiptNumber = importReturnData.getTodayNum();
		ImportReturnPO po = new ImportReturnPO(importPOs.get(loc),
				SerialNumber
						.getSerialNumber("JHTHD", importReturnReceiptNumber));
		po.setType(ReceiptType.ImportReturn);
		importPOs.get(loc).setReturn(true);
		factory.getImportDataService().update(importPOs.get(loc));
		ImportVO vo = new ImportVO();
		transform_ImportPO_to_ImportVO(po, vo);
		new Examing().addReceiptVO(vo);
		return importReturnData.insert(po);
	}

	public double getTotal() {
		// TODO Auto-generated method stub
		double result = importList.getTotal();
		importPO.setTotal(result);
		return result;
	}

	public boolean creatImport() {
		// TODO Auto-generated method stub
		if (importPO.getClient() == null || importPO.getOperator() == null
				|| importPO.getOperator().equals("")
				|| importPO.getStorehouse().equals("")
				|| importPO.getStorehouse() == null) {
			return false;
		}
		ImportDataService importData = factory.getImportDataService();
		importReceiptNumber = importData.getTodayNum();
		importPO.setReceiptsID(SerialNumber.getSerialNumber("JHD",
				importReceiptNumber));
		importData.insert(importPO);
		/**
		 * 
		 */
		updateImport(importPO.getReceiptsID(), true);
		ImportVO vo = new ImportVO();
		transform_ImportPO_to_ImportVO(importPO, vo);
		new Examing().addReceiptVO(vo);
		return true;
	}

	public boolean removeClient() {
		// TODO Auto-generated method stub
		importPO.setClient(null);
		return true;
	}

	public boolean removeGoods(int loc) {
		// TODO Auto-generated method stub
		boolean result = importList.removeGoods(loc);
		if (result) {
			goodsList.remove(loc);
			importPO.setGoodsPOs(goodsList);
		} else {

		}
		return result;
	}

	public void endImport() {
		// TODO Auto-generated method stub
		ImportDataService importData = factory.getImportDataService();
		importData.finish();
	}

	public ArrayList<ImportPO> getImportList() {
		// TODO Auto-generated method stub
		ImportDataService importData = factory.getImportDataService();
		return importData.getImportList();
	}

	public ArrayList<ImportReturnPO> getImportReturnList() {
		// TODO Auto-generated method stub
		ImportReturnDataService importReturnData = factory
				.getImportReturnDataService();
		return importReturnData.getImportReturnList();
	}

	// 提供给财务人员接口
	public ArrayList<ImportPO> multipleConditionFindImport(TimePeriod period,
			String goodsName, String clientId, String storehouse) {
		ArrayList<ImportPO> findsPOs = new ArrayList<ImportPO>();
		for (int i = 0; i < importPOs.size(); i++) {
			ImportPO temp = importPOs.get(i);
			if (new Import_Sales_MultipleFind(temp, period, goodsName,
					clientId, "", storehouse).check()) {
				findsPOs.add(temp);
			}
		}
		return findsPOs;
	}

	public ArrayList<ImportReturnPO> multipleConditionFindImportReturn(
			TimePeriod period, String goodsName, String clientId,
			String storehouse) {
		ArrayList<ImportReturnPO> findsPOs = new ArrayList<ImportReturnPO>();
		ImportReturnDataService importReturnData = factory
				.getImportReturnDataService();
		ArrayList<ImportReturnPO> importReturnPOs = importReturnData
				.getImportReturnList();
		for (int i = 0; i < importReturnPOs.size(); i++) {
			ImportReturnPO temp = importReturnPOs.get(i);
			if (new Import_Sales_MultipleFind(temp, period, goodsName,
					clientId, "", storehouse).check()) {
				findsPOs.add(temp);
			}
		}
		return findsPOs;
	}

	public double getAllPayout(TimePeriod period) {
		// TODO Auto-generated method stub
		double result = 0;
		for (int i = 0; i < importPOs.size(); i++) {
			ImportPO temp = importPOs.get(i);
			if (period.timeCheck(temp.getDate())) {
				result += temp.getTotal();
			}
		}
		return result;
	}

	// 将po转换成vo
	public void transform_ImportPOs_to_ImportVOs(
			ArrayList<Import_Sales_FatherPO> temp, ArrayList<ImportVO> vos) {
		if (vos.size() != 0) {
			return;
		}
		for (int i = 0; i < temp.size(); i++) {
			ImportVO vo = new ImportVO();
			transform_ImportPO_to_ImportVO(temp.get(i), vo);
			vos.add(vo);
		}
	}

	public void transform_ImportPO_to_ImportVO(Import_Sales_FatherPO po,
			ImportVO vo1) {
		vo1.setClient(po.getClient().getName());
		ArrayList<GoodsInfoVO> vos = new TransForm_GoodsInfo(po.getGoodsPOs())
				.transPOs_to_VOs();
		vo1.setGoodsVOs(vos);
		vo1.setNotes(po.getNotes());
		vo1.setOperator(po.getOperator());
		vo1.setReceiptsID(po.getReceiptsID());
		if (po.getReceiptsID().substring(0, 3).equals("JHD")) {
			vo1.setType(vo.ReceiptType.Imoprt);
			vo1.setReturn(((ImportPO) po).isReturn());
		} else {
			vo1.setType(vo.ReceiptType.ImportReturn);
		}
		vo1.setStorehouse(po.getStorehouse());
		vo1.setTotal(po.getTotal());
		vo1.setDate(po.getDate());
	}

	public boolean updateImport(String receiptsID, boolean isPass) {
		// TODO Auto-generated method stub
		ImportDataService importData = factory.getImportDataService();
		boolean result = false;
		importPO = importData.find(receiptsID);
		if (importPO == null) {
			return false;
		}
		if (isPass) {
			importPO.setState(ReceiptState.PASS);
			result = importUpdate();
			importData.update(importPO);
		} else {
			importPO.setState(ReceiptState.NOTPASS);
			importData.update(importPO);
			return true;
		}
		return result;
	}

	public boolean updateImportReturn(String receiptsID, boolean isPass) {
		// TODO Auto-generated method stub
		ImportReturnDataService importReturnDataService = factory
				.getImportReturnDataService();
		ImportReturnPO po = importReturnDataService.find(receiptsID);
		if (po == null) {
			return false;
		}
		boolean result = false;
		if (isPass) {
			po.setState(ReceiptState.PASS);
			result = importReturnUpdate(po);
		} else {
			po.setState(ReceiptState.NOTPASS);
		}
		if (result) {
			importReturnDataService.update(po);
		}
		return result;
	}

	private boolean importUpdate() {
		ClientPO po = importPO.getClient();
		boolean result = new Client().importGoods(po, importPO.getTotal());
		if (result) {
			GoodsInterface goodsInterface = new GoodsManage();
			for (int i = 0; i < goodsList.size(); i++) {
				GoodsInfoPO temp = goodsList.get(i);
				goodsInterface.importGoods(temp.getNum(), temp.getNumber(),
						temp.getUnitPrice());
			}
		}
		return result;
	}

	private boolean importReturnUpdate(ImportReturnPO po) {
		ClientPO client = importPO.getClient();
		boolean result = new Client().saleGoods(client, importPO.getTotal());
		if (result) {
			GoodsInterface goodsInterface = new GoodsManage();
			ArrayList<GoodsInfoPO> infoPOs = po.getGoodsPOs();
			for (int i = 0; i < infoPOs.size(); i++) {
				GoodsInfoPO temp = infoPOs.get(i);
				goodsInterface.importReturnGoods(temp.getNum(),
						temp.getNumber(), temp.getUnitPrice());
			}
		}
		return result;
	}

	public boolean updateStart(String receiptsID) {
		// TODO Auto-generated method stub
		ImportDataService importData = factory.getImportDataService();
		importPO = importData.find(receiptsID);
		if (importPO == null) {
			return false;
		}
		goodsList = importPO.getGoodsPOs();
		importList.setImportList(goodsList);
		return true;
	}

	public boolean update() {
		// TODO Auto-generated method stub
		ImportDataService importData = factory.getImportDataService();
		importPO.setState(ReceiptState.PASS);
		importData.update(importPO);
		return true;
	}

}
