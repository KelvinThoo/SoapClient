package com.example.myHondaClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.hondawebservice.AddUserRequest;
import com.example.hondawebservice.AddUserResponse;
import com.example.hondawebservice.GetAllUserRequest;
import com.example.hondawebservice.GetAllUserResponse;
import com.example.hondawebservice.GetUserRequest;
import com.example.hondawebservice.GetUserResponse;
import com.example.hondawebservice.MTHMSBRegVerificationRes;
import com.example.hondawebservice.MTHSMBRegVerificationReq;

public class MyHondaClientClient extends WebServiceGatewaySupport {

    MyHondaClientService service;

    private static final Logger log = LoggerFactory.getLogger(MyHondaClientClient.class);

    @Autowired
    Jaxb2Marshaller jaxb2Marshaller;

    // public MTHMSBRegVerificationRes getOwner(String owner) {
  
    //   MTHSMBRegVerificationReq request = new MTHSMBRegVerificationReq();
    //   request.setRefNo(owner);
  
    //   log.info("Requesting for " + owner + " details");
  
    //   MTHMSBRegVerificationRes response = (MTHMSBRegVerificationRes) getWebServiceTemplate()
    //       .marshalSendAndReceive("http://localhost:8080/ws/owners", request,
    //           new SoapActionCallback(
    //               "http://example.com/users/MTHSMBRegVerificationReq"));
  
    //   return response;
    // }

    public GetAllUserResponse getAllUserResponse() {
        GetAllUserRequest request = new GetAllUserRequest();

        log.info("Requesting all user's data.....");
        return (GetAllUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);

    }

    public GetUserResponse getUserByRefNo(String refNo) {
        GetUserRequest request = new GetUserRequest();
        request.setRefNo(refNo);

		log.info("Requesting Reference No " + refNo + "'s data");
		return (GetUserResponse) getWebServiceTemplate().marshalSendAndReceive(request);

    }
    
    public GetUserResponse getUserRefNo(GetUserRequest request) {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return (GetUserResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws",request);
    }


    public AddUserResponse addUsers(AddUserRequest request) {

        
        System.out.print(request.getMsg()+request.getMsgCode());

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(jaxb2Marshaller);
        return (AddUserResponse) webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws",request);

    }

    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }


}