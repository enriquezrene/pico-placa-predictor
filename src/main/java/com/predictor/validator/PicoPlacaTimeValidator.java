package com.predictor.validator;

import com.predictor.domain.TimeInterval;

import java.util.Arrays;
import java.util.List;

public class PicoPlacaTimeValidator {

    private final List<TimeInterval> timeIntervals;

    public PicoPlacaTimeValidator(TimeInterval morningRestriction, TimeInterval afternoonRestriction) {
        this.timeIntervals = Arrays.asList(new TimeInterval[]{morningRestriction, afternoonRestriction});
    }

    public boolean hasRestriction(String timeAsString) {
        return timeIntervals.stream().anyMatch(timeInterval -> timeInterval.isTimeIn(timeAsString));
    }
}
