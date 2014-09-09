package net.kraklups.solarapp.model.taskprk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

import org.springframework.stereotype.Repository;

@Repository("TaskPrkDao")
public class TaskPrkDaoHibernate extends 
		GenericDaoHibernate<TaskPrk, Long> implements TaskPrkDao {

	@Override
	public List<TaskPrk> getTaskPrksByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTaskPrksByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTaskPrksByRolId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getUpkeepsByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getUpkeepsByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getUpkeepsByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getMonitorsByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getMonitorsByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getMonitorsByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTracksByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTracksByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getTracksByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getSynchronizesByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getSynchronizesByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TaskPrk> getSynchronizesByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
