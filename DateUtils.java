import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeFormatter;

// Custom Local Date Time Utils
class DateUtils {
  private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

  public static long getDifferenceHoursBetweenTwoDates(LocalDateTime date1, LocalDateTime date2) {
    // Using the Java class ChronoUnit
    // Get difference in seconds between two dates
    double differenceSeconds = ChronoUnit.SECONDS.between(date1, date2);
    // Return the nearest number to the total difference in hours
    return Math.round(differenceSeconds / 3600);
  }

  public static String getFormattedDate(LocalDateTime date) {
    // Format the date using the above DateTimeFormatter
    String formattedDate = date.format(formatter);
    // Return the string formatted date
    return formattedDate;
  }

  public static LocalDateTime getParsedDate(String date) {
    // Parse the string date using parse function of LocalDateTime
    LocalDateTime parsedDate = LocalDateTime.parse(date, formatter);
    // Return the LocalDateTime parsed date
    return parsedDate;
  }
}
