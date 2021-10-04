package za.ac.nwu.as.web.sb.controller;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;;
import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.dto.UserDto;
import za.ac.nwu.as.domain.service.GeneralResponse;
import za.ac.nwu.as.logic.flow.UpdateUserAccountFlow;
import za.ac.nwu.as.logic.flow.impl.FetchAccountFlowImpl;
import za.ac.nwu.as.logic.flow.impl.FetchUserFlowImpl;
import za.ac.nwu.as.logic.flow.impl.UpdateUserAccountFlowImpl;

import java.util.List;

@RestController
public class AccountController {

    private FetchAccountFlowImpl fetchAccountFlowImpl;
    private UpdateUserAccountFlowImpl updateUserAccountFlowImpl;

    @Autowired
    public void FetchAccountFlowImpl(FetchAccountFlowImpl fetchAccountFlowImpl) {
        this.fetchAccountFlowImpl = fetchAccountFlowImpl;
    }

    public UpdateUserAccountFlowImpl getFetchUserFlowImpl() {
        return updateUserAccountFlowImpl;
    }

    @Autowired
    public void UpdateUserAccountFlowImpl(UpdateUserAccountFlowImpl updateUserAccountFlowImpl) {
        this.updateUserAccountFlowImpl = updateUserAccountFlowImpl;
    }


    public UpdateUserAccountFlowImpl getUpdateUserAccountFlowImpl() {
        return updateUserAccountFlowImpl;
    }



    @Autowired
    public AccountController(FetchAccountFlowImpl fetchAccountFlowImpl, UpdateUserAccountFlowImpl updateUserAccountFlowImpl)
    {
        this.fetchAccountFlowImpl = fetchAccountFlowImpl;
        this.updateUserAccountFlowImpl = updateUserAccountFlowImpl;
    }

    public AccountController() {
    }

    @GetMapping("/AccountsByUser")
    @ApiOperation(value = "Get User Accounts", notes = "This gets all the accounts for a user")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Accounts where found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity<GeneralResponse> GetUserAccounts ( @RequestParam(value = "userId", defaultValue =
            "null")
    String userId) {

        List<AccountDto> accounts = fetchAccountFlowImpl.GetUserAccounts(userId);
        GeneralResponse<List<AccountDto>> response = new GeneralResponse<>("", true,accounts );

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/AddPoints")
    @ApiOperation(value = "Add points to Accounts", notes = "This adds points to a specified account")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Points were added", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity AddPointsToAccount ( @RequestParam(value = "AccountId", defaultValue = "null") String accountId, @RequestParam(value = "Amount", defaultValue = "0") double value) {

        boolean success = updateUserAccountFlowImpl.AddPoints(accountId, value);

        return new ResponseEntity<>(success, HttpStatus.OK);
    }

    @PostMapping("/SpendAccountPoints")
    @ApiOperation(value = "Spends an account's points", notes = "This will spend points from specified account")
    @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Accounts where found", response = GeneralResponse.class),
    @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
    @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
    @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)})
    public ResponseEntity SpendPointsFromAccount ( @RequestParam(value = "AccountId", defaultValue = "null") String accountId, @RequestParam(value = "Amount", defaultValue = "0") double value) {

        boolean success = updateUserAccountFlowImpl.SpendPoints(accountId, value);

        return new ResponseEntity<>(success, HttpStatus.OK);
    }
}
