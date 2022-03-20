package io.cozyshare.backend.util;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {

    private static final ZoneId zoneId = ZoneId.of("Asia/Colombo");

    public static LocalDate getTodayLocalDate(){
        return LocalDate.now(zoneId);
    }

    public static LocalDateTime getLocalDateTime(){
        return LocalDateTime.now(zoneId);
    }

    public static Date getDateByString(String date){
        LocalDateTime formattedDate = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return Date.from(formattedDate.atZone(zoneId).toInstant());
    }
}
