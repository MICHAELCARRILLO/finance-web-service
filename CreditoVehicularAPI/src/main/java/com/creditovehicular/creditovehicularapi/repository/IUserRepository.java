package com.creditovehicular.creditovehicularapi.repository;

import com.creditovehicular.creditovehicularapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    public User findUserByEmailAndPassword(String email, String password);
    public User findUserByEmail(String email);
}
