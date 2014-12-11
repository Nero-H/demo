package businesslogic.stockbl;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.ArrayList;

import data.databaseutility.SerializableDataFactory;
import dataservice.stockdataservice.Stock_controller_dataService;
import dataservice.utility.DataFactory;
import po.StockCheckListPO;
import vo.GoodsVO;
import vo.StockVO;
import businesslogicservice.stockblservice.StockInterface;

public class Stock implements StockInterface{
	ArrayList<StockVO> stockVOs ;
	ArrayList<GoodsVO> goodsVO ;
	ArrayList<StockCheckListVO> stockCheckListVOs;
	ArrayList<StockDailyCheckListVO> stockDailyCheckListVOs ;
	DataFactory factory;
	Stock_controller_dataService stockData ;
	
	public Stock() throws RemoteException {
		super();
		factory = new SerializableDataFactory();
		
		stockData = factory.getsStockDataService();
		
		
		
	}

	@SuppressWarnings("null")
	public ArrayList<StockCheckListVO> getStockCheck(Date d1, Date d2) {
							
		// TODO Auto-generated method stub
		StockCheckListVO sVo = null ;
		ArrayList<StockCheckListPO> stockCheckListPOs = new ArrayList<StockCheckListPO>();
		stockCheckListPOs = stockData.checkStock(d1, d2);
		
		for (StockCheckListPO stockCheckListPO : stockCheckListPOs) {
			sVo.setDate(stockCheckListPO.getDate());
			sVo.setId(stockCheckListPO.getId());
			sVo.setName(stockCheckListPO.getName());
			sVo.setNumber(stockCheckListPO.getNumber());
			sVo.setStateString(stockCheckListPO.getStateString());
			sVo.setUnitPrice(stockCheckListPO.getUnitPrice());
			
			stockCheckListVOs.add(sVo);
		}
		
		return stockCheckListVOs;
	}
	
	@Override
	public ArrayList<StockVO> getSumList(ArrayList<vo.StockCheckListVO> stockCheckListVOs) throws RemoteException {
		for (int i = 0; i < stockCheckListVOs.size(); i++) {
			String id = stockCheckListVOs.get(i).getId();
			for (int j = i+1; j < stockCheckListVOs.size(); j++) {
				
				if (id.equals(stockCheckListVOs.get(j).getId())) {
					stockCheckListVOs.get(i).setNumber(stockCheckListVOs.get(i).getNumber()+stockCheckListVOs.get(j).getNumber());
					stockCheckListVOs.get(i).setUnitPrice(stockCheckListVOs.get(i).getUnitPrice()+stockCheckListVOs.get(j).getUnitPrice());
					stockCheckListVOs.remove(j);
				}
			}
		    StockVO stockVO = new StockVO();
		    stockVO.setModelNum(stockCheckListVOs.get(i).getId());
		    stockVO.setNameString(stockCheckListVOs.get(i).getName());
		    stockVO.setNumber(stockCheckListVOs.get(i).getNumber());
		    stockVO.setPerPrice(stockCheckListVOs.get(i).getUnitPrice());
		    if (stockCheckListVOs.get(i).getNumber() > 0) {
				stockVO.setState("出库");
			}else if (stockCheckListVOs.get(i).getNumber() < 0) {
				stockVO.setState("入库");
			}else {
				stockVO.setState("无");
			}
		    stockVOs.add(stockVO);
		}
		
		return stockVOs ;
	}

	
	
	@SuppressWarnings("null")
	public ArrayList<StockDailyCheckListVO> getStockDailyCheck(int n) {
		
		//stockDailyCheckListVOs.add(stockData.checkDailyStock(date,n));
	 	GoodsManage goodsManage = null;
	 	StockDailyCheckListVO sVo = null ;
	 	goodsVO= goodsManage.getGoodsList();
	 
		int i = 1;
	 	
	 	for (GoodsVO goodsVO2 : goodsVO) {
			sVo.setDate(new Date());
			sVo.setGoodsModelNumber(goodsVO2.getGoodsModelNumber());
			sVo.setGoodsName(goodsVO2.getGoodsName());
			sVo.setStockNumber(goodsVO2.getStockNumber());
			sVo.setPerPrice(goodsVO2.getRecentRetailPrice());
			sVo.setBatch(n);
			sVo.setBatchNum(n*1000000+i);
			stockDailyCheckListVOs.add(sVo);
			i ++;
		}
	 	
		// TODO Auto-generated method stub
		return stockDailyCheckListVOs;
	}

	@Override
	public ArrayList<vo.StockCheckListVO> getStockCheckDate(java.util.Date d1,
			java.util.Date d2) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
	
	
	
	
}
