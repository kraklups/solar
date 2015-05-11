package net.kraklups.solarapp.model.parkservice;

import java.util.List;

import net.kraklups.solarapp.model.statetype.StateType;

public class StateTypeBlock {

    private List<StateType> stateTypes;
    private boolean existMoreStateTypes;
	
    public StateTypeBlock(List<StateType> stateTypes, boolean existMoreStateTypes) {
        
        this.stateTypes = stateTypes;
        this.existMoreStateTypes = existMoreStateTypes;

    }
    
    public List<StateType> getStateTypes() {
        return stateTypes;
    }
    
    public boolean getExistMoreStateTypes() {
        return existMoreStateTypes;
    }
}
