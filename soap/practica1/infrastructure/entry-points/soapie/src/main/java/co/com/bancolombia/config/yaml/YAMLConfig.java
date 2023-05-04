package co.com.bancolombia.config.yaml;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "soap")
public class YAMLConfig {

    private Wsdl wsdl;

    public Wsdl getWsdl() {
        return wsdl;
    }

    public void setWsdl(Wsdl wsdl) {
        this.wsdl = wsdl;
    }
}
