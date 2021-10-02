package za.ac.nwu.as.web.sb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PointsController {

    @GetMapping("/ping")
    public ResponseEntity<String> ping(
            @RequestParam(value = "value that will be echoed", defaultValue =
                    "pong")
                    String echo) {
        return new ResponseEntity<>(echo, HttpStatus.OK);
    }
}
