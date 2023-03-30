package co.com.bancolombia.repository.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.com.bancolombia.examplesoap.Country;
import co.com.bancolombia.repository.BaseRepository;
import jakarta.annotation.PostConstruct;

@Repository
public class CountryRepository implements BaseRepository{
	
	private Map<String, Country> countries;
	
	public CountryRepository() {
		this.countries = new HashMap<String, Country>();
		System.out.println("constructor !");
	}
	
	@PostConstruct
	public void init() {
//		this.countries.put("COL", new Country(){
//			name = "Colombia"
//		});
		System.out.println("init !");
	}
	
	public Country getCountryByName(String name) {
		return countries.get(name);
	}
	
}
