package demo.tripadvisorapp.trips.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeAPI {

    @GetMapping("/show")
    public String showHome() {
        return "index";
    }
}
