package demo.tripadvisorapp.trips.repository;

import demo.tripadvisorapp.trips.models.SkiingAndSnowBoarding;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SkiingAndSnowboardingRepository extends MongoRepository<SkiingAndSnowBoarding, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfSkiingAndSnowboarding':'backcountrySkiing'}}", "{$sample:{size:1}}"})
    AggregationResults<SkiingAndSnowBoarding> randomBackcountrySkiing();

    @Aggregation(pipeline = {"{'$match':{'typeOfSkiingAndSnowboarding':'downhillSkiing'}}", "{$sample:{size:1}}"})
    AggregationResults<SkiingAndSnowBoarding> randomDownhillSkiing();

}