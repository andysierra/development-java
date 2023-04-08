package co.com.bancolombia;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

	private String popli;

	public String getPopli() {
		return popli;
	}

	public void setPopli(String popli) {
		this.popli = popli;
	}
	
	
	
}
