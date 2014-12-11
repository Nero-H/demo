package dataservice.importdataservice;

import java.util.ArrayList;

import po.ImportPO;

public interface ImportDataService {
	public boolean insert(ImportPO po);
	public void delete(String receiptsID);
	public void update(ImportPO po);
	public ImportPO find(String receiptsID);
	public ArrayList<ImportPO> getImportList();
	public void init();
	public void finish();
	public int getTodayNum();
}
