package demo.tripadvisorapp.api;

import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.services.PackageHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/packageHoliday")
public class PackageHolidayAPI {

    @Autowired
    private PackageHolidayService packageHolidayService;

    @GetMapping("/getRandomPackageHoliday")
    public List<PackageHoliday> getRandomHiking() {

        return packageHolidayService.getRandomPackageHoliday();
    }


}
