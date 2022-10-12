package demo.tripadvisorapp.trips.repository;

import demo.tripadvisorapp.trips.models.CruiseHolidays;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CruiseHolidaysRepository extends MongoRepository<CruiseHolidays, String> {

}