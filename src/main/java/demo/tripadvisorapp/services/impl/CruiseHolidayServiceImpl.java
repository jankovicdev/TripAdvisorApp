package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.CruiseHolidays;
import demo.tripadvisorapp.services.CruiseHolidaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class CruiseHolidayServiceImpl implements CruiseHolidaysService {

    private static final Queue<CruiseHolidays> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public CruiseHolidayServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public CruiseHolidays findRandomCruiseHolidays(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfCruiseHolidays").is(type));
            List<CruiseHolidays> newData = mongoTemplate.find(query, CruiseHolidays.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countCruiseHoliday(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfCruiseHolidays").is(type));
        long count = mongoTemplate.count(query, CruiseHolidays.class);
        System.out.println(count);

        return count;
    }
}
