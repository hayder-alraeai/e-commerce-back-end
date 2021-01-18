package com.onlineshop.alraeaei.security.user.repository;

import com.onlineshop.alraeaei.security.user.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<ApplicationUser, String> {
    public ApplicationUser findApplicationUserByEmail(String email);
}
