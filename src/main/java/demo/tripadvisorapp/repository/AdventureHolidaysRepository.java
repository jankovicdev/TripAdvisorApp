package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.AdventureHolidays;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdventureHolidaysRepository extends MongoRepository<AdventureHolidays, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfAdventureHolidays':'summerCamps'}}", "{$sample:{size:1}}"})
    AggregationResults<AdventureHolidays> randomSummerCamps();

    @Aggregation(pipeline = {"{'$match':{'typeOfAdventureHolidays':'trekking'}}", "{$sample:{size:1}}"})
    AggregationResults<AdventureHolidays> randomTrekking();

}
