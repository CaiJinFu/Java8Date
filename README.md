# Java8Date

Java8新增的关于日期时间的API

## LocalDate

```java
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
    // date = 2021-12-19, year = 2021, month = DECEMBER, day = 19, dow = SUNDAY, len = 31, leap = false
  }
```

## LocalTime

```java
/** 创建时间，比如几小时几分几秒 */
private static void useLocalTime() {
  LocalTime time = LocalTime.now();
  int hour = time.getHour();
  int minute = time.getMinute();
  int second = time.getSecond();
  System.out.println(
      "now = " + time + ", hour = " + hour + ", minute = " + minute + ", second = " + second);
  // now = 01:01:25.761, hour = 1, minute = 1, second = 25
}
```

## LocalDateTime

```java
/** 创建日期时间，比如几年几月几号几小时几分几秒 */
private static void useLocalDateTime() {
  LocalDateTime now = LocalDateTime.now();
  LocalDate date = now.toLocalDate();
  LocalTime time = now.toLocalTime();
  System.out.println("now = " + now + ", date = " + date + ", time = " + time);
  // now = 2021-12-19T01:01:25.761, date = 2021-12-19, time = 01:01:25.761
}
```

## Duration

```java
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
  // Duration between= PT2.007S
}
```

## Period

```java
/** 比较日期 */
private static void usePeriod() {
  LocalDate dateTime1 = LocalDate.of(2014, 3, 18);
  LocalDate dateTime2 = LocalDate.now();
  Period between = Period.between(dateTime1, dateTime2);
  int years = between.getYears();
  int months = between.getMonths();
  int days = between.getDays();
  System.out.println("Period between years = " + years + ", months = " + months + ", days = " + days);
  // Period between years = 7, months = 9, days = 1
}
```

## DateTimeFormatter

```java
/** 格式化日期 */
private static void useDateTimeFormatter() {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
  LocalDate date1 = LocalDate.now();
  System.out.println("date1 = " + date1);
  String formattedDate = date1.format(formatter);
  LocalDate date2 = LocalDate.parse(formattedDate, formatter);
  System.out.println("formattedDate = " + formattedDate);
  System.out.println("date2 = " + date2);
  // date1 = 2021-12-19
  // formattedDate = 2021/12/19
  // date2 = 2021-12-19
}
```
