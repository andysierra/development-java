package co.com.bancolombia.soapie.endpoint.impl;

import co.com.bancolombia.generated.*;
import co.com.bancolombia.soapie.endpoint.BaseEndpoint;
import co.com.bancolombia.soapie.service.impl.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.*;

@Endpoint
public class CountryEndpoint implements BaseEndpoint {

    public static final String ENDPOINT = "http://www.bancolombia.com.co/generated";
    private CountryService countryService;

    @Autowired
    public CountryEndpoint(CountryService countryService) {
        this.countryService = countryService;
    }

    @PayloadRoot(namespace = ENDPOINT, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountryByName(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryService.getCountryByName(request.getName()));
        return response;
    }
}