package za.ac.nwu.as.web.sb.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import za.ac.nwu.as.domain.dto.UserDto;
import za.ac.nwu.as.domain.persistance.User;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.FetchUserFlow;
import za.ac.nwu.as.logic.flow.impl.FetchUserFlowImpl;

import java.util.List;

@RestController
public class UserController {

    private FetchUserFlowImpl fetchUserFlowImpl;

    @Autowired
    public void setFetchUserFlowImpl(FetchUserFlowImpl fetchUserFlowImpl) {
        this.fetchUserFlowImpl = fetchUserFlowImpl;
    }


    public FetchUserFlowImpl getFetchUserFlowImpl() {
        return fetchUserFlowImpl;
    }
    @Autowired
    public UserController(FetchUserFlowImpl fetchUserFlowImpl)
    {
        this.fetchUserFlowImpl = fetchUserFlowImpl;
    }

    public UserController() {
    }

    @GetMapping("/All")
    @ApiOperation(value = "Get Users", notes = "This gets all of the users but hides their names")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Users where found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse> GetAll() {

        List<UserDto> users = fetchUserFlowImpl.getAllUsers();
        GeneralResponse<List<UserDto>> response = new GeneralResponse<>("", true,users );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
