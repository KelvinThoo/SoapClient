package com.example.myHondaClient;

import java.util.ArrayList;
import java.util.List;

import com.example.hondawebservice.GetAllUserResponse;
import com.example.hondawebservice.GetUserResponse;
import com.example.hondawebservice.MTHMSBRegVerificationRes;
import com.example.myHondaClient.MyHondaClientClient;
import com.example.myHondaClient.MyHondaClientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyHondaClientApplication {

	MyHondaClientClient client;
	
	public static void main(String[] args) {
		SpringApplication.run(MyHondaClientApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyHondaClientConfig.class);
		MyHondaClientClient client = context.getBean(MyHondaClientClient.class);

		// for debug purpose
		// GetUserResponse response2 = client.getUserByRefNo("123");
		// System.out.println("response2: "+ response2.getMsg().getMsg() + "Code: " + response2.getMsg().getMsgCode());

	}

	// @Bean
	// CommandLineRunner lookup(MyHondaClientClient quoteClient) {
	//   return args -> {
	// 	String owner = "123";
  
	// 	if (args.length > 0) {
	// 	  owner = args[0];
	// 	}
	// 	MTHMSBRegVerificationRes response = quoteClient.getOwner(owner);
	// 	System.err.println("Reference No:"+response.getOwner().getRefNo()+"\nMessage:"+response.getOwner().getMsg()+"\nMessage Code:"+response.getOwner().getMsgCode()+"\nSubmission Status:"+response.getOwner().getSubmissionStatus());
	//   };
	// }

}
