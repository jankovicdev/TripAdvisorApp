package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.AdventureHolidays;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

@org.springframework.stereotype.Repository
public interface AdventureHolidaysRepository extends MongoRepository<AdventureHolidays, String> {

}
