package net.kraklups.solarapp.model.elementservice;

import java.util.List;

import net.kraklups.solarapp.model.sensor.Sensor;

public class SensorBlock {

    private List<Sensor> sensors;
    private boolean existMoreSensors;
	
    public SensorBlock(List<Sensor> sensors, boolean existMoreSensors) {
        
        this.sensors = sensors;
        this.existMoreSensors = existMoreSensors;

    }
    
    public List<Sensor> getSensors() {
        return sensors;
    }
    
    public boolean getExistMoreSensors() {
        return existMoreSensors;
    }

}
