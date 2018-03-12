package com.predictor.domain;

import lombok.Getter;

public class LicensePlate {

    public LicensePlate(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
        this.setLastDigit(stringRepresentation);
    }

    private void setLastDigit(String stringRepresentation) {
        String lastDigitAsString = stringRepresentation.substring(stringRepresentation.length() - 1);
        this.lastDigit = Integer.valueOf(lastDigitAsString);
    }

    @Getter
    private int lastDigit;

    @Getter
    private String stringRepresentation;
}
