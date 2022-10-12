package demo.tripadvisorapp.trips.repository;

import demo.tripadvisorapp.trips.models.PackageHoliday;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageHolidayRepository extends MongoRepository<PackageHoliday, String> {

    @Aggregation(pipeline = {"{'$match':{'typeOfPackageHoliday':'independentTours'}}", "{$sample:{size:1}}"})
    AggregationResults<PackageHoliday> randomIndependentTours();

    @Aggregation(pipeline = {"{'$match':{'typeOfPackageHoliday':'escortedTours'}}", "{$sample:{size:1}}"})
    AggregationResults<PackageHoliday> randomEscortedTours();
}