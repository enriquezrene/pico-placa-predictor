# pico-placa-predictor
This project has been written in Java using JUnit 5 as testing library.

The main class of this application is `PicoPlacaPredictor` which has the `canBeOnTheRoad(String licensePlateAsString, String date, String time)` method to validate if a license plate can/can't be on the road.

- ***licensePlate*** The method expects a valid license plate, the unique restriction is the last char should be a number, otherwise you'll retrieve an exception.
- ***date*** should follow the format dd-MM-yyyy
- ***time*** should follow the format hh:mm

The test class `PicoPlacaPredictorTest` has some tests to validate how the application works. 
The test methods names are describing their intention by themselves. For example, it;s pretty obvious that the next method is validating
if a license plate ending in 1 or 2 can/can't be on the road at a pre-defined time:

```java
    @ParameterizedTest
    @ValueSource(strings = {"ABC1231", "ABC1232"})
    public void onMondayWithARestrictedTimeCarsWithLicensePlateEndingIn1or2CanNotBeOnTheRoad
            (String licensePlate) {
        boolean canBeOnTheRoad = picoPlacaPredictor.canBeOnTheRoad(licensePlate, mondayDate, restrictedTime);

        assertFalse(canBeOnTheRoad);
    }
```

In order to trigger the tests, go to the project directory and type:

```sh
./gradlew test
```

If you're interested in modifying this project make sure to install the [lombok](https://projectlombok.org) plugin in your IDE.
