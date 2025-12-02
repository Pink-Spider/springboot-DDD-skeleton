package io.pinkspider.dddskeleton.api.user;

import io.pinkspider.dddskeleton.application.user.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void create(@RequestParam Long id, @RequestParam String name) {
        userService.handle(id, name);
    }
}
