package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.role.Role;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class RoleFormatter implements Formatter<Role> {

	private static final Logger logger = LoggerFactory.getLogger(RoleFormatter.class);
	
	@Override
	public String print(Role role, Locale locale) {
		
		logger.info("merde print: " + role);
		
		return role.getRoleId().toString();
	}

	@Override
	public Role parse(String roleId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + roleId);
		
		Role role = new Role();
		role.setRoleId(Long.parseLong(roleId));
		
		return role;
	}

}
