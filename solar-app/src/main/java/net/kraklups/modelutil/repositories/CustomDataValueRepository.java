package net.kraklups.modelutil.repositories;

import java.io.Serializable;
import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.solarapp.model.datavalue.DataValue;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CustomDataValueRepository<T, ID extends Serializable> {
	
    public List<DataValue> getDataValueByDataValueId(Long dataValueId,
			int startIndex, int count) throws InstanceNotFoundException;
	
}
