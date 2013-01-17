package net.kraklups.modelutil.dao;

import java.io.Serializable;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface GenericDao <E, PK extends Serializable>{

	void save(E entity);

	E find(PK id) throws InstanceNotFoundException;

	boolean exists(PK id);

	void remove(PK id) throws InstanceNotFoundException;

}
