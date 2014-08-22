package net.kraklups.modelutil.repositories;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.taskprk.Synchronize;

@NoRepositoryBean
public interface CustomSynchronizeRepository <T, ID extends Serializable> {
	
    public List<Synchronize> getSynchronizeBySynchronizeId(Long synchronizeId,
			int startIndex, int count) throws InstanceNotFoundException;

}
