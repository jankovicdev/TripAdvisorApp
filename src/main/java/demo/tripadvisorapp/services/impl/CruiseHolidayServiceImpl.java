package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.CruiseHolidays;
import demo.tripadvisorapp.repository.CruiseHolidaysRepository;
import demo.tripadvisorapp.services.CruiseHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CruiseHolidayServiceImpl implements CruiseHolidaysService {

    @Autowired
    private CruiseHolidaysRepository cruiseHolidaysRepository;

    @Override
    public List<CruiseHolidays> getRandomOceanCruising() {
        return Collections.singletonList(cruiseHolidaysRepository.randomOceanCruising().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<CruiseHolidays> getRandomRiverCruising() {
        return Collections.singletonList(cruiseHolidaysRepository.randomRiverCruising().getMappedResults().stream().findFirst().orElse(null));
    }
}
