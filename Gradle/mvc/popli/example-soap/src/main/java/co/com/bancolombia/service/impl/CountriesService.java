package co.com.bancolombia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.bancolombia.examplesoap.Country;
import co.com.bancolombia.repository.impl.CountryRepository;
import co.com.bancolombia.service.BaseService;

@Service
public class CountriesService implements BaseService{

	@Autowired
	private CountryRepository countryRepository;
	
	public Country getCountryByName(String name) {
		return countryRepository.getCountryByName(name);
	}
	
}
