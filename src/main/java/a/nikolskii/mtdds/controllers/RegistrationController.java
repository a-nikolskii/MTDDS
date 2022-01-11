package a.nikolskii.mtdds.controllers;
import a.nikolskii.mtdds.entity.User;
import a.nikolskii.mtdds.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping("/registration")
    public String registerUser(@Valid User newUser, BindingResult result, Model model){
        log.info("POST -> /registration");
        log.info(newUser.toString());
        var isSaved = userService.saveUser(newUser);

        if (!isSaved) {
            var error = new ObjectError("globalError", "User already exist. Input another name.");
            result.addError(error);
            return "/registration";
        }
        return "index";
    }

    @GetMapping("/registration")
    public String registration(Model model){
       log.info("GET -> /registration");
        model.addAttribute("user", new User());
        return "registration";
    }
}
