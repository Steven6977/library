package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {
    public static String getDate() {
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateformat.format(new Date());
    }
}
