package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.ElectricalSubstation;

public class ElectricalSubstationBlock {

    private List<ElectricalSubstation> electricalSubstations;
    private boolean existMoreElectricalSubstations;
	
    public ElectricalSubstationBlock(List<ElectricalSubstation> electricalSubstations, boolean existMoreElectricalSubstations) {
        
        this.electricalSubstations = electricalSubstations;
        this.existMoreElectricalSubstations = existMoreElectricalSubstations;

    }
    
    public List<ElectricalSubstation> getElectricalSubstations() {
        return electricalSubstations;
    }
    
    public boolean getExistMoreElectricalSubstations() {
        return existMoreElectricalSubstations;
    }	

}
