package demo.tripadvisorapp.services.impl;

import demo.tripadvisorapp.models.AdventureHolidays;
import demo.tripadvisorapp.repository.AdventureHolidaysRepository;
import demo.tripadvisorapp.services.AdventureHolidaysService;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;


@Service
@Component
@EnableAutoConfiguration
public class AdventureHolidayServiceImpl implements AdventureHolidaysService {

    private static final Queue<AdventureHolidays> elementsToReturn = new LinkedList<>();

    @Autowired
    AdventureHolidaysRepository adventureHolidaysRepository;

    @Autowired
    private final MongoTemplate mongoTemplate;

    @Autowired
    private GridFsTemplate template;

    @Autowired
    private GridFsOperations operations;

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

    @Override
    public String addPhoto(MultipartFile file) throws IOException {
        AdventureHolidays photo = new AdventureHolidays();
        photo.setImage(
                new Binary(BsonBinarySubType.BINARY, file.getBytes()));
        photo = adventureHolidaysRepository.insert(photo);
        return photo.getId();
    }

    public AdventureHolidays getPhoto() {
        return adventureHolidaysRepository.findAll().stream().findFirst().orElse(null);
    }


}
