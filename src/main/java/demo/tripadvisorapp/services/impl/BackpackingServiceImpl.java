package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.Backpacking;
import demo.tripadvisorapp.repository.BackpackingRepository;
import demo.tripadvisorapp.services.BackpackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BackpackingServiceImpl implements BackpackingService {

    @Autowired
    private BackpackingRepository backpackingRepository;

    @Override
    public List<Backpacking> getRandomLongDistanceHiking() {
        return Collections.singletonList(backpackingRepository.randomLongDistanceHiking().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<Backpacking> getRandomThruHiking() {
        return Collections.singletonList(backpackingRepository.randomThruHiking().getMappedResults().stream().findFirst().orElse(null));
    }

}
