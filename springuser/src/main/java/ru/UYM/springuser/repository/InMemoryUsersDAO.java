package ru.UYM.springuser.repository;


import org.springframework.stereotype.Repository;
import ru.UYM.springuser.Model.users;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryUsersDAO {
    private final List<users> USERS = new ArrayList<>();

    public List<users> findAllUser() {
        return USERS;
    }

    public users saveUser(users user) {
        USERS.add(user);
        return user;
    }

    public users findByEmail(String email) {
        return USERS.stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public users updateUser(users user) {
        int userIndex = IntStream.range(0, USERS.size())
                .filter(index -> USERS.get(index).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElse(-1);
        if (userIndex > -1) {
            USERS.set(userIndex, user);
            return user;
        }
        return null;
    }

    public void deleteUser(String email) {
        int userIndex = IntStream.range(0, USERS.size())
                .filter(index -> USERS.get(index).getEmail().equals(email))
                .findFirst()
                .orElse(-1);
        if (userIndex > -1) {
            USERS.remove(userIndex);
        }
    }
}