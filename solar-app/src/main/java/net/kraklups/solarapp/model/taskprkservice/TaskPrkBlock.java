package net.kraklups.solarapp.model.taskprkservice;

import java.util.List;

import net.kraklups.solarapp.model.taskprk.TaskPrk;

public class TaskPrkBlock {

	private List<TaskPrk> taskPrks;
	private boolean existMoreTaskPrks;
	
	public TaskPrkBlock(List<TaskPrk> taskPrks, boolean existMoreTaskPrks) {
		
		this.taskPrks = taskPrks;
		this.existMoreTaskPrks = existMoreTaskPrks;
	}
	
	public List<TaskPrk> getTaskPrks() {
		return taskPrks;
	}
	
	public boolean getExistMoreTaskPrks() {
		return existMoreTaskPrks;
	}

}
