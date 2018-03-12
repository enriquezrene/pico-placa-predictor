package com.predictor.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberRestrictedValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void givenAListOfRestrictedNumbers_whenTheNumberToCheckIsInTheList_theNumberIsRestricted
            (int numberToCheck) {
        boolean isNumberRestricted = new NumberRestrictedValidator(1, 2, 3).isNumberRestricted(numberToCheck);
        assertTrue(isNumberRestricted);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 8, 52})
    void givenAListOfRestrictedNumbers_whenTheNumberToCheckIsINotnTheList_theNumberIsNotRestricted
            (int numberToCheck) {
        boolean isNumberRestricted = new NumberRestrictedValidator(1, 2, 3).isNumberRestricted(numberToCheck);
        assertFalse(isNumberRestricted);
    }
}
