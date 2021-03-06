package net.kraklups.solarapp.model.alarm;

import java.util.Date;
import java.util.List;

import net.kraklups.modelutil.dao.GenericDao;
import net.kraklups.modelutil.exceptions.InstanceNotFoundException;

public interface AlarmDao extends GenericDao<Alarm, Long> {

    /**
     * Returns a List of Alarm using the element tag (not element identifier)
     *
     * @param alarmTag not the module identifier
     * @return list of alarms
     */			     
     public List<Alarm> getAlarmsByAlarmTag(String alarmTag, int startIndex, int count) 
            throws InstanceNotFoundException; 	

     /**
      * Returns a List of Alarm using the triggerDate (not element identifier)
      *
      * @param triggerDate not the module identifier
      * @return list of alarms
      */			     
      public List<Alarm> getAlarmsByTriggerDate(Date triggerDate, int startIndex, int count) 
             throws InstanceNotFoundException; 	
   
      /**
       * Returns a List of Alarm using the eventTskId (not element identifier)
       *
       * @param eventTskId not the module identifier
       * @return list of alarms
       */			     
       public List<Alarm> getAlarmsByEventTskId(Long eventTskId, int startIndex, int count) 
              throws InstanceNotFoundException; 	

   	public List<Alarm> getAlarms(int startIndex, int count)
			throws InstanceNotFoundException;
   	
   	public int countAlarmsTriggered()
			throws InstanceNotFoundException; 
   	
   	public List<Alarm> getAlarmsTriggered(int startIndex, int count)
			throws InstanceNotFoundException;    	
   	
}
