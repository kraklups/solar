package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.ElementPrk;

public class ElementPrkBlock {

    private List<ElementPrk> elementPrks;
    private boolean existMoreElementPrks;
	
    public ElementPrkBlock(List<ElementPrk> elementPrks, boolean existMoreElementPrks) {
        
        this.elementPrks = elementPrks;
        this.existMoreElementPrks = existMoreElementPrks;
    }
    
    public List<ElementPrk> getElementPrks() {
        return elementPrks;
    }
    
    public boolean getExistMoreElementPrks() {
        return existMoreElementPrks;
    }

}
