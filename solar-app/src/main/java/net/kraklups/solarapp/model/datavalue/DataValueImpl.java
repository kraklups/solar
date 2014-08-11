package net.kraklups.solarapp.model.datavalue;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.modelutil.repositories.BaseRepository;
import net.kraklups.modelutil.repositories.DataValueRepository;


public class DataValueImpl<T, ID extends Serializable>  
				implements DataValueRepository {


	@Override
	public List<DataValue> getDataValueByDataValueId(Long dataValueId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}
