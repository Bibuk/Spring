package ru.UYM.springuser.Controller;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import ru.UYM.springuser.Model.users;
import ru.UYM.springuser.Service.UsersService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    @Qualifier("inMemoryUsersServiceImpl")
    private UsersService service;

    @GetMapping
    public List<users>findAllUser() {
        //todo
        return service.findAllUser();
    }

    @PostMapping("save_user")
    public String saveUser(@RequestBody users user) {
        service.saveUser((users) user);
        return "Пользователь успешно сохранён";
    }

    @GetMapping("/{email}")
    public users findByEmail(@PathVariable String email) {
        return service.findByEmail(email);
    }

    @PutMapping("update_user")
    public users updateUser(@RequestBody users user) {
        return service.updateUser(user);
    }

    @DeleteMapping("delete_user/{email}")
    public void deleteUser(@PathVariable String email){
        service.deleteUser(email);
    }

}
