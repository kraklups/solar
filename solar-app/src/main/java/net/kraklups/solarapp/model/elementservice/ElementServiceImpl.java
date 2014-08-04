package net.kraklups.solarapp.model.elementservice;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.kraklups.modelutil.exceptions.DuplicateInstanceException;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

@Service("elementService")
@Transactional
public class ElementServiceImpl implements ElementService {

	public ElementServiceImpl() {
		// TODO Auto-generated constructor stub
	}

}
