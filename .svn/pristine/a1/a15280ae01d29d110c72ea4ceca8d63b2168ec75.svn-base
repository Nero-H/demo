package data.importdata;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import po.ImportPO;
import data.databaseutility.FileOperate;
import data.databaseutility.TimeNumber;
import dataservice.importdataservice.ImportDataService;

public class ImportDataImpl implements ImportDataService{
	private static ImportDataService importDatabase;
	HashMap<String, ImportPO> importList;
	int todayNumber;
	
	private ImportDataImpl() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public static ImportDataService getInstance(){
		if (importDatabase == null) {
			importDatabase = new ImportDataImpl();
		}
		return importDatabase;
	}
	
	public boolean insert(ImportPO po) {
		// TODO Auto-generated method stub
		if (importList.containsKey(po.getReceiptsID())) {
			return false;
		}
		importList.put(po.getReceiptsID(), po);
		todayNumber++;
		return true;
	}

	public void delete(String receiptsID) {
		// TODO Auto-generated method stub
		importList.remove(receiptsID);
	}

	public void update(ImportPO po) {
		// TODO Auto-generated method stub
		importList.put(po.getReceiptsID(), po);
	}

	public ImportPO find(String receiptsID) {
		// TODO Auto-generated method stub
		return importList.get(receiptsID);
	}

	@SuppressWarnings("unchecked")
	public void init() {
		// TODO Auto-generated method stub
		TimeNumber timeNumber = (TimeNumber) new FileOperate("importNumber.ser").read();
		if (timeNumber == null || timeNumber.isBeforeToday(Calendar.getInstance())) {
			todayNumber = 0;
		}else {
			todayNumber = timeNumber.getTodayNumber();
		}
		
		importList = (HashMap<String, ImportPO>)new FileOperate("src/import.ser").read();
		if (importList == null) {
			importList = new HashMap<String, ImportPO>();
		}
	}

	public void finish() {
		// TODO Auto-generated method stub
		TimeNumber timeNumber = new TimeNumber(todayNumber, Calendar.getInstance());
		new FileOperate("importNumber.ser").write(timeNumber);
		new FileOperate("src/import.ser").write(importList);
	}

	public ArrayList<ImportPO> getImportList() {
		// TODO Auto-generated method stub
		ArrayList<ImportPO> imports = new ArrayList<ImportPO>();
		imports.addAll(importList.values());
		return imports;
	}

	public int getTodayNum() {
		// TODO Auto-generated method stub
		return todayNumber;
	}

}
