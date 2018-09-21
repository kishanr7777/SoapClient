package com.example.howtodoinjavaclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.howtodoinjava.schemas.school.StudentDetailsRequest;
import com.example.howtodoinjava.schemas.school.StudentDetailsResponse;
import com.example.howtodoinjavaclient.springbootsoapclient.SoapConnector;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class howtodoinjavaclient 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(howtodoinjavaclient.class, args);
    }
    
    @Bean
    CommandLineRunner lookup(SoapConnector soapConnector) {
        return args -> {
            String name = "Kajal";//Default Name
            if(args.length>0){
                name = args[0];
            }
            StudentDetailsRequest request = new StudentDetailsRequest();
            request.setName(name);
            StudentDetailsResponse response =(StudentDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/student-details", request);
            System.out.println("Got Response As below ========= : ");
            System.out.println("Name : "+response.getStudent().getName());
            System.out.println("Standard : "+response.getStudent().getStandard());
            System.out.println("Address : "+response.getStudent().getAddress());
        };
    }
}
