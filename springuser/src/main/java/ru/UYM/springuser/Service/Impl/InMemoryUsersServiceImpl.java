package ru.UYM.springuser.Service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import ru.UYM.springuser.Model.users;
import ru.UYM.springuser.Service.UsersService;
import ru.UYM.springuser.repository.InMemoryUsersDAO;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryUsersServiceImpl implements UsersService {
    private final InMemoryUsersDAO repository;

    @Override
    public List<users> findAllUser() {
        return repository.findAllUser();
    }

    @Override
    public users saveUser(users user) {
        return repository.saveUser(user);
    }

    @Override
    public void deleteByEmail(String email) {

    }

    @Override
    public users findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public users updateUser( users user) {
        return repository.updateUser(user);
    }

    @Override
    public void deleteUser(String email) {
        repository.deleteUser(email);
    }
}
