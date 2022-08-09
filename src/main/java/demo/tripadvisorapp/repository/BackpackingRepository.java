package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.Backpacking;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BackpackingRepository extends MongoRepository<Backpacking, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfBackpacking':'longDistanceHiking'}}", "{$sample:{size:1}}"})
    AggregationResults<Backpacking> randomLongDistanceHiking();

    @Aggregation(pipeline = {"{'$match':{'typeOfBackpacking':'thruHiking'}}", "{$sample:{size:1}}"})
    AggregationResults<Backpacking> randomThruHiking();

}
