package com.example.myHondaClient;

import com.example.myHondaClient.MyHondaClientClient;

import java.util.List;

import javax.validation.Valid;

import com.example.hondawebservice.AddUserRequest;
import com.example.hondawebservice.AddUserResponse;
import com.example.hondawebservice.GetAllUserRequest;
import com.example.hondawebservice.GetAllUserResponse;
import com.example.hondawebservice.GetUserRequest;
import com.example.hondawebservice.GetUserResponse;
import com.example.myHondaClient.MyHondaClientRepository;
import com.example.myHondaClient.MyHondaClientConfig;
import org.springframework.ws.client.core.WebServiceTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MyHondaClientController {
    @Autowired
    MyHondaClientClient client;
    
    @Autowired
    MyHondaClientRepository repo;

    MyHondaClientClient hondaClient;

 


    //get data from the server providing refNo
    @PostMapping("/refNo")
    public GetUserResponse data(@RequestBody GetUserRequest request){

        GetUserResponse response = (GetUserResponse) client.callWebService("http://localhost:8080/ws", request);
        System.out.print(response.getMsg().getMsg());
        OwnerEntity entity = new OwnerEntity(request.getRefNo(),response.getMsg().getMsg(),response.getMsg().getMsgCode());
        addData2(entity);
        return client.getUserRefNo(request);
    }

    //test
    @PostMapping("/refNo2")
    public GetUserResponse data2(@RequestBody String refNo){
        return client.getUserByRefNo(refNo);
    }

    //get data of all users from the server
    @PostMapping("/AllUsers")
    public GetAllUserResponse allData() {
        return client.getAllUserResponse();
    }

    //add data by accessing to server's adduser function
    @PostMapping("/addUsers")
    public AddUserResponse addData(@RequestBody AddUserRequest request) {
        return client.addUsers(request);
    }

    //add data to our own database
     @PostMapping("/addUser")
     public OwnerEntity addData2(@RequestBody OwnerEntity entity) {
         return repo.save(entity);
     }
    
     //FindByRefNo in our database
     @GetMapping("refNo/{refNo}")
     public OwnerEntity findNo(@PathVariable String refNo) {
         return repo.findByRefNo(refNo);
     }

     //find all users in our database
     @PostMapping("/allUsers")
     public List<OwnerEntity> findAllUsers() {
         return repo.findAll();
     }
}

