package net.kraklups.solarapp.model.parkservice;

import java.util.List;

import net.kraklups.solarapp.model.timetable.Timetable;

public class TimetableBlock {

    private List<Timetable> timetables;
    private boolean existMoreTimetables;
	
    public TimetableBlock(List<Timetable> timetables, boolean existMoreTimetables) {
        
        this.timetables = timetables;
        this.existMoreTimetables = existMoreTimetables;

    }
    
    public List<Timetable> getTimetables() {
        return timetables;
    }
    
    public boolean getExistMoreTimetables() {
        return existMoreTimetables;
    }
}
