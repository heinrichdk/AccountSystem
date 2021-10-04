package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.nwu.as.domain.persistance.Account;

public interface AccountRepository extends JpaRepository<Account,String> {
}
