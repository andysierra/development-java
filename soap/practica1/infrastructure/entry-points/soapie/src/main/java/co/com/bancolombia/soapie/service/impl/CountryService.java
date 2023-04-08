package co.com.bancolombia.soapie.service.impl;

import co.com.bancolombia.generated.Country;
import co.com.bancolombia.soapie.repository.impl.CountryRepository;
import co.com.bancolombia.soapie.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements BaseService {

    @Autowired
    private CountryRepository countryRepository;

    public Country getCountryByName(@NonNull String name) {
        return countryRepository.getCountryByName(name);
    }
}
