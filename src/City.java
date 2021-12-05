/*
Feedback is top of country class.
*/

/**
 * The city class, this will be the definition of a single city
 * @author Ben Wager
 * @since 23-11-2021
 */

public class City {

    // Variables

    // Static variables, used for magic numbers and repetitious strings
    private static final int LOWER_BOUNDARY = -12;
    private static final int UPPER_BOUNDARY = 11;
    private static final int TEN_MILLION = 10000000;
    private static final String UNFORMATTED_TO_STRING = "%s: has population %d and "
            + "is in time zone %d. It IS %sa megacity";

    // Variables for the class
    private final String name;
    private final String megaCityString;
    private final int population;
    private final int timeZone;
    private final boolean legalData;

    // Getters

    // getName() -> String
    public String getName() {
        return name;
    }

    /*
     getPopulation() -> int
     Sanitise the getter for population
     */
    public int getPopulation() {
        return Math.max(0, population);
    }

    // getTimeZone() -> int
    public int getTimeZone() {
        return timeZone;
    }

    // isLegalData() -> boolean
    public boolean isLegalData() {
        return legalData;
    }

    // Constructor and methods

    // Constructor(String, int, int)
    public City(String name, int population, int timeZone) {
        this.legalData = population > 0 && isTimezoneLegal(timeZone);
        this.name = name;
        this.population = Math.max(population, 0);
        this.timeZone = isTimezoneLegal(timeZone) ? timeZone : 0;
        this.megaCityString = population < TEN_MILLION ? "NOT " : "";
    }

    /*
    timeDifference(City) -> int
    Get the difference between the current city and a different city
     */
    public int timeDifference(City city) {
        return timeZone - city.getTimeZone();
    }

    /*
    isTimeZoneLegal(int) -> boolean
    Will see if the entered timezone is within the constraints.
     */
    public boolean isTimezoneLegal(int timezoneCheck) {
        return timezoneCheck >= LOWER_BOUNDARY && timezoneCheck <= UPPER_BOUNDARY;
    }

    /*
    toString() -> String
    Gives back the string representation of the city in the format:
    NAME: has population POP and is in time zone TIME_ZONE. It IS/IS NOT a megacity
     */
    public String toString() {
        return String.format(UNFORMATTED_TO_STRING,
                name, population, timeZone, megaCityString);
    }
}
