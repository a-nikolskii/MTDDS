package a.nikolskii.mtdds.repository;

import a.nikolskii.mtdds.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findUserByEmail(String email);
}
