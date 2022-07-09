package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.EventTravel;
import demo.tripadvisorapp.repository.EventTravelRepository;
import demo.tripadvisorapp.services.EventTravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EventTravelServiceImpl implements EventTravelService {

    @Autowired
    private EventTravelRepository eventTravelRepository;

    @Override
    public List<EventTravel> getRandomSportsEvents() {
        return Collections.singletonList(eventTravelRepository.randomSportsEvents().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<EventTravel> getRandomRecreationsEvents() {
        return Collections.singletonList(eventTravelRepository.randomRecreationsEvents().getMappedResults().stream().findFirst().orElse(null));
    }
}
