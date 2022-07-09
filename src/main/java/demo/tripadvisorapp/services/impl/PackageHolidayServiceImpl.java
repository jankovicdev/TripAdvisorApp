package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.repository.PackageHolidayRepository;
import demo.tripadvisorapp.services.PackageHolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PackageHolidayServiceImpl implements PackageHolidayService {

    @Autowired
    private PackageHolidayRepository packageHolidayRepository;


    @Override
    public List<PackageHoliday> getRandomIndependentTours() {
        return Collections.singletonList(packageHolidayRepository.randomIndependentTours().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<PackageHoliday> getRandomEscortedTours() {
        return Collections.singletonList(packageHolidayRepository.randomEscortedTours().getMappedResults().stream().findFirst().orElse(null));
    }

}

