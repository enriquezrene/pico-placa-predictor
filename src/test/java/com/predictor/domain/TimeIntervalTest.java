package com.predictor.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TimeIntervalTest {

    @ParameterizedTest
    @ValueSource(strings = {"08:00", "07:00", "09:30"})
    void givenAInterval_whenATimeIsContained_thenExpectsTrue(String time) {
        TimeInterval timeInterval = new TimeInterval("06:59-09:31");

        boolean isTimeContained = timeInterval.isTimeIn(time);

        assertTrue(isTimeContained);
    }


    @ParameterizedTest
    @ValueSource(strings = {"06:59", "09:31"})
    void givenAInterval_whenATimeIsNotContained_thenExpectsFalse(String time) {
        TimeInterval timeInterval = new TimeInterval("06:59-09:31");

        boolean isTimeContained = timeInterval.isTimeIn(time);

        assertFalse(isTimeContained);
    }
}
