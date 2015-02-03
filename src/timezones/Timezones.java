/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package timezones;

import java.util.Date;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDateTime;


/**
 *
 * @author Expression lac32 is undefined on line 12, column 14 in Templates/Classes/Class.java.
 */
public class Timezones {
    DateTime local = new DateTime();
    
    
    public String localDate() {
        //Calendar local = new GregorianCalendar(TimeZone.getTimeZone("Europe/London"));
       // DateTime local = new DateTime();
    
        int localDay = local.getDayOfMonth();
        int localMonthInt = local.getMonthOfYear();
        int localYear = local.getYear();
        //String localMonth = "";
        //String ordinals = "";
        
       /* if(localMonthInt == 1) {
            localMonth = "January";
        }
        
        if(localDay == 9) {
            ordinals = "th";
        } */
        
        String date = localDay+"/"+localMonthInt+"/"+localYear;
        
       return date;
        
    } 
    
    public String localTime() {
        int localHour = local.getHourOfDay();
        int localMins = local.getMinuteOfHour();
        
        String time = localHour+":"+localMins;
        
        return time;
    }
    
    public String convertTimeZones(String destination) {
        
        DateTimeZone time = DateTimeZone.forID(destination);
        //String latTime = "";
        
        int off = time.getOffset(0);
        time.toTimeZone();
        String latTime = "GMT " + off/3.6e+6+"hours";
        
        return latTime;
    }
    
    public  String convertJodaTimezone(String srcTz, String destTz) {
         DateTime srcDateTime = local.toDateTime(DateTimeZone.forID(srcTz));
         DateTime dstDateTime = srcDateTime.withZone(DateTimeZone.forID(destTz));
        
         return dstDateTime.toLocalDateTime().toDateTime().toDate().toString();
}

}
