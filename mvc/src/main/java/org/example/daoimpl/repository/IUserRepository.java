package org.example.daoimpl.repository;

import org.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByUsername(String username);

    User findByEmailAndPassword(String email, String password) throws Exception;

    User findByUsernameAndPassword(String username, String password) throws Exception;
}
