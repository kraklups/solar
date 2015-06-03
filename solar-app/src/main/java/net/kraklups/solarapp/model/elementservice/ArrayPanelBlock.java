package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.ArrayPanel;

public class ArrayPanelBlock {

    private List<ArrayPanel> arrayPanels;
    private boolean existMoreArrayPanels;
	
    public ArrayPanelBlock(List<ArrayPanel> arrayPanels, boolean existMoreArrayPanels) {
        
        this.arrayPanels = arrayPanels;
        this.existMoreArrayPanels = existMoreArrayPanels;

    }
    
    public List<ArrayPanel> getArrayPanels() {
        return arrayPanels;
    }
    
    public boolean getExistMoreArrayPanels() {
        return existMoreArrayPanels;
    }	
}
