package demo.tripadvisorapp.registrationAndLogin.api;


import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.registrationAndLogin.model.User;
import demo.tripadvisorapp.registrationAndLogin.repository.UserRepository;
import demo.tripadvisorapp.registrationAndLogin.service.UserService;
import demo.tripadvisorapp.repository.AdventureHolidaysRepository;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdventureHolidaysRepository adventureHolidaysRepository;

    @Autowired
    AdventureHolidaysService adventureHolidaysService;

    @Autowired
    UserService userService;

    @GetMapping("/tripAdvisorHomePage")
    public String index() {
        return "tripAdvisorHomePage";
    }

    @GetMapping("/profile")
    public String userProfile() {
        return "userProfile";
    }

    @GetMapping(path = "/saveHoliday/{id}")
    public ResponseEntity<Void> saveLink(@PathVariable("id") String id, String holidayId) {
        userService.saveDocument(id, holidayId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


