package com.ecdevco.sea.servermanagement.repository;

import com.ecdevco.sea.servermanagement.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT user FROM User user WHERE user.username = :username")
    Optional<User> findByUsername(@Param("username") String username);
}
