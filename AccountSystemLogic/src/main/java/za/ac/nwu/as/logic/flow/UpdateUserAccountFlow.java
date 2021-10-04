package za.ac.nwu.as.logic.flow;

import org.springframework.stereotype.Component;

@Component
public interface UpdateUserAccountFlow {
    boolean AddPoints(String AccountId, double value );
    boolean SpendPoints(String AccountId, double value);
}
