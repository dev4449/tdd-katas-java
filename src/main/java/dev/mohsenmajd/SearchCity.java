package dev.mohsenmajd;

import java.util.ArrayList;

public class SearchCity {
    private ArrayList<String> cityNames;

    public SearchCity() {
        cityNames = new ArrayList<>();
        cityNames.add("Paris");
        cityNames.add("Budapest");
        cityNames.add("Skopje");
        cityNames.add("Rotterdam");
        cityNames.add("Valencia");
        cityNames.add("Vancouver");
        cityNames.add("Amsterdam");
        cityNames.add("Vienna");
        cityNames.add("Sydney");
        cityNames.add("New York City");
        cityNames.add("London");
        cityNames.add("Bangkok");
        cityNames.add("Hong Kong");
        cityNames.add("Dubai");
        cityNames.add("Rome");
        cityNames.add("Istanbul");
    }

    public ArrayList<String> search(String term){
        if(term.equals("*")) return cityNames;
        if(term.length() < 2) return new ArrayList<String>();

        var results = new ArrayList<String>();

        final String lowerCaseTerm = term.toLowerCase();

        cityNames.forEach( cityName -> {
            if(cityName.toLowerCase().contains(lowerCaseTerm)) results.add(cityName);
        });

        return results;
    }
}
