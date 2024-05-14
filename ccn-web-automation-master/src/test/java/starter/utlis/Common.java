package starter.utlis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Common {

    public static String createExpDate(int numberOfMonthsToAdd){
        return formatDate(addToCurrentDate(Calendar.MONTH, numberOfMonthsToAdd), "MM/yy");
    }

    public static String createStartDate(int numberOfDaysToAdd){
        return formatDate(addToCurrentDate(Calendar.DAY_OF_MONTH, numberOfDaysToAdd), "dd MMMM yyyy");
    }

    private static Date addToCurrentDate(int field, int amount){
        // Get current date
        Calendar calendar = Calendar.getInstance();
        calendar.add(field, amount);
        return calendar.getTime();
    }

    private static String formatDate(Date date, String format){
        // Define the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // Return the formatted date
        return dateFormat.format(date);
    }
}
