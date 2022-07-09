package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.CruiseHolidays;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CruiseHolidaysRepository extends MongoRepository<CruiseHolidays, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfCruiseHolidays':'oceanCruising'}}", "{$sample:{size:1}}"})
    AggregationResults<CruiseHolidays> randomOceanCruising();

    @Aggregation(pipeline = {"{'$match':{'typeOfCruiseHolidays':'riverCruising'}}", "{$sample:{size:1}}"})
    AggregationResults<CruiseHolidays> randomRiverCruising();

}