package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.Backpacking;
import demo.tripadvisorapp.services.BackpackingService;
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
public class BackpackingServiceImpl implements BackpackingService {

    private static final Queue<Backpacking> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public BackpackingServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Backpacking findRandomBackpacking(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfBackpacking").is(type));
            List<Backpacking> newData = mongoTemplate.find(query, Backpacking.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }


    @Override
    public long countBackpacking(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfBackpacking").is(type));
        long count = mongoTemplate.count(query, Backpacking.class);
        System.out.println(count);

        return count;

    }
}

