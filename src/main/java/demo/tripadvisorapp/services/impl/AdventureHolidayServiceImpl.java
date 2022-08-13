package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.repository.AdventureHolidaysRepository;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
@Component
@EnableAutoConfiguration
public class AdventureHolidayServiceImpl implements AdventureHolidaysService {

    private static final Queue<AdventureHolidays> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public AdventureHolidayServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public AdventureHolidays findRandomAdventureHolidays(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfAdventureHolidays").is(type));
            List<AdventureHolidays> newData = mongoTemplate.find(query, AdventureHolidays.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countAdventureHolidays(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfAdventureHolidays").is(type));
        long count = mongoTemplate.count(query, AdventureHolidays.class);
        System.out.println(count);

        return count;

    }
}
