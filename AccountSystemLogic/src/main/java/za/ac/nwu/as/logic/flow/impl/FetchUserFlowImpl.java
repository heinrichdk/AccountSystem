package za.ac.nwu.as.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import za.ac.nwu.as.domain.dto.UserDto;
import za.ac.nwu.as.domain.persistance.User;
import za.ac.nwu.as.logic.flow.FetchUserFlow;
import za.ac.nwu.as.repo.persistence.UserRepository;
import za.ac.nwu.as.translator.Translator;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Component
public class FetchUserFlowImpl  implements FetchUserFlow {
    private Translator translator;

    @Override
    public List<UserDto> getAllUsers() {
        return translator.getAllUsers();
    }

    public FetchUserFlowImpl() {
    }

}
