package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.Safari;

import java.util.List;

public interface SafariService {

    List<Safari> getRandomPhotographic();
    List<Safari> getRandomCycling();

}
