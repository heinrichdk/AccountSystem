package za.ac.nwu.as.web.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.ac.nwu.as.logic.flow.UpdateUserAccountFlow;
import za.ac.nwu.as.logic.flow.impl.FetchAccountFlowImpl;
import za.ac.nwu.as.logic.flow.impl.FetchUserFlowImpl;
import za.ac.nwu.as.logic.flow.impl.UpdateUserAccountFlowImpl;


@Configuration
public class BeansConfig {

    @Bean
    public FetchUserFlowImpl fetchUserFlow(){
        return new FetchUserFlowImpl();}
    @Bean
    public FetchAccountFlowImpl fetchAccountFlow(){
        return  new FetchAccountFlowImpl();
    }
    @Bean
    public UpdateUserAccountFlowImpl updateUserAccountFlow(){
        return  new UpdateUserAccountFlowImpl();
    }
}
