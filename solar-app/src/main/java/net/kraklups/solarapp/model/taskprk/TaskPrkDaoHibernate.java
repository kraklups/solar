package net.kraklups.solarapp.model.taskprk;

import java.util.List;

import net.kraklups.modelutil.dao.GenericDaoHibernate;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.report.Report;

import org.springframework.stereotype.Repository;

@Repository("TaskPrkDao")
public class TaskPrkDaoHibernate extends 
		GenericDaoHibernate<TaskPrk, Long> implements TaskPrkDao {

	@Override
	@SuppressWarnings("unchecked")	
	public List<TaskPrk> getTaskPrksByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM TaskPrk a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.taskPrkId").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(parkId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getTaskPrksByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM TaskPrk a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.taskPrkId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(userProfileId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}	
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getTaskPrksByRolId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM TaskPrk a WHERE a.roleId = :roleId " +
	        	"ORDER BY a.taskPrkId").
	         	setParameter("roleId", roleId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(roleId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getUpkeepsByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Upkeep a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.upkeepId").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(parkId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getUpkeepsByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Upkeep a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.upkeepId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(userProfileId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getUpkeepsByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Upkeep a WHERE a.roleId = :roleId " +
	        	"ORDER BY a.upkeepId").
	         	setParameter("roleId", roleId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(roleId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getMonitorsByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Monitor a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.monitorId").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(parkId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getMonitorsByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Monitor a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.monitorId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(userProfileId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getMonitorsByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Monitor a WHERE a.roleId = :roleId " +
	        	"ORDER BY a.monitorId").
	         	setParameter("roleId", roleId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(roleId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getTracksByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Track a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.trackId").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(parkId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getTracksByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Track a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.trackId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(userProfileId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getTracksByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Track a WHERE a.roleId = :roleId " +
	        	"ORDER BY a.trackId").
	         	setParameter("roleId", roleId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(roleId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getSynchronizesByParkId(Long parkId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Synchronize a WHERE a.parkId = :parkId " +
	        	"ORDER BY a.synchronizeId").
	         	setParameter("parkId", parkId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(parkId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getSynchronizesByUserProfileId(Long userProfileId,
			int startIndex, int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Synchronize a WHERE a.userProfileId = :userProfileId " +
	        	"ORDER BY a.synchronizeId").
	         	setParameter("userProfileId", userProfileId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(userProfileId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getSynchronizesByRoleId(Long roleId, int startIndex,
			int count) throws InstanceNotFoundException {
		
		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM Synchronize a WHERE a.roleId = :roleId " +
	        	"ORDER BY a.synchronizeId").
	         	setParameter("roleId", roleId).
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(roleId, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<TaskPrk> getTaskPrks(int startIndex, int count)
			throws InstanceNotFoundException {

		List<TaskPrk> taskPrks = (List<TaskPrk>)  getSession().createQuery(
	        	"SELECT a FROM TaskPrk a " +
	        	"ORDER BY a.taskPrkId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (taskPrks == null) {
			throw new InstanceNotFoundException(null, TaskPrk.class.getName());
		} else {
			return taskPrks;
		}
	}

	@Override
	@SuppressWarnings("unchecked")	
	public List<Upkeep> getUpkeeps(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Upkeep> upkeeps = (List<Upkeep>)  getSession().createQuery(
	        	"SELECT a FROM Upkeep a " +
	        	"ORDER BY a.upkeepId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (upkeeps == null) {
			throw new InstanceNotFoundException(null, Upkeep.class.getName());
		} else {
			return upkeeps;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Report> getReports(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Report> reports = (List<Report>)  getSession().createQuery(
	        	"SELECT a FROM Report a " +
	        	"ORDER BY a.reportId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (reports == null) {
			throw new InstanceNotFoundException(null, Report.class.getName());
		} else {
			return reports;
		}

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Synchronize> getSynchronizes(int startIndex, int count)
			throws InstanceNotFoundException {

		List<Synchronize> synchronizes = (List<Synchronize>)  getSession().createQuery(
	        	"SELECT a FROM Synchronize a " +
	        	"ORDER BY a.synchronizeId").
	           	setFirstResult(startIndex).
	           	setMaxResults(count).list();
		
		if (synchronizes == null) {
			throw new InstanceNotFoundException(null, Synchronize.class.getName());
		} else {
			return synchronizes;
		}
	}

}
