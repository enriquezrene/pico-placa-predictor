package com.predictor;

import com.predictor.domain.LicensePlate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PicoPlacaPredictorTest {

    private PicoPlacaPredictor picoPlacaPredictor = new PicoPlacaPredictor();

    private final String restrictedTime = "09:00";
    private final String nonRestrictedTime = "11:00";

    private final String mondayDate = "12-03-2018";
    private final String tuesdayDate = "13-03-2018";
    private final String wednesdayDate = "14-03-2018";
    private final String thursdayDate = "15-03-2018";
    private final String fridayDate = "16-03-2018";
    private final String saturdayDate = "17-03-2018";
    private final String sundayDate = "18-03-2018";

    @ParameterizedTest
    @ValueSource(strings = {"ABC1231", "ABC1232"})
    public void onMondayWithARestrictedTimeCarsWithLicensePlateEndingIn1or2CanNotBeOnTheRoad
            (String licensePlateAsString) {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, mondayDate, restrictedTime);

        assertFalse(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1233", "ABC1234"})
    public void onTuesdayWithARestrictedTimeCarsWithLicensePlateEndingIn3or4CanNotBeOnTheRoad
            (String licensePlateAsString) throws Exception {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, tuesdayDate, restrictedTime);

        assertFalse(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1235", "ABC1236"})
    public void onWednesdayWithARestrictedTimeCarsWithLicensePlateEndingIn5or6CanNotBeOnTheRoad
            (String licensePlateAsString) throws Exception {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, wednesdayDate, restrictedTime);

        assertFalse(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1237", "ABC1238"})
    public void onThursdayWithARestrictedTimeCarsWithLicensePlateEndingIn7or8CanNotBeOnTheRoad
            (String licensePlateAsString) throws Exception {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, thursdayDate, restrictedTime);

        assertFalse(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1239", "ABC1230"})
    public void onFridayWithARestrictedTimeCarsWithLicensePlateEndingIn9or0CanNotBeOnTheRoad
            (String licensePlateAsString) throws Exception {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, fridayDate, restrictedTime);

        assertFalse(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1230", "ABC1231", "ABC1232", "ABC1233", "ABC1234", "ABC1235", "ABC1236", "ABC127", "ABC1238", "ABC1239"})
    public void onSaturdayAllTheLicensePlatesCanBeOnTheRoad
            (String licensePlateAsString) throws Exception {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, saturdayDate, restrictedTime);

        assertTrue(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1230", "ABC1231", "ABC1232", "ABC1233", "ABC1234", "ABC1235", "ABC1236", "ABC127", "ABC1238", "ABC1239"})
    public void onSundayAllTheLicensePlatesCanBeOnTheRoad
            (String licensePlateAsString) throws Exception {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, sundayDate, restrictedTime);

        assertTrue(canBeOnTheRoad);
    }


    @ParameterizedTest
    @ValueSource(strings = {"ABC1231", "ABC1232"})
    public void onMondayWithNonRestrictedTimeCarsWithLicensePlateEndingIn1or2CanBeOnTheRoad
            (String licensePlateAsString) {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, mondayDate, nonRestrictedTime);

        assertTrue(canBeOnTheRoad);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABC1233", "ABC1234"})
    public void onTuesdayWithNonRestrictedTimeCarsWithLicensePlateEndingIn3or4CanBeOnTheRoad
            (String licensePlateAsString) {
        LicensePlate licensePlate = new LicensePlate(licensePlateAsString);

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, tuesdayDate, nonRestrictedTime);

        assertTrue(canBeOnTheRoad);
    }


    @ParameterizedTest
    @ValueSource(strings = {tuesdayDate, wednesdayDate, thursdayDate, fridayDate})
    public void licensePlateEndingIn1HaveNoRestrictionsInAnyDayButMonday
            (String dateAsString) {
        LicensePlate licensePlate = new LicensePlate("ABC1211");

        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, dateAsString, nonRestrictedTime);

        assertTrue(canBeOnTheRoad);
    }
}
