import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * MainClass
 *
 * @author caijinfu
 * @date 2021/12/18
 */
public class MainClass {
  public static void main(String[] args) {
    useLocalDate();
    useLocalTime();
    useLocalDateTime();
    useDuration();
    usePeriod();
    useDateTimeFormatter();
  }

  /** 格式化日期 */
  private static void useDateTimeFormatter() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDate date1 = LocalDate.now();
    System.out.println("date1 = " + date1);
    String formattedDate = date1.format(formatter);
    LocalDate date2 = LocalDate.parse(formattedDate, formatter);
    System.out.println("formattedDate = " + formattedDate);
    System.out.println("date2 = " + date2);
  }

  /** 比较日期 */
  private static void usePeriod() {
    LocalDate dateTime1 = LocalDate.of(2014, 3, 18);
    LocalDate dateTime2 = LocalDate.now();
    Period between = Period.between(dateTime1, dateTime2);
    int years = between.getYears();
    int months = between.getMonths();
    int days = between.getDays();
    System.out.println("Period between years = " + years + ", months = " + months + ", days = " + days);
  }

  /** 比较时间 */
  private static void useDuration() {
    Instant instant1 = Instant.now();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Instant instant2 = Instant.now();
    Duration between = Duration.between(instant1, instant2);
    System.out.println("Duration between= " + between);
  }

  /** 创建日期时间，比如几年几月几号几小时几分几秒 */
  private static void useLocalDateTime() {
    LocalDateTime now = LocalDateTime.now();
    LocalDate date = now.toLocalDate();
    LocalTime time = now.toLocalTime();
    System.out.println("now = " + now + ", date = " + date + ", time = " + time);
  }

  /** 创建时间，比如几小时几分几秒 */
  private static void useLocalTime() {
    LocalTime time = LocalTime.now();
    int hour = time.getHour();
    int minute = time.getMinute();
    int second = time.getSecond();
    System.out.println(
        "now = " + time + ", hour = " + hour + ", minute = " + minute + ", second = " + second);
  }

  /** 创建日期，比如几年几月几号 */
  private static void useLocalDate() {
    // now() : 从默认时区的系统时钟中获取当前日期。
    LocalDate date = LocalDate.now();
    int year = date.getYear();
    Month month = date.getMonth();
    int day = date.getDayOfMonth();
    DayOfWeek dow = date.getDayOfWeek();
    int len = date.lengthOfMonth();
    boolean leap = date.isLeapYear();
    System.out.println("date = " + date + ", year = " + year + ", month = " + month + ", day = " + day
            + ", dow = " + dow + ", len = " + len + ", leap = " + leap);
  }
}
