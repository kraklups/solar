package net.kraklups.solarapp.model.datavalue;

import java.util.List;

public class DataValueBlock {

	private List<DataValue> dataValues;
	private boolean existMoreDataValues;
	
	public DataValueBlock(List<DataValue> dataValues, boolean existMoreDataValues) {
		
		this.dataValues = dataValues;
		this.existMoreDataValues = existMoreDataValues;
	}
	
	public List<DataValue> getDataValues() {
		return dataValues;
	}
	
	public boolean getExistMoreDataValues() {
		return existMoreDataValues;
	}

}
