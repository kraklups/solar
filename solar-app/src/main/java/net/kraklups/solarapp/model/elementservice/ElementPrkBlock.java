package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.ElementPrk;

public class ElementPrkBlock {

    private List<ElementPrk> elements;
    private boolean existMoreElements;
	
    public ElementPrkBlock(List<ElementPrk> elements, boolean existMoreElements) {
        
        this.elements = elements;
        this.existMoreElements = existMoreElements;

    }
    
    public List<ElementPrk> getElements() {
        return elements;
    }
    
    public boolean getExistMoreElements() {
        return existMoreElements;
    }

}
