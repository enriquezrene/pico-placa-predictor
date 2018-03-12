package com.predictor.validator;

import com.predictor.domain.TimeInterval;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PicoPlacaTimeValidatorTest {

    TimeInterval morningTimeInterval = new TimeInterval("06:59-09:31");
    TimeInterval afternoonTimeInterval = new TimeInterval("15:59-19:31");
    PicoPlacaTimeValidator picoPlacaTime = new PicoPlacaTimeValidator(morningTimeInterval, afternoonTimeInterval);

    @ParameterizedTest
    @ValueSource(strings = {"08:00", "07:00", "09:30", "18:00", "19:30"})
    void givenATime_whenItIsInAnyTimeInterval_theTimeHasRestriction(String time) {
        boolean hasRestriction = picoPlacaTime.hasRestriction(time);

        assertTrue(hasRestriction);
    }

    @ParameterizedTest
    @ValueSource(strings = {"06:59", "09:31", "21:00", "15:59"})
    void givenATime_whenItIsNotInAnyTimeInterval_theTimeHasNotRestriction(String time) {
        boolean hasRestriction = picoPlacaTime.hasRestriction(time);

        assertFalse(hasRestriction);
    }
}
