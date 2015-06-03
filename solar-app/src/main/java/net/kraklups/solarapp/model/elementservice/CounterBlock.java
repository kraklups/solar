package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.Counter;

public class CounterBlock {

    private List<Counter> counters;
    private boolean existMoreCounters;
	
    public CounterBlock(List<Counter> counters, boolean existMoreCounters) {
        
        this.counters = counters;
        this.existMoreCounters = existMoreCounters;

    }
    
    public List<Counter> getCounters() {
        return counters;
    }
    
    public boolean getExistMoreCounters() {
        return existMoreCounters;
    }

}
