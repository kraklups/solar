package net.kraklups.solarapp.model.taskprk;

import net.kraklups.modelutil.dao.GenericDaoHibernate;

import org.springframework.stereotype.Repository;

@Repository("TaskPrkDao")
public class TaskPrkDaoHibernate extends 
		GenericDaoHibernate<TaskPrk, Long> implements TaskPrkDao {

}
