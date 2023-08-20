package dev.mohsenmajd;

import org.junit.Test;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.*;

public class SearchCityTest {

    @Test
    public void shouldBeInstantiable(){
        new SearchCity();
    }

    @Test
    public void shouldReturnEmptyArrayListWhenSearchTermIsLessThanTwoCharacters(){
        var searchCity = new SearchCity();
        ArrayList<String> cityNames = searchCity.search("a");

        assertThat(cityNames).isInstanceOf(ArrayList.class);
        assertThat(cityNames).hasSize(0);
    }

    @Test
    public void shouldReturnAllCityNamesStartingWithTheTermWhenTheTermIsGreaterOrEqualToTwoCharacters(){
        var searchCity = new SearchCity();
        ArrayList<String> cityNames = searchCity.search("Va");

        assertThat(cityNames).contains("Valencia", "Vancouver");
    }

    @Test
    public void shouldHandleSearchOperationsInACaseInsensitiveWay(){
        var searchCity = new SearchCity();

        ArrayList<String> cityNames = searchCity.search("va");
        assertThat(cityNames).contains("Valencia", "Vancouver");
    }

    @Test
    public void shouldReturnCityNamesThatTheSearchTermIsPartOf(){
        var searchCity = new SearchCity();

        ArrayList<String> cityNames = searchCity.search("ape");

        assertThat(cityNames).contains("Budapest");
    }

    @Test
    public void shouldReturnAllTheCityNamesWhenGivenAsteriskCharacter(){
        var searchCity = new SearchCity();

        ArrayList<String> cityNames = searchCity.search("*");

        assertThat(cityNames).contains(
                "Paris",
                "Budapest",
                "Skopje",
                "Rotterdam",
                "Valencia",
                "Vancouver",
                "Amsterdam",
                "Vienna",
                "Sydney",
                "New York City",
                "London",
                "Bangkok",
                "Hong Kong",
                "Dubai",
                "Rome",
                "Istanbul"
                );
    }
}
