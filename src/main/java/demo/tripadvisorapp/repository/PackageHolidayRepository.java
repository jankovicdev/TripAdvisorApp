package demo.tripadvisorapp.repository;


import demo.tripadvisorapp.models.PackageHoliday;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PackageHolidayRepository extends MongoRepository<PackageHoliday, String> {

    @Aggregation(pipeline={"{$sample:{size:1}}"})
    AggregationResults<PackageHoliday> randomPackageHoliday();
}