package tn.esprit.espritgather.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

@Service
public class SmsService implements ISmsService{

    // Find your Account Sid and Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC5b943648d515e00524f580802b1168b4";
    public static final String AUTH_TOKEN = "b0cd8eaf01b222fdd85abcb8d6413448";

    public void sendSms(String to, String from, String message) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message.creator(new PhoneNumber(to), // to
                        new PhoneNumber(from), // from
                        message)
                .create();
    }
}