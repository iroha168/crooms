package crooms.domain.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import crooms.domain.model.User;

public interface UserRepository extends JpaRepository<User, String> {
}