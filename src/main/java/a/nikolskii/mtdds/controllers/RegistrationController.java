package a.nikolskii.mtdds.controllers;
import a.nikolskii.mtdds.entity.User;
import a.nikolskii.mtdds.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;


/**
 * created by A. Nikolsky
 */

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegistrationController {

    @Autowired
    private final UserService userService;

//    @PostMapping("/registration")
//    public void registerUser(@RequestBody User newUser){
//        var isCreating = userService.saveUser(newUser);
//    }

    @GetMapping("/registration")
    public String registration(Model model){
       log.info("GET -> /registration");
        model.addAttribute("userForm", new User());
        return "registration";
    }
}
