package net.kraklups.solarapp.model.parkservice;

import java.util.List;

import net.kraklups.solarapp.model.state.State;

public class StateBlock {

    private List<State> states;
    private boolean existMoreStates;
	
    public StateBlock(List<State> states, boolean existMoreStates) {
        
        this.states = states;
        this.existMoreStates = existMoreStates;

    }
    
    public List<State> getStates() {
        return states;
    }
    
    public boolean getExistMoreStates() {
        return existMoreStates;
    }
}
