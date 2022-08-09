package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.EventTravel;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventTravelRepository extends MongoRepository<EventTravel, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfEventTravel':'sportEvents'}}", "{$sample:{size:1}}"})
    AggregationResults<EventTravel> randomSportsEvents();

    @Aggregation(pipeline = {"{'$match':{'typeOfEventTravel':'recreationsEvents'}}", "{$sample:{size:1}}"})
    AggregationResults<EventTravel> randomRecreationsEvents();

}