package star16m.utils.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    public static SimpleDateFormat DATE_FORMAT_YYYYMMDD       = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat DATE_FORMAT_YYYYMMDDHHMMSS = new SimpleDateFormat("yyyyMMddHHmmss");
    public static String getYYYYMMDD() {
        return getYYYYMMDD(new Date());
    }
    public static String getYYYYMMDD(Date date) {
        return DATE_FORMAT_YYYYMMDD.format(date);
    }
    public static String getYYYYMMDDHHMMSS() {
        return getYYYYMMDDHHMMSS(new Date());
    }
    public static String getYYYYMMDDHHMMSS(Date date) {
        return DATE_FORMAT_YYYYMMDDHHMMSS.format(date);
    }
}
