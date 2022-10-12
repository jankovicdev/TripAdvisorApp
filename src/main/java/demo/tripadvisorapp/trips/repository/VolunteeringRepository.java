package demo.tripadvisorapp.trips.repository;

import demo.tripadvisorapp.trips.models.Volunteering;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VolunteeringRepository extends MongoRepository<Volunteering, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfVolunteering':'conservationAndEnvironment'}}", "{$sample:{size:1}}"})
    AggregationResults<Volunteering> randomConservationAndEnvironment();

    @Aggregation(pipeline = {"{'$match':{'typeOfVolunteering':'childcare'}}", "{$sample:{size:1}}"})
    AggregationResults<Volunteering> randomChildcare();

}