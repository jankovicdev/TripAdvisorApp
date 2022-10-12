package demo.tripadvisorapp.trips.services.impl;

import demo.tripadvisorapp.trips.models.AdventureHolidays;
import demo.tripadvisorapp.trips.repository.AdventureHolidaysRepository;
import demo.tripadvisorapp.trips.services.AdventureHolidaysService;
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
import org.springframework.util.StringUtils;

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
    public String saveImage(MultipartFile file) {
        AdventureHolidays adventureHolidays = new AdventureHolidays();
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            adventureHolidays.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        adventureHolidaysRepository.save(adventureHolidays);
        return fileName;
    }
}
