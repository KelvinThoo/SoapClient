package com.example.myHondaClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class MyHondaClientConfig {

  //setup the connection
  @Bean
  public Jaxb2Marshaller marshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    // this package must match the package in the <generatePackage> specified in
    // pom.xml
    marshaller.setContextPath("com.example.hondawebservice");
    return marshaller;
  }

  //connect to the server through url
  @Bean
  public MyHondaClientClient HondaClient(Jaxb2Marshaller marshaller) {
    MyHondaClientClient client = new MyHondaClientClient();
    client.setDefaultUri("http://localhost:8080/ws");
    client.setMarshaller(marshaller);
    client.setUnmarshaller(marshaller);
    return client;
  }

}