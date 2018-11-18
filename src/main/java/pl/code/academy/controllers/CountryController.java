package pl.code.academy.controllers;

import pl.code.academy.model.Country;
import pl.code.academy.model.GetCountriesRequest;
import pl.code.academy.model.GetCountriesResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class CountryController {

    HashMap<String, Country> countries;

    public CountryController() {
        this.countries = new HashMap<>();

        Country france = new Country();
        france.setName("France");
        france.setCapital("Paris");
        france.setPopulation(66900000);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setPopulation(37950000);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setPopulation(65640000);

        countries.put(france.getName(), france);
        countries.put(poland.getName(), poland);
        countries.put(uk.getName(), uk);
    }


    @RequestMapping(value = "/getCountryByName", method = RequestMethod.POST)
    public GetCountriesResponse getCountryByName(@RequestBody GetCountriesRequest getCountriesRequest) {
        Country countryToSend = countries.get(getCountriesRequest.getName());

        GetCountriesResponse respone = new GetCountriesResponse();
        respone.setCountry(countryToSend);

        return respone;
    }
}
