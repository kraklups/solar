package net.kraklups.solarapp.model.parkservice;

import java.util.List;

import net.kraklups.solarapp.model.park.Park;

public class ParkBlock {

    private List<Park> parks;
    private boolean existMoreParks;
	
    public ParkBlock(List<Park> parks, boolean existMoreParks) {
        
        this.parks = parks;
        this.existMoreParks = existMoreParks;

    }
    
    public List<Park> getParks() {
        return parks;
    }
    
    public boolean getExistMoreParks() {
        return existMoreParks;
    }
}
