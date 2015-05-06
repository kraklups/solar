package net.kraklups.solarapp.model.taskprk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface TaskPrkDao extends GenericDao<TaskPrk, Long> {

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getTaskPrksByParkId(Long parkId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getTaskPrksByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getTaskPrksByRolId(Long roleId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getUpkeepsByParkId(Long parkId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getUpkeepsByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getUpkeepsByRoleId(Long roleId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getMonitorsByParkId(Long parkId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getMonitorsByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getMonitorsByRoleId(Long roleId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getTracksByParkId(Long parkId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getTracksByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getTracksByRoleId(Long roleId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getSynchronizesByParkId(Long parkId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getSynchronizesByUserProfileId(Long userProfileId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

	/**
	 * Returns a List of TaskPrk using the parkId (not element identifier)
	 *
	 * @param parkId not the module identifier
	 * @return list of taskPrks
	 */			     
	public List<TaskPrk> getSynchronizesByRoleId(Long roleId, int startIndex, int count) 
			throws InstanceNotFoundException; 	

    public List<TaskPrk> getTaskPrks(int startIndex, int count)
			throws InstanceNotFoundException;
    
}
