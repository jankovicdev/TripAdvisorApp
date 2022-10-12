package demo.tripadvisorapp.trips.repository;

import demo.tripadvisorapp.trips.models.AdventureHolidays;
import org.springframework.data.mongodb.repository.MongoRepository;

@org.springframework.stereotype.Repository
public interface AdventureHolidaysRepository extends MongoRepository<AdventureHolidays, String> {



}
