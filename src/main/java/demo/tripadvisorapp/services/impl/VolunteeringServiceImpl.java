package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.Volunteering;
import demo.tripadvisorapp.repository.VolunteeringRepository;
import demo.tripadvisorapp.services.VolunteeringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class VolunteeringServiceImpl implements VolunteeringService {

    @Autowired
    private VolunteeringRepository volunteeringRepository;

    @Override
    public List<Volunteering> getRandomConservationAndEnvironment() {
        return Collections.singletonList(volunteeringRepository.randomChildcare().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<Volunteering> getRandomChildcare() {
        return Collections.singletonList(volunteeringRepository.randomConservationAndEnvironment().getMappedResults().stream().findFirst().orElse(null));
    }
}
