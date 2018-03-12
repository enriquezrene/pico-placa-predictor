package com.predictor;

import com.predictor.domain.LicensePlate;
import com.predictor.domain.TimeInterval;
import com.predictor.validator.NumberRestrictedValidator;
import com.predictor.validator.PicoPlacaTimeValidator;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class PicoPlacaPredictor {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private final Map<DayOfWeek, NumberRestrictedValidator> daysWithValidatorsMap;
    private final PicoPlacaTimeValidator picoPlacaTime;

    public PicoPlacaPredictor() {
        picoPlacaTime = new PicoPlacaTimeValidator(new TimeInterval("06:59-09:31"), new TimeInterval("15:59-19:31"));

        daysWithValidatorsMap = new HashMap<>();
        daysWithValidatorsMap.put(DayOfWeek.MONDAY, new NumberRestrictedValidator(1, 2));
        daysWithValidatorsMap.put(DayOfWeek.TUESDAY, new NumberRestrictedValidator(3, 4));
        daysWithValidatorsMap.put(DayOfWeek.WEDNESDAY, new NumberRestrictedValidator(5, 6));
        daysWithValidatorsMap.put(DayOfWeek.THURSDAY, new NumberRestrictedValidator(7, 8));
        daysWithValidatorsMap.put(DayOfWeek.FRIDAY, new NumberRestrictedValidator(9, 0));
        daysWithValidatorsMap.put(DayOfWeek.SATURDAY, new NumberRestrictedValidator(-1));
        daysWithValidatorsMap.put(DayOfWeek.SUNDAY, new NumberRestrictedValidator(-1));
    }

    public boolean canBeOnTheRoad(LicensePlate licensePlate, String date, String time) {
        if (picoPlacaTime.hasRestriction(time)) {
            DayOfWeek dayOfWeek = LocalDate.parse(date, DATE_TIME_FORMATTER).getDayOfWeek();
            int lastDigitFromLicensePlate = licensePlate.getLastDigit();
            return !daysWithValidatorsMap.get(dayOfWeek).isNumberRestricted(lastDigitFromLicensePlate);
        } else {
            return true;
        }
    }


}
