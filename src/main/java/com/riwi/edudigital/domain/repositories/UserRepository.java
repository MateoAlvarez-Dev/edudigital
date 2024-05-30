package com.riwi.edudigital.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.edudigital.domain.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
