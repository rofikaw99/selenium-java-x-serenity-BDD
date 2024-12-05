package starter.utlis;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Common {

    public static String createExpDate(int numberOfMonthsToAdd){
        return formatDate(addToCurrentDate(Calendar.MONTH, numberOfMonthsToAdd), "MM/yy");
    }

    public static String createStartDate(int numberOfDaysToAdd){
        return formatDate(addToCurrentDate(Calendar.DAY_OF_MONTH, numberOfDaysToAdd), "dd MMMM yyyy");
    }

    public static String createFlightDate(int numberOfMonthsToAdd){
        return formatDate(addToCurrentDate(Calendar.MONTH, numberOfMonthsToAdd), "dd/MM/yyyy");
    }

    public static String todayDate(){
        return formatDate(addToCurrentDate(Calendar.MONTH, 0), "dd-MMM-yyyy");
    }
    public static String idForPayment(){
        return formatDate(addToCurrentDate(Calendar.MONTH, 0), "ddMMMHHmm");
    }
    public static String addedDatePayment(int amount){
        return formatDate(addToCurrentDate(Calendar.DATE, amount), "yyyy-MM-dd");
    }
    public static String todayDatePayment(){
        return formatDate(addToCurrentDate(Calendar.MONTH, 0), "YYYY-MM-dd HH:mm:ss");
    }

    public static String activeDate(){
        Instant now = Instant.now();

        // Convert to ZonedDateTime
        ZonedDateTime zonedDateTime = now.atZone(ZoneId.of("UTC"));

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

        // Format the ZonedDateTime
        return zonedDateTime.format(formatter);
    }

    public static String addDate(int numberOfDaysToAdd){
        String date = formatDate(addToCurrentDate(Calendar.DAY_OF_MONTH, numberOfDaysToAdd), "dd");
        if (date.startsWith("0")) date = date.replaceFirst("0", "");
        return date;
    }

    private static Date addToCurrentDate(int field, int amount){
        // Get current date
        Calendar calendar = Calendar.getInstance();
        calendar.add(field, amount);
        return calendar.getTime();
    }

    public static String chargeDateTimePayment(String field, int amount){
        // Get current UTC time
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.UTC);

        ZonedDateTime adjustedTime = null;
        // Add hours (e.g., add 5 hours)
        if (field.equals("HOURS"))
            adjustedTime = utcNow.plusHours(amount);
        else if (field.equals("DAYS"))
            adjustedTime = utcNow.plusDays(amount);
        else if (field.equals("MINUTES"))
            adjustedTime = utcNow.plusMinutes(amount);

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return adjustedTime.format(formatter);
    }

    private static String formatDate(Date date, String format){
        // Define the desired date format
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        // Return the formatted date
        return dateFormat.format(date);
    }

    public static boolean isSorted(List<String> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false; // Not sorted
            }
        }
        return true; // Sorted
    }
}
