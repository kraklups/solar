package net.kraklups.solarapp.model.taskprk;

import java.util.List;

import net.kraklups.modelutil.exceptions.InstanceNotFoundException;
import net.kraklups.modelutil.repositories.CustomSynchronizeRepository;

public class SynchronizeRepositoryImpl implements CustomSynchronizeRepository<Synchronize, Long> {

	@Override
	public List<Synchronize> getSynchronizeBySynchronizeId(Long synchronizeId,
			int startIndex, int count) throws InstanceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
