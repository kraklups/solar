package net.kraklups.solarapp.model.taskprkservice;

import java.util.List;

import net.kraklups.solarapp.model.taskprk.Synchronize;

public class SynchronizeBlock {

	private List<Synchronize> synchronizes;
	private boolean existMoreSynchronizes;
	
	public SynchronizeBlock(List<Synchronize> synchronizes, boolean existMoreSynchronizes) {
		
		this.synchronizes = synchronizes;
		this.existMoreSynchronizes = existMoreSynchronizes;
	}
	
	public List<Synchronize> getSynchronizes() {
		return synchronizes;
	}
	
	public boolean getExistMoreSynchronizes() {
		return existMoreSynchronizes;
	}
}
