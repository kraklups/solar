package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.statetype.StateType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class StateTypeFormatter implements Formatter<StateType> {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(StateTypeFormatter.class);
	
	@Override
	public String print(StateType stateType, Locale locale) {
		
//		logger.info("merde print: " + stateType);
		
		return stateType.getStateTypeId().toString();
	}

	@Override
	public StateType parse(String stateTypeId, Locale locale) throws ParseException {
		
//		logger.info("merde parse: " + stateTypeId);
		
		StateType stateType = new StateType();
		stateType.setStateTypeId(Long.parseLong(stateTypeId));
		
		return stateType;
	}

}
