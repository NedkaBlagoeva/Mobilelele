package bg.softuni.mobilelele.web;

import bg.softuni.mobilelele.model.dto.UserLoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/users/register")
    public String register() {
        return "auth-register";
    }

    @GetMapping("/users/login")
    public String login() {
        return "auth-login";
    }

    @PostMapping("/users/login")
    public String login(UserLoginDto userLoginDto, Model model){
        System.out.println();
        return "redirect: /";
    }
}
