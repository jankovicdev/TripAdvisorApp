package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.Backpacking;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackpackingRepository extends MongoRepository<Backpacking, String> {

}
