package ru.UYM.springuser.Service;

import org.springframework.transaction.annotation.Transactional;
import ru.UYM.springuser.Model.users;
import java.util.List;

public interface UsersService {
    List<users> findAllUser();
    users findByEmail(String email);
    users updateUser(users user);
    void deleteUser(String email);
    users saveUser(users user);

    @Transactional
    void deleteByEmail(String email);
}
