package data.databaseutility;

import java.io.Serializable;
import java.util.Calendar;

public class TimeNumber implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int todayNumber;
	private Calendar date;
	
	public TimeNumber(int number, Calendar date) {
		// TODO Auto-generated constructor stub
		this.todayNumber = number;
		this.date = date;
	}
	
	public boolean isBeforeToday(Calendar date2) {
		if (date.get(Calendar.YEAR) < date2.get(Calendar.YEAR)) {
			return true;
		}
		else if (date.get(Calendar.MONTH) < date2.get(Calendar.MONTH)) {
			return true;
		}
		else if (date.get(Calendar.DATE) < date2.get(Calendar.DATE)) {
			return true;
		}
		return false;
	}

	public int getTodayNumber() {
		return todayNumber;
	}
	
	
}
