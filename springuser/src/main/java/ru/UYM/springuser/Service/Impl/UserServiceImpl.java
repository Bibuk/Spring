package ru.UYM.springuser.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.UYM.springuser.Model.users;
import ru.UYM.springuser.Service.UsersService;
import ru.UYM.springuser.repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class UserServiceImpl implements UsersService {
    private final UserRepository repository;

    public List<users> findAllUsers() {
        return repository.findAll();
    }

    public users saveUser(users user) {
        return repository.save(user);
    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public List<users> findAllUser() {
        return repository.findAll();
    }

    public users findByEmail(String email) {
        return repository.findUserByEmail(email);
    }

    @Override
    public users updateUser(users user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(String email) {
        repository.deleteByEmail(email);
    }
}
