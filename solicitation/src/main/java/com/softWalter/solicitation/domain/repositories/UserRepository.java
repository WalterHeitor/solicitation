package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email =?1 AND u.password =?2")
    public Optional<User> login(String email, String password);

    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE User u SET u.role = ?2 WHERE u.id = ?1")
    public int updateRole(Long id, Role role);
}
