package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.Safari;
import demo.tripadvisorapp.services.SafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequestMapping("/safari")
public class SafariAPI {

    int countPhotographicSafari = 0;
    int countCyclingSafari = 0;

    @Autowired
    private SafariService safariService;

    @GetMapping("/getRandomPhotographicSafari")
    public String getRandomPhotographicSafari(Model model) {
        countPhotographicSafari++;
        if (countPhotographicSafari <= safariService.countSafari("photographicSafari")) {
            model.addAttribute("randomPhotographicSafari", safariService.findRandomSafari("photographicSafari"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomPhotographicSafari";
    }

    @GetMapping("/getRandomCyclingSafari")
    public String getRandomCyclingSafari(Model model) {
        countCyclingSafari++;
        if (countCyclingSafari <= safariService.countSafari("cyclingSafari")) {
            model.addAttribute("randomCyclingSafari", safariService.findRandomSafari("cyclingSafari"));
            System.out.println("in if");
        } else {
            return "noMoreDoc";
        }
        return "randomCyclingSafari";
    }

}
