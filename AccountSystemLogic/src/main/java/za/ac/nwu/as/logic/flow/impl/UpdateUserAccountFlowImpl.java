package za.ac.nwu.as.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.as.logic.flow.UpdateUserAccountFlow;
import za.ac.nwu.as.translator.Translator;

import javax.transaction.Transactional;

@Transactional
@Component
public class UpdateUserAccountFlowImpl implements UpdateUserAccountFlow {
    private Translator translator;
    @Override
    public boolean AddPoints(String accountId, double value )
    {
        try {
            double currentPoints = translator.GetPoints(accountId);
            var newValue = currentPoints+value;
            translator.AddPoints(accountId, newValue);
            return  true;
        }
        catch(Exception ex) {

        }
        return false;
    }
    @Override
    public boolean SpendPoints(String accountId, double value )
    {
        try {
            double currentPoints = translator.GetPoints(accountId);
            if(value>currentPoints) {
                return false;
            }
            else {
                var newValue = currentPoints-value;
                translator.SpendPoints(accountId, newValue);
                return true;
            }
        }
        catch(Exception ex) {

        }
        return false;
    }
}
