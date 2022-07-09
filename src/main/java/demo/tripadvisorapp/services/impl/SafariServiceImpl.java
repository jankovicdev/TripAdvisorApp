package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.repository.SafariRepository;
import demo.tripadvisorapp.services.SafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.tripadvisorapp.models.Safari;

import java.util.Collections;
import java.util.List;

@Service
public class SafariServiceImpl implements SafariService {

    @Autowired
    private SafariRepository safariRepository;


    @Override
    public List<Safari> getRandomPhotographic() {
        return Collections.singletonList(safariRepository.randomPhotographicSafari().getMappedResults().stream().findFirst().orElse(null));
    }

    @Override
    public List<Safari> getRandomCycling() {
        return Collections.singletonList(safariRepository.randomCyclingSafari().getMappedResults().stream().findFirst().orElse(null));
    }
}
