package learning.spacex.com.futureinskies;


public class DateUtils {

    public static String convertUnixdateToString(Long epoch) {
        return new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new java.util.Date(epoch * 1000));
    }

}
