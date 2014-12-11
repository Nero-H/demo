package utility;

import java.util.Vector;

import javax.swing.table.*;

public class MyModel extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("rawtypes")
	Vector columnNames,rows;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MyModel() {
		// TODO Auto-generated constructor stub
		columnNames=new Vector();
		columnNames.add("姓名");
		columnNames.add("类型");
		columnNames.add("ID");
		columnNames.add("密码");
		columnNames.add("等级");
		//f
		rows=new Vector();
		
		
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	void addRow(Vector v){
		 rows.add(v); 
	 }
	
	void removeRow(int r){
		 rows.remove(r); 
	 }

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rows.size();
	}
	

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {  
		return getValueAt(0, c).getClass();  
	}

	@SuppressWarnings("rawtypes")
	public Object getValueAt(int row, int column) {
		// TODO Auto-generated method stub
		return ((Vector)this.rows.get(row)).get(column);
	}
	
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	public void setValueAt(Object value, int row, int column) {  
		 ((Vector)this.rows.get(row)).set(column, value);
		 fireTableCellUpdated(row, column);  
		 
	 }  
	 
	 public boolean isCellEditable(int row, int col) {  
	        //Note that the data/cell address is constant,  
	        //no matter where the cell appears onscreen.  
	     if(col==2){
	    	 return false;
	     }   
		 return true;  
	        
	 }  
}
