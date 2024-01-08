package br.com.fec.FecApp.Config.TwilioWppConfig;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;
import java.util.Arrays;

@Configuration
public class TwilioWppConfig {

    @Value("${twilio.wppKeys.ACCOUNT_SID}")
    private String ACCOUNT_SID;
    @Value("${twilio.wppKeys.AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${twilio.wppNumber}")
    private String wppNumber;

    public void creteWppMessage(String phoneNumber, String infoMessage){
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                        //Número que envia
                        new com.twilio.type.PhoneNumber(wppNumber),
                        //Número que recebe
                        new com.twilio.type.PhoneNumber(phoneNumber + "whatsapp:+14155238886"),
                        infoMessage)
                .setMediaUrl(
                        Arrays.asList(URI.create("https://demo.twilio.com/owl.png")))
                .create();

        System.out.println(message.getSid());
    }
}
