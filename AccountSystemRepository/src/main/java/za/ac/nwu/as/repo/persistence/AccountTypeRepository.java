package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistance.AccountType;


public interface AccountTypeRepository extends JpaRepository<AccountType,String> {
}
