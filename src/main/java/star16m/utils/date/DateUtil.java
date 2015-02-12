package star16m.utils.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static SimpleDateFormat DATE_FORMAT_YYYYMMDD       = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat DATE_FORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String getYYYYMMDD() {
        return getYYYYMMDD(new Date());
    }
    public static String getYYYYMMDDHHMMSS() {
    	return getYYYYMMDDHHMMSS(new Date());
    }
    public static String getYYYYMMDDHHMMSS(Date date) {
    	return getDateString(date, DATE_FORMAT_YYYYMMDDHHMMSS);
    }
    public static String getYYYYMMDD(Date date) {
        return getDateString(date, DATE_FORMAT_YYYYMMDD);
    }
    public static String getDateString(Date date, SimpleDateFormat dateFormat) {
    	return dateFormat.format(date);
    }
    
    public static Date getYYYYMMDD(String dateString) {
    	Date date = null;
    	try {
    		date =  DATE_FORMAT_YYYYMMDD.parse(dateString);
    	} catch (ParseException e) {
    	}
    	return date;
    }
    public static Date getYYYYMMDDHHMMSS(String dateString) {
    	Date date = null;
    	try {
    		date =  DATE_FORMAT_YYYYMMDDHHMMSS.parse(dateString);
    	} catch (ParseException e) {
    	}
    	return date;
    }
}
