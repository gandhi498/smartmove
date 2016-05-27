/**
 * 
 */
package com.smartmove.util;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalTime;


/**
 * @author TCS
 *
 */
public class DateTimeConversionUtil {

    /**
     * 
     * @param departure_time
     * @param origin_time_zone
     * @return  the DateTime
     */
    public static DateTime getDateTimeValue(String departure_time, String origin_time_zone) {
        DateTimeZone airportTimeZone = getDateTimeZoneForOffset(origin_time_zone);
        Calendar localDateTime = Calendar.getInstance();
        DateTime dateTime = new DateTime(localDateTime.get(Calendar.YEAR), localDateTime.get(Calendar.MONTH) + 1, localDateTime.get(Calendar.DATE), getHourPartOfOffset(departure_time), getMinutesPartOfOffset(departure_time), localDateTime.get(Calendar.SECOND), 0, airportTimeZone);
        return dateTime;
    }

    public static DateTimeZone getDateTimeZoneForOffset(String origin_time_zone) {
        DateTimeZone airportTimeZone = null;
        if (StringUtils.isNotBlank(origin_time_zone)) {
            airportTimeZone = DateTimeZone.forOffsetHoursMinutes(getHourPartOfOffset(origin_time_zone), getMinutesPartOfOffset(origin_time_zone));
        }
        return airportTimeZone;
    }
    
    private static int getHourPartOfOffset(String offset) {
        int hourOffset = 0;
        if (offset.charAt(0) == '+') {
            hourOffset = Integer.valueOf(Integer.parseInt(offset.substring(1, 3)));
        } else if (offset.charAt(0) == '-') {
            hourOffset = -1 * Integer.valueOf(Integer.parseInt(offset.substring(1, 3)));
        } else {
            hourOffset = Integer.parseInt(offset.substring(0, 2));
        }
        return hourOffset;
    }
    
    private static int getMinutesPartOfOffset(String offset) {
        int minutesOffset = 0;
        if (offset.charAt(0) == '+' || offset.charAt(0) == '-') {
            minutesOffset = Integer.parseInt(offset.substring(4));
        } else {
            minutesOffset = Integer.parseInt(offset.substring(3));
        }
        return minutesOffset;
    }

    public static DateTime getDateTimeValue(DateTime dateTimeValue, String flight_hours, String arrival_time_zone) {
        DateTimeZone airportTimeZone = getDateTimeZoneForOffset(arrival_time_zone);
        dateTimeValue = dateTimeValue.plusMinutes(getMinutesPartOfOffset(flight_hours));
        dateTimeValue = dateTimeValue.plusMinutes(getHourPartOfOffset(flight_hours));
        dateTimeValue = new DateTime(dateTimeValue.getYear(), dateTimeValue.getMonthOfYear() + 1, dateTimeValue.getDayOfMonth(), dateTimeValue.getHourOfDay(), dateTimeValue.getMinuteOfHour(), dateTimeValue.getSecondOfMinute(), dateTimeValue.getMillisOfSecond(), airportTimeZone);
        return dateTimeValue;
    }

    public static DateTime getCurrentTime(String origin_time_zone) {
        DateTime datetime = new DateTime(getDateTimeZoneForOffset(origin_time_zone));
        return datetime;
    }
}
