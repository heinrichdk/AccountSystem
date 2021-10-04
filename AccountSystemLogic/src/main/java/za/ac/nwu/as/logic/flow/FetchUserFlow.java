package za.ac.nwu.as.logic.flow;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.UserDto;

import java.util.List;
@Component
public interface FetchUserFlow {

    List<UserDto> getAllUsers();
}
