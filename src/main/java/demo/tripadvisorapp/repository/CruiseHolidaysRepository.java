package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.CruiseHolidays;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CruiseHolidaysRepository extends MongoRepository<CruiseHolidays, String> {

}