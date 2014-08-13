package net.kraklups.solarapp.model.datavalue;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.modelutil.repositories.CustomDataValueRepository;

public class DataValueRepositoryImpl  implements CustomDataValueRepository {

	@Override
	public List<DataValue> getDataValueByDataValueId(Long dataValueId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}



}
