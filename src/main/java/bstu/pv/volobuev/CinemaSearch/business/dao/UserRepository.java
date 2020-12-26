package bstu.pv.volobuev.CinemaSearch.business.dao;

import bstu.pv.volobuev.CinemaSearch.business.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserAccount, Long> {
    Optional<UserAccount> getUserAccountByUsername(String username);

    Optional<UserAccount> getUserAccountById(Long id);

    Boolean existsByUsername(String username);
}
