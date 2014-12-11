package po;

import utility.TimePeriod;

public class HistoryReportInfoPO {
	TimePeriod period;
	HistoryReportType historyReportType;
	ClientPO client;
	UserPO user;
	String storehouse;
	
	public HistoryReportInfoPO(TimePeriod period,
			HistoryReportType historyReportType, ClientPO client, UserPO user,
			String storehouse) {
		this.period = period;
		this.historyReportType = historyReportType;
		this.client = client;
		this.user = user;
		this.storehouse = storehouse;
	}

	public TimePeriod getPeriod() {
		return period;
	}

	public void setPeriod(TimePeriod period) {
		this.period = period;
	}

	public HistoryReportType getHistoryReportType() {
		return historyReportType;
	}

	public void setHistoryReportType(HistoryReportType historyReportType) {
		this.historyReportType = historyReportType;
	}

	public ClientPO getClient() {
		return client;
	}

	public void setClient(ClientPO client) {
		this.client = client;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public String getStorehouse() {
		return storehouse;
	}

	public void setStorehouse(String storehouse) {
		this.storehouse = storehouse;
	}
	
	
}
