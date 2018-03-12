package com.predictor.validator;

import java.util.Arrays;
import java.util.List;

public class NumberRestrictedValidator {

    private List<Integer> restrictedNumbers;

    public NumberRestrictedValidator(Integer... restrictedNumbers) {
        this.restrictedNumbers = Arrays.asList(restrictedNumbers);
    }

    public boolean isNumberRestricted(int numberToCheck) {
        return restrictedNumbers.contains(numberToCheck);
    }
}
