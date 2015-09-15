package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.ArrayBox;

public class ArrayBoxBlock {

    private List<ArrayBox> arrayBoxs;
    private boolean existMoreArrayBoxs;
	
    public ArrayBoxBlock(List<ArrayBox> arrayBoxs, boolean existMoreArrayBoxs) {
        
        this.arrayBoxs = arrayBoxs;
        this.existMoreArrayBoxs = existMoreArrayBoxs;

    }
    
    public List<ArrayBox> getArrayBoxs() {
        return arrayBoxs;
    }
    
    public boolean getExistMoreArrayBoxs() {
        return existMoreArrayBoxs;
    }
}
