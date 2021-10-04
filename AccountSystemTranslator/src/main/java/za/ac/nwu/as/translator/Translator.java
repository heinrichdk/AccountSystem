package za.ac.nwu.as.translator;

import za.ac.nwu.as.domain.dto.AccountDto;
import za.ac.nwu.as.domain.dto.UserDto;
import za.ac.nwu.as.domain.persistance.Account;
import za.ac.nwu.as.domain.persistance.User;
import za.ac.nwu.as.repo.persistence.AccountRepository;
import za.ac.nwu.as.repo.persistence.UserRepository;


import java.util.*;

public class Translator {

    private UserRepository userRepo;
    private AccountRepository accountRepo;

    public  List<UserDto> getAllUsers()
    {
        List<User> allUsers = userRepo.findAll();
        List<UserDto> dto = new ArrayList<>();
        for (User user:allUsers
        ) {
            var initial = user.getName().charAt(0);
            var combinedName = initial + ". " + user.getSurname();
            var userDto = new UserDto(user.getId(), combinedName );
            dto.add(userDto);
        }
        return dto;
    }

    public  List<AccountDto>getUserAccounts(String UserId)
    {
        List<Account> userAccounts = accountRepo.findByUser_Id(UserId);
        List<AccountDto> dto = new ArrayList<>();
        for (Account acc: userAccounts
        ) {
            var accountTypeName = acc.getAccountType().getAccountType();
            var accountDto = new AccountDto(acc.getId(), accountTypeName, acc.getAccountValue() );
            dto.add(accountDto);
        }
        return dto;
    }

    public void AddPoints(String accountId, double value) {
        Account acc = accountRepo.getOne(accountId);
        acc.setAccountValue(value);
        accountRepo.save(acc);
    }
    public void SpendPoints(String accountId, double value) {
        Account acc = accountRepo.getOne(accountId);
        acc.setAccountValue(value);
        accountRepo.save(acc);
    }

    public double GetPoints(String accountId) {
        Account acc = accountRepo.getOne(accountId);
        return acc.getAccountValue();
    }
}
