package com.predictor.domain;

import java.time.LocalTime;

public class TimeInterval {

    private LocalTime timeFrom;
    private LocalTime timeTo;

    public TimeInterval(String timeIntervalAsString) {
        setTimes(timeIntervalAsString);
    }

    private void setTimes(String timeIntervalAsString) {
        String[] timesAsString = timeIntervalAsString.split("-");
        timeFrom = LocalTime.parse(timesAsString[0]);
        timeTo = LocalTime.parse(timesAsString[1]);
    }

    public boolean isTimeIn(String timeAsString) {
        LocalTime time = LocalTime.parse(timeAsString);
        return time.isAfter(timeFrom) && time.isBefore(timeTo);
    }
}
