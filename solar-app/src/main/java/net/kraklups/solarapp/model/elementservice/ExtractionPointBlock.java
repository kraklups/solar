package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.elementprk.ExtractionPoint;

public class ExtractionPointBlock {

    private List<ExtractionPoint> extractionPoints;
    private boolean existMoreExtractionPoints;
	
    public ExtractionPointBlock(List<ExtractionPoint> extractionPoints, boolean existMoreExtractionPoints) {
        
        this.extractionPoints = extractionPoints;
        this.existMoreExtractionPoints = existMoreExtractionPoints;

    }
    
    public List<ExtractionPoint> getExtractionPoints() {
        return extractionPoints;
    }
    
    public boolean getExistMoreExtractionPoints() {
        return existMoreExtractionPoints;
    }
}
