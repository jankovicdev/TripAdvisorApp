package demo.tripadvisorapp.registrationAndLogin.api;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/user")
public class UserController {


    @GetMapping("/tripAdvisorHomePage")
    public String index() {
        return "tripAdvisorHomePage";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "userProfile";
    }

}