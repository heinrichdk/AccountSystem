package za.ac.nwu.as.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.ac.nwu.as.domain.persistance.User;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User,String> {
}
