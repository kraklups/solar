package net.kraklups.solarapp.model.userservice;

import java.util.List;

import net.kraklups.solarapp.model.company.Company;

public class CompanyBlock {

    private List<Company> companies;
    private boolean existMoreCompanies;

    public CompanyBlock(List<Company> companies, boolean existMoreCompanies) {
        
        this.companies = companies;
        this.existMoreCompanies = existMoreCompanies;

    }
    
    public List<Company> getCompanies() {
        return companies;
    }
    
    public boolean getExistMoreCompanies() {
        return existMoreCompanies;
    }

}