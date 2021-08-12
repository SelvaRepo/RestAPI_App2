package com.booking.PO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;

@Controller
@RequestMapping("/MLSC")
@SuppressWarnings("unhecked,unused")
public class BookingController implements CommandLineRunner {
    @Autowired
    BookingService bookingService;

    @GetMapping("/token")
    public @ResponseBody ResponseEntity<String> getToken() {
        System.out.println("BEGIN : GET TOKEN FROM FMS");
        String username = "vgurunathan"; // Get From HttpSession
        System.out.println("USERNAME = "+username);
        String response = bookingService.getToken(username);
        System.out.println("TOKEN = "+response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/booking")
    public @ResponseBody ResponseEntity<String> storeBooking() {
        ArrayList<String> al = new ArrayList<>();
        al.add("BATMAN");
        al.add("SUPERMAN");
        al.add("FLASH");
        al.add("AQUAMAN");
        al.add("WONDER WOMAN");
        al.add("CYBORG");
        al.add("MATRIAN MANHUNTER");
        bookingService.storeBooking(al);
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @Override
    public void run(String... args) {
        ArrayList<String> al = new ArrayList<>();
        al.add("BATMAN");
        al.add("SUPERMAN");
        al.add("FLASH");
        al.add("AQUAMAN");
        al.add("WONDER WOMAN");
        al.add("CYBORG");
        al.add("MATRIAN MANHUNTER");
        bookingService.storeBooking(al);
    }
}