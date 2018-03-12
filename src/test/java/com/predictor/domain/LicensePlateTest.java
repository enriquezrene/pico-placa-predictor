package com.predictor.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LicensePlateTest {

    @Test
    public void givenAPlate_WhenTheLastCharacterIsNotNumber_ThenAnExceptionIsThrown() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> new LicensePlate("PCN765X"));
    }

    @Test
    public void givenAPlate_WhenTheLastCharacterIsNumber_TheLastDigitIsSet() throws Exception {
        LicensePlate licensePlate = new LicensePlate("PCN7657");

        assertEquals(7, licensePlate.getLastDigit());
    }
}
