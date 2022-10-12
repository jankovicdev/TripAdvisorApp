package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.Safari;

public interface SafariService {

    Safari findRandomSafari(String type);

    long countSafari(String type);

}
