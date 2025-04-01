package com.aps.ProjectAps.config;


import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Slf4j
public class DateUtil {

	public static Timestamp getCurrentDate() {
        Timestamp today = null;
        try {
            Date nowDate = Calendar.getInstance().getTime();
            today = new Timestamp(nowDate.getTime());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return today;
    }


}
