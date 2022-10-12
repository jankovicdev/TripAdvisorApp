package demo.tripadvisorapp.trips.services.impl;

import demo.tripadvisorapp.trips.services.SafariService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import demo.tripadvisorapp.trips.models.Safari;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Service
public class SafariServiceImpl implements SafariService {

    private static final Queue<Safari> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public SafariServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Safari findRandomSafari(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfSafari").is(type));
            List<Safari> newData = mongoTemplate.find(query, Safari.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countSafari(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfSafari").is(type));
        long count = mongoTemplate.count(query, Safari.class);
        System.out.println(count);

        return count;
    }
}
