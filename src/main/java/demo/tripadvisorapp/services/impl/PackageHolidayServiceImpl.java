package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.EventTravel;
import demo.tripadvisorapp.models.PackageHoliday;
import demo.tripadvisorapp.repository.PackageHolidayRepository;
import demo.tripadvisorapp.services.PackageHolidayService;
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
public class PackageHolidayServiceImpl implements PackageHolidayService {

    private static final Queue<PackageHoliday> elementsToReturn = new LinkedList<>();

    @Autowired
    private final MongoTemplate mongoTemplate;

    public PackageHolidayServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public PackageHoliday findRandomPackageHoliday(String type) {
        if (elementsToReturn.size() == 0) {
            Query query = new Query();
            query.addCriteria(Criteria.where("typeOfPackageHoliday").is(type));
            List<PackageHoliday> newData = mongoTemplate.find(query, PackageHoliday.class);
            Collections.shuffle(newData);
            elementsToReturn.addAll(newData);
        }
        return elementsToReturn.poll();
    }

    @Override
    public long countPackageHoliday(String type) {
        Query query = new Query();
        query.addCriteria(Criteria.where("typeOfPackageHoliday").is(type));
        long count = mongoTemplate.count(query, PackageHoliday.class);
        System.out.println(count);

        return count;
    }
}

