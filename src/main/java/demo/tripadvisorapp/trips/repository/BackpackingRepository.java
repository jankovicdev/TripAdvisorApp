package demo.tripadvisorapp.trips.repository;

import demo.tripadvisorapp.trips.models.Backpacking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackpackingRepository extends MongoRepository<Backpacking, String> {

}
