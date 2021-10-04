package za.ac.nwu.as.translator;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import za.ac.nwu.as.domain.dto.UserDto;
import za.ac.nwu.as.domain.persistance.User;
import za.ac.nwu.as.repo.persistence.UserRepository;


import java.util.*;

public class Translator {

    private UserRepository userRepo;

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

}
