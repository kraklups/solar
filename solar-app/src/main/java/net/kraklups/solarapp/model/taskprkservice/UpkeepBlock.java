package net.kraklups.solarapp.model.taskprkservice;

import java.util.List;

import net.kraklups.solarapp.model.taskprk.Upkeep;

public class UpkeepBlock {

	private List<Upkeep> upkeeps;
	private boolean existMoreUpkeeps;
	
	public UpkeepBlock(List<Upkeep> upkeeps, boolean existMoreUpkeeps) {
		
		this.upkeeps = upkeeps;
		this.existMoreUpkeeps = existMoreUpkeeps;
	}
	
	public List<Upkeep> getUpkeeps() {
		return upkeeps;
	}
	
	public boolean getExistMoreUpkeeps() {
		return existMoreUpkeeps;
	}

}
