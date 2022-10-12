package demo.tripadvisorapp.trips.api;

import demo.tripadvisorapp.trips.services.SafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/safari")
public class SafariAPI {


    AtomicInteger countPhotographicSafari = new AtomicInteger();
    AtomicInteger countCyclingSafari = new AtomicInteger();

    @Autowired
    private SafariService safariService;

    @GetMapping("/getRandomPhotographicSafari")
    public String getRandomPhotographicSafari(Model model) {
        countPhotographicSafari.incrementAndGet();
        if (getCountPhotographicSafari() <= safariService.countSafari("photographicSafari")) {
            model.addAttribute("randomPhotographicSafari", safariService.findRandomSafari("photographicSafari"));
            System.out.println("in if");
        } else {
            countPhotographicSafari.set(0);
            return "noMoreDoc";
        }
        return "randomPhotographicSafari";
    }

    @GetMapping("/getRandomCyclingSafari")
    public String getRandomCyclingSafari(Model model) {
        countCyclingSafari.incrementAndGet();
        if (getCountCyclingSafari() <= safariService.countSafari("cyclingSafari")) {
            model.addAttribute("randomCyclingSafari", safariService.findRandomSafari("cyclingSafari"));
            System.out.println("in if");
        } else {
            countCyclingSafari.set(0);
            return "noMoreDoc";
        }
        return "randomCyclingSafari";
    }

    public int getCountPhotographicSafari() {
        return this.countPhotographicSafari.get();
    }

    public int getCountCyclingSafari() {
        return this.countCyclingSafari.get();
    }

}
