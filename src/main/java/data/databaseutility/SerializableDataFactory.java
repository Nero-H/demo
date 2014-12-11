package data.databaseutility;

import data.clientdata.ClientDataImpl;
import data.financialdata.AccountDataServiceSerializableImpl;
import data.financialdata.CashRecordDataServiceSerializeableImpl;
import data.financialdata.MoneyDataServiceSerializableImpl;
import data.importdata.ImportDataImpl;
import data.importdata.ImportReturnDataImpl;
import data.promotiondata.PromotionDataImpl;
import data.saledata.SalesDataImpl;
import data.saledata.SalesReturnDataImpl;
import data.stockdata.GoodsMangeDataServiceSerializableImpl;
import data.stockdata.StockDataImpl;
import dataservice.clientdataservice.ClientDataService;
import dataservice.financialdataservice.AccountDataService;
import dataservice.financialdataservice.CashRecordDataService;
import dataservice.financialdataservice.MoneyDataService;
import dataservice.importdataservice.ImportDataService;
import dataservice.importdataservice.ImportReturnDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.saledataservice.SalesDataService;
import dataservice.saledataservice.SalesReturnDataService;
import dataservice.stockdataservice.GoodsManageDataService;
import dataservice.stockdataservice.Stock_controller_dataService;
import dataservice.utility.DataFactory;

public class SerializableDataFactory implements DataFactory{
	
	public AccountDataService getAccountDataService(){
		return AccountDataServiceSerializableImpl.getInstance();
	}

	public CashRecordDataService getCashRecordDataService() {
		// TODO Auto-generated method stub
		return CashRecordDataServiceSerializeableImpl.getInstance();
	}

	public MoneyDataService getMoneyDataService() {
		// TODO Auto-generated method stub
		return MoneyDataServiceSerializableImpl.getInstance();
	}
	
	public ClientDataService getClientDataService() {
		// TODO Auto-generated method stub
		return  ClientDataImpl.getInstance();
	}

	public ImportDataService getImportDataService() {
		// TODO Auto-generated method stub
		return ImportDataImpl.getInstance();
	}

	public ImportReturnDataService getImportReturnDataService() {
		// TODO Auto-generated method stub
		return ImportReturnDataImpl.getInstance();
	}

	public SalesDataService getSalesDataService() {
		// TODO Auto-generated method stub
		return SalesDataImpl.getInstance();
	}

	public SalesReturnDataService getSalesReturnDataService() {
		// TODO Auto-generated method stub
		return SalesReturnDataImpl.getInstance();
	}

	public PromotionDataService getPromotionDataService() {
		// TODO Auto-generated method stub
		return PromotionDataImpl.getInstance();
	}

	public GoodsManageDataService getGoodsManageDataService() {
		// TODO Auto-generated method stub
		return GoodsMangeDataServiceSerializableImpl.getInstance();
	}

	public Stock_controller_dataService getsStockDataService() {
		// TODO Auto-generated method stub
		return StockDataImpl.getInstance();
	}

}
