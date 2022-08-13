package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.Backpacking;


public interface BackpackingService {

    Backpacking findRandomBackpacking(String type);

    long countBackpacking(String type);

}
