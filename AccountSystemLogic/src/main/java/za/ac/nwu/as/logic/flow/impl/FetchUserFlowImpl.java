package za.ac.nwu.as.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.UserDto;
import za.ac.nwu.as.logic.flow.FetchUserFlow;
import za.ac.nwu.as.translator.Translator;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchUserFlowImpl  implements FetchUserFlow {
    private Translator translator;

    @Override
    public List<UserDto> getAllUsers() {
        try {
            return translator.getAllUsers();
        }
        catch(Exception ex) {

        }
        return new ArrayList<UserDto>();
    }

    public FetchUserFlowImpl() {
    }

}
