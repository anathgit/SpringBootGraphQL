package com.example;

import org.springframework.http.ResponseEntity;
import java.util.Base64;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Map;

@RestController
@RequestMapping("/restapi")
public class HeaderController {

    @PostMapping("/receive-json")
    public ResponseEntity<String> receiveJson(@RequestHeader("X-Large-Json") String encodedJson) {
        // Decode the Base64 JSON header
        byte[] decodedBytes = Base64.getDecoder().decode(encodedJson);
        String jsonData = new String(decodedBytes);

        // Log or process the JSON data
        System.out.println("Decoded JSON: " + jsonData);

        // Respond back
        return ResponseEntity.ok("JSON received successfully.");
    }

}

