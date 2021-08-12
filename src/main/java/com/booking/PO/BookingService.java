package com.booking.PO;

import com.Constants;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import java.util.ArrayList;

@Service("bookingService")
public class BookingService implements Constants {
    public String getToken(String username) {
        try {
            String url = tokenUrl;
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpHeaders headers = new HttpHeaders();
            headers.set("username", username);
            HttpEntity<String> entity = new HttpEntity<>(headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> responseString = restTemplate.exchange(builder.buildAndExpand(url).toUriString(), HttpMethod.GET, entity, String.class);
            return responseString.getBody();
        } catch (Exception ex) {
            System.out.println("EXCEPTION OCCURRED :: "+ex.getMessage());
            return "INVALID";
        }
    }

    public void storeBooking(ArrayList<String> al) {
        try {
            String url = fmsUrl + "/saveBooking";
            System.out.println(url);
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.set("token", getToken("vgurunathan")); //GET FROM SESSION
            HttpEntity<ArrayList<String>> entity = new HttpEntity<>(al, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<Void> responseString = restTemplate.postForEntity(builder.buildAndExpand(url).toUriString(), entity, Void.class);
            if (responseString.getStatusCode() == HttpStatus.OK) {
                System.out.println("Request Successful");
            } else {
                System.out.println("Request Failed");
            }
        } catch (Exception ex) {
            System.out.println("EXCEPTION OCCURRED :: "+ex.getMessage());
        }
    }
}
