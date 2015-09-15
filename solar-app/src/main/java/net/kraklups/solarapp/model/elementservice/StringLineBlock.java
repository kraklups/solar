package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.StringLine;

public class StringLineBlock {

    private List<StringLine> stringLines;
    private boolean existMoreStringLines;
	
    public StringLineBlock(List<StringLine> stringLines, boolean existMoreStringLines) {
        
        this.stringLines = stringLines;
        this.existMoreStringLines = existMoreStringLines;

    }
    
    public List<StringLine> getStringLines() {
        return stringLines;
    }
    
    public boolean getExistMoreStringLines() {
        return existMoreStringLines;
    }
}
