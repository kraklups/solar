package net.kraklups.solarapp.model.userservice;

import java.util.List;

import net.kraklups.solarapp.model.module.Module;

public class ModuleBlock {

	private List<Module> modules;
	private boolean existMoreModules;
	
	public ModuleBlock(List<Module> modules, boolean existMoreModules) {
		
		this.modules = modules;
		this.existMoreModules = existMoreModules;
	}
	
	public List<Module> getModules() {
		return modules;
	}
	
	public boolean getExistMoreModules() {
		return existMoreModules;
	}
}
