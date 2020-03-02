package com.example.myHondaClient;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.myHondaClient.MyHondaClientService;

@Service
@Transactional
public class MyHondaClientServiceImplementation implements MyHondaClientService {

    private MyHondaClientRepository repository;

    public MyHondaClientServiceImplementation() {

    }

    @Autowired
    public MyHondaClientServiceImplementation(MyHondaClientRepository repository) {
        this.repository = repository;
    }
    
    @Override
    public OwnerEntity addEntity(OwnerEntity entity) {
        try {
            System.out.print("try");
            return repository.save(entity); 
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("Hi");
            return null;
        }
    }

}