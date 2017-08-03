package com.impostercorp.soap.configs;

import com.impostercorp.soap.client.SoapClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 *
 * Created by sayeedm on 8/3/17.
 */
@SuppressWarnings({"unused", "SpellCheckingInspection"})
@Configuration
public class SoapClientConfig {

    @Value("${smsgateway.contextPath}")
    private String contextPath;

    @Value("${smsgateway.uri}")
    private String uri;


    @Bean
    Jaxb2Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath(contextPath);

        return jaxb2Marshaller;
    }

    @Bean
    public WebServiceTemplate webServiceTemplate() {
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
        webServiceTemplate.setMarshaller(jaxb2Marshaller());
        webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
        webServiceTemplate.setDefaultUri(uri);

        return webServiceTemplate;
    }

    @Bean
    public SoapClient soapClient(){
        return new SoapClient();
    }
}
