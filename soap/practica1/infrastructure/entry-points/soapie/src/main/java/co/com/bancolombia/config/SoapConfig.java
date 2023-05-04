package co.com.bancolombia.config;

import co.com.bancolombia.config.yaml.YAMLConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.WsdlDefinition;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.SimpleWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl4jDefinition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

@EnableWs // can add interceptors
@Configuration
public class SoapConfig extends WsConfigurerAdapter {

    @Autowired
    private YAMLConfig yamlConfig;

    @Bean
    ServletRegistrationBean<MessageDispatcherServlet> registrarDispatcher(ApplicationContext contexto) {
        MessageDispatcherServlet dispatcher = new MessageDispatcherServlet();
        dispatcher.setApplicationContext(contexto);
        dispatcher.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(dispatcher, "/ws/*");
    }
    
    @Bean(name = "BB11")
    Wsdl11Definition wsdl() {
    	SimpleWsdl11Definition definicion = new SimpleWsdl11Definition();
    	definicion.setWsdl(new ClassPathResource("schemas/AlmacenarSolicitudDeCredito_BB11_V1.wsdl"));
    	definicion.setWsdl(new ClassPathResource("schemas/AlmacenarSolicitudDeCredito_BB11_Intf_V1.wsdl"));
    	return definicion;
    }
    
//  @Bean
//  SimpleWsdl11Definition esquema() { 
//      return new SimpleWsdl11Definition(new ClassPathResource("AlmacenarSolicitudDeCredito_BB11_V1.wsdl"));
//  }

//    @Bean(name = "paises")
//    DefaultWsdl11Definition definirWSDL(XsdSchema esquema) {
//        DefaultWsdl11Definition definicion = new DefaultWsdl11Definition();
//        definicion.setPortTypeName(yamlConfig.getWsdl().getPortTypeName());
//        definicion.setLocationUri(yamlConfig.getWsdl().getLocationUri());
//        definicion.setTargetNamespace(yamlConfig.getWsdl().getTargetNamespace());
//        definicion.setServiceName("serviceName");
//        definicion.setSchema(esquema);
//
//        return definicion;
//    }

//    @Bean
//    XsdSchema esquema() { 
//        return new SimpleXsdSchema(new ClassPathResource("schemas/paisitos.xsd"));
//    }
}