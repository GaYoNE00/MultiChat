package kr.protest.multichat.UserRepository;

import kr.protest.multichat.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByLid(String lid);
}
