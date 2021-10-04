package za.ac.nwu.as.web.sb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import za.ac.nwu.as.logic.flow.impl.FetchUserFlowImpl;


@Configuration
public class BeansConfig {

    @Bean
    public FetchUserFlowImpl fetchUserFlow(){
        return new FetchUserFlowImpl();}
}
