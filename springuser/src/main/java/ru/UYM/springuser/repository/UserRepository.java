package ru.UYM.springuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.UYM.springuser.Model.users;

public interface UserRepository extends JpaRepository<users, Long> {
    users findUserByEmail(String email);
    void deleteByEmail(String email);
}