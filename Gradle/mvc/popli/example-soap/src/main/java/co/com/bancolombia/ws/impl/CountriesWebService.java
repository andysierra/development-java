package co.com.bancolombia.ws.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import co.com.bancolombia.YAMLConfig;
import co.com.bancolombia.examplesoap.GetCountryRequest;
import co.com.bancolombia.examplesoap.GetCountryResponse;
import co.com.bancolombia.repository.impl.CountryRepository;
import co.com.bancolombia.service.impl.CountriesService;
import co.com.bancolombia.ws.BaseWS;

@Endpoint
public class CountriesWebService implements BaseWS{
	
	private static final String NAMESPACE_URI = "http://www.bancolombia.com.co/examplesoap";

    private CountryRepository countryRepository;

    @Autowired
    public CountriesWebService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.getCountryByName(request.getName()));

        return response;
    }
	
}
 