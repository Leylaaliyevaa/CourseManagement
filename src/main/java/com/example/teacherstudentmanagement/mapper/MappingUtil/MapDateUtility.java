package com.example.teacherstudentmanagement.mapper.MappingUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MapDateUtility {
    public static String mapToDateString(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return dateTime.format(formatter);
    }

    public static LocalDateTime mapToLocalDateTime(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(date, formatter);
    }
}
