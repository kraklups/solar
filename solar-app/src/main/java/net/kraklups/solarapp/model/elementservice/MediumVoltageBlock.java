package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.MediumVoltage;

public class MediumVoltageBlock {

    private List<MediumVoltage> mediumVoltages;
    private boolean existMoreMediumVoltages;
	
    public MediumVoltageBlock(List<MediumVoltage> mediumVoltages, boolean existMoreMediumVoltages) {
        
        this.mediumVoltages = mediumVoltages;
        this.existMoreMediumVoltages = existMoreMediumVoltages;

    }
    
    public List<MediumVoltage> getMediumVoltages() {
        return mediumVoltages;
    }
    
    public boolean getExistMoreMediumVoltages() {
        return existMoreMediumVoltages;
    }	
}
