package za.ac.nwu.as.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.service.GeneralResponse;

@RestController
public class PointsController {

    @GetMapping("/ping")
    @ApiOperation(value = "Echo the Ping.", notes = "This echo the ping back to the client")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "The Ping was received and echoed", response = GeneralResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
    @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
public ResponseEntity<GeneralResponse> ping(
            @RequestParam(value = "value that will be echoed", defaultValue =
                    "pong")
                    String echo) {
        GeneralResponse<String> response = new GeneralResponse<>("Test Message", true,echo );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
