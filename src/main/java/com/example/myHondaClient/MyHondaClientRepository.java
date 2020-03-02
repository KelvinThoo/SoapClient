package com.example.myHondaClient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myHondaClient.OwnerEntity;

import java.util.Map;
import java.util.HashMap;

import com.example.hondawebservice.Owner;

@Repository
public interface MyHondaClientRepository extends JpaRepository<OwnerEntity,String> {
    public static final Map<String,Owner> owners = new HashMap<>();

    public OwnerEntity findByRefNo(String refNo);
}
