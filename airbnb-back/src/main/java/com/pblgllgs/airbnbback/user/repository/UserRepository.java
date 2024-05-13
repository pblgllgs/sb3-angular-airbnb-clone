package com.pblgllgs.airbnbback.user.repository;

import com.pblgllgs.airbnbback.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByPublicId(UUID publicId);
}
