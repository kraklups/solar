package net.kraklups.solarapp.model.dataservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Service("dataService")
@Transactional
public class DataServiceImpl implements DataService {

	public DataServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
