package com.impostercorp.soap.client;

import com.impostercorp.soap.wsdl.OneToOne;
import com.impostercorp.soap.wsdl.OneToOneResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

/**
 *
 * Created by sayeedm on 8/3/17.
 */
@SuppressWarnings("SpellCheckingInspection")
public class SoapClient extends WebServiceGatewaySupport {

    @Value("${smsgateway.user}")
    private String user;

    @Value("${smsgateway.password}")
    private String password;

    @Value("${smsgateway.uri}")
    private String uri;

    @Value("${smsgateway.targetNs}")
    private String targetNs;


    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public OneToOneResponse sendSmsToOne(String phoneNo, String smsBody){
        OneToOne request = new OneToOne();
        request.setCampaignName("");
        request.setMaskName("");
        request.setMobileNumber(phoneNo);
        request.setSmsText(smsBody);
        request.setType("TEXT");
        request.setUserName(user);
        request.setUserPassword(password);

        return (OneToOneResponse) webServiceTemplate
                .marshalSendAndReceive(request, new SoapActionCallback(targetNs + "/OneToOne"));


    }
}
