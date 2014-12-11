package dataservice.stockdataservice;


import utility.MyTreeNode;


public interface GoodsManageDataService {
	public MyTreeNode getRoot();
	public void setRoot(MyTreeNode node);
	public MyTreeNode findGoods(String id);
	public void init();
	public void finish();
}
