import java.util.ArrayList;

/*
Response to feedback:
In the last piece of coursework, I clearly overcomplicated what I did, I used data types we hadn't learned yet, and it
didn't make my coursework any more readable. However on this coursework I have attempted to make my coursework as
readable as possible as well as being the right complexity that is needed.

I defined my final variables where I needed in this program and withheld my use of control flow statements like
break and continue. My hope is that this makes this program more readable. I've also tried to massively tone down my
comments and only do one per method as the methods in this program are fairly short. I've taken your advice about
putting the comment just above the method.
*/

/**
 * The country class, these will contain cities.
 * @author Ben Wager
 */

public class Country {

    // Variables

    // Static variable, in this case used ofr the toString() method, needs to be formatted
    private static final String UNFORMATTED_TO_STRING = "%s: total population: %d, "
            + "population outside listed cities: %d, with cities%n";

    // Variables for the class
    private final String name;
    private final int population;
    private final ArrayList<City> cities;
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

    /*
    isLegalData() -> boolean
    Check if data is legal
     */
    public boolean isLegalData() {
        return legalData;
    }

    // Constructor and methods

    // Constructor(String, int)
    public Country(String name, int population) {
        this.legalData = population > 0;
        this.name = name;
        this.population = Math.max(population, 0);
        this.cities = new ArrayList<>();
    }

    /*
    addCity(String, int, int) -> void
    Adds a city to the list
     */
    public void addCity(String name, int population, int timeZone) {
        City c = new City(name, population, timeZone);
        cities.add(c);
    }

    /*
    getCityByName(String) -> City
    Finds the city in the list given the name of it
     */
    public City getCityByName(String search) {
        for (City city : cities) {
            // If the city matches, get it
            if (search.equals(city.getName())) {
                return city;
            }
        }
        return null;
    }

    /*
    getCitiesPopulation() -> int
    Adds the populations within the cities together
     */
    public int getCitiesPopulation() {
        int sum = 0;
        for (City city : cities) {
            sum += city.getPopulation();
        }

        return sum;
    }

    /*
    getPopulationOutsideCities() -> int
    Gets population that are outside cities
     */
    public int getPopulationOutsideCities() {
        return population - getCitiesPopulation();
    }

    /*
    deleteCity(String) -> boolean
    Deletes a city in the country and gives back whether it was successful
     */
    public boolean deleteCity(String cityName) {
        City chosenCity = getCityByName(cityName);
        boolean inCities = cities.contains(chosenCity);

        cities.remove(chosenCity);
        return inCities;
    }

    /*
    toString() -> String
    Gives back the string representation of the country in the format:
    NAME: total population: POP, population outside listed cities: POP_NOT_IN_CITIES, with cities
    NAME: has population POP and is in time zone TIME_ZONE. It IS/IS NOT a megacity
     */
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(String.format(UNFORMATTED_TO_STRING,
                name, population, getPopulationOutsideCities()));

        // Add each city to the final string
        for (City city : cities) {
            result.append(city).append("\n");
        }

        return result.toString();
    }
}
