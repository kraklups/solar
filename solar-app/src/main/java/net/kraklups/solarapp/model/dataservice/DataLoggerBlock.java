package net.kraklups.solarapp.model.dataservice;

import java.util.List;

import net.kraklups.solarapp.model.datalogger.DataLogger;

public class DataLoggerBlock {

	private List<DataLogger> dataLoggers;
	private boolean existMoreDataLoggers;
	
	public DataLoggerBlock(List<DataLogger> dataLoggers, boolean existMoreDataLoggers) {
		
		this.dataLoggers = dataLoggers;
		this.existMoreDataLoggers = existMoreDataLoggers;
	}
	
	public List<DataLogger> getDataLoggers() {
		return dataLoggers;
	}
	
	public boolean getExistMoreDataLoggers() {
		return existMoreDataLoggers;
	}

}
