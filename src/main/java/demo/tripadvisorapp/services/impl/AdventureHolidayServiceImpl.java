package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.repository.AdventureHolidaysRepository;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AdventureHolidayServiceImpl implements AdventureHolidaysService {

    @Autowired
    private AdventureHolidaysRepository adventureHolidaysRepository;

    @Override
    public List<AdventureHolidays> getRandomSummerCamps() {
        return Collections.singletonList(adventureHolidaysRepository.randomSummerCamps().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<AdventureHolidays> getRandomTrekking() {
        return Collections.singletonList(adventureHolidaysRepository.randomTrekking().getMappedResults().stream().findFirst().orElse(null));
    }
}
