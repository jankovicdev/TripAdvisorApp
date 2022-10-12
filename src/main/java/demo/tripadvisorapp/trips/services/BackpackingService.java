package demo.tripadvisorapp.trips.services;

import demo.tripadvisorapp.trips.models.Backpacking;


public interface BackpackingService {

    Backpacking findRandomBackpacking(String type);

    long countBackpacking(String type);

}
