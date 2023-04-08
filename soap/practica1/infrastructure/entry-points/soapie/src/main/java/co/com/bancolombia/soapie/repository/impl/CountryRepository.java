package co.com.bancolombia.soapie.repository.impl;

import co.com.bancolombia.generated.*;
import co.com.bancolombia.soapie.repository.BaseRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CountryRepository implements BaseRepository {

    private Map<String, Country> countries;

    public CountryRepository() {
        countries = new HashMap<>();
    }

    @PostConstruct
    public void init() {

        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.put("Spain", spain);
        countries.put("Poland", poland);
        countries.put("UK", uk);
    }

    public Country getCountryByName(@NonNull String name) {
        return countries.get(name);
    }
}