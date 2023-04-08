package co.com.bancolombia.repository.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import co.com.bancolombia.examplesoap.Country;
import co.com.bancolombia.examplesoap.Currency;
import co.com.bancolombia.repository.BaseRepository;
import jakarta.annotation.PostConstruct;

@Repository
public class CountryRepository implements BaseRepository{
	
	private Map<String, Country> dummyDataMap = new HashMap<String, Country>();
	
	@PostConstruct
	public void init() {
		
		dummyDataMap.put("Spain", new Country() {{
			setName("Spain");
			setCapital("Madrid");
			setCurrency(Currency.EUR);
			setPopulation(10);
		}});
		dummyDataMap.put("Colombia", new Country() {{
			setName("Colombia");
			setCapital("Bogota");
			setCurrency(Currency.PLN);
			setPopulation(10);
		}});
		dummyDataMap.put("USA", new Country() {{
			setName("USA");
			setCapital("Washington");
			setCurrency(Currency.GBP);
			setPopulation(10);
		}});
	}
	
	public Country getCountryByName(String name) {
		return dummyDataMap.entrySet().stream()
				.filter(entry->entry.getValue().getName().equals(name))
				.findFirst().get().getValue();
	}
}
