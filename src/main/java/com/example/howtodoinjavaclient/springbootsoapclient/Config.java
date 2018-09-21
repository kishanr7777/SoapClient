package com.example.howtodoinjavaclient.springbootsoapclient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class Config  {
	
	@Bean
	public Jaxb2Marshaller marshaller(){
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.example.howtodoinjava.schemas.school");
		return jaxb2Marshaller;
	}
	
	@Bean
    public SoapConnector soapConnector(Jaxb2Marshaller marshaller) {
        SoapConnector client = new SoapConnector();
        client.setDefaultUri("http://localhost:8080/service/student-details");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
