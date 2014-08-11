package net.kraklups.modelutil.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datavalue.DataValue;

@NoRepositoryBean
public interface DataValueRepository extends 
					CrudRepository<DataValue, Long> {

    public List<DataValue> getDataValueByDataValueId(Long dataValueId,
			int startIndex, int count) throws InstanceNotFoundException;
    
}
