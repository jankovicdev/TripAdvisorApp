package demo.tripadvisorapp.services;

import demo.tripadvisorapp.models.Backpacking;

import java.util.List;

public interface BackpackingService {

    List<Backpacking> getRandomLongDistanceHiking();

    List<Backpacking> getRandomThruHiking();

}
