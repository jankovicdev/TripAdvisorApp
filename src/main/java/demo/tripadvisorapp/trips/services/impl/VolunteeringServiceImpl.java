package demo.tripadvisorapp.trips.services.impl;

import demo.tripadvisorapp.trips.models.Volunteering;
import demo.tripadvisorapp.trips.services.VolunteeringService;
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
public class VolunteeringServiceImpl implements VolunteeringService {

    private static final Queue<Volunteering> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public VolunteeringServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Volunteering findRandomVolunteering(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfVolunteering").is(type));
            List<Volunteering> newData = mongoTemplate.find(query, Volunteering.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countVolunteering(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfVolunteering").is(type));
        long count = mongoTemplate.count(query, Volunteering.class);
        System.out.println(count);

        return count;
    }
}
