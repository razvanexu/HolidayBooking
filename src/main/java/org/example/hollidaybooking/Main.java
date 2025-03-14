package org.example.hollidaybooking;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static LocalDate sqlDateConverter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
//        String s = "Tue Mar 04 2025";
        //        System.out.println(localDate);
//        Date date = Date.valueOf(localDate);
//        System.out.println("sql date: " + date);
        return LocalDate.parse(date, formatter);
    }
}
