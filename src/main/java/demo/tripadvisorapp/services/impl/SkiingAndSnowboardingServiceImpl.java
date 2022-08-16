package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.SkiingAndSnowBoarding;
import demo.tripadvisorapp.services.SkiingAndSnowboardingService;
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
public class SkiingAndSnowboardingServiceImpl implements SkiingAndSnowboardingService {

    private static final Queue<SkiingAndSnowBoarding> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public SkiingAndSnowboardingServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public SkiingAndSnowBoarding findRandomSkiingAndSnowboarding(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfSkiingAndSnowboarding").is(type));
            List<SkiingAndSnowBoarding> newData = mongoTemplate.find(query, SkiingAndSnowBoarding.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countSkiingAndSnowboarding(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfSkiingAndSnowboarding").is(type));
        long count = mongoTemplate.count(query, SkiingAndSnowBoarding.class);
        System.out.println(count);

        return count;
    }
}