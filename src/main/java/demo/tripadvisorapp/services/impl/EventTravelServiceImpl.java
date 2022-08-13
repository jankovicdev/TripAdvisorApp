package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.CruiseHolidays;
import demo.tripadvisorapp.models.EventTravel;
import demo.tripadvisorapp.repository.EventTravelRepository;
import demo.tripadvisorapp.services.EventTravelService;
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
public class EventTravelServiceImpl implements EventTravelService {

    private static final Queue<EventTravel> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public EventTravelServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public EventTravel findRandomEventTravel(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfEventTravel").is(type));
            List<EventTravel> newData = mongoTemplate.find(query, EventTravel.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countEventTravel(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfEventTravel").is(type));
        long count = mongoTemplate.count(query, EventTravel.class);
        System.out.println(count);

        return count;
    }
}
