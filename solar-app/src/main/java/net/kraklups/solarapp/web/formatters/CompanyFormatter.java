package net.kraklups.solarapp.web.formatters;

import java.text.ParseException;
import java.util.Locale;

import net.kraklups.solarapp.model.company.Company;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class CompanyFormatter implements Formatter<Company> {

	private static final Logger logger = LoggerFactory.getLogger(CompanyFormatter.class);
	
	@Override
	public String print(Company company, Locale locale) {
		
		logger.info("merde print: " + company);
		
		return company.getCompanyId().toString();
	}

	@Override
	public Company parse(String companyId, Locale locale) throws ParseException {
		
		logger.info("merde parse: " + companyId);
		
		Company company = new Company();
		company.setCompanyId(Long.parseLong(companyId));
		
		return company;
	}

}
