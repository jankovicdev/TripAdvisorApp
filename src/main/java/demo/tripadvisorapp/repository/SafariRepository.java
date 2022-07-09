package demo.tripadvisorapp.repository;

import demo.tripadvisorapp.models.Safari;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SafariRepository extends MongoRepository<Safari, String> {


    @Aggregation(pipeline = {"{'$match':{'typeOfSafari':'photographicSafari'}}",
            "{$sample:{size:1}}"
    })
    AggregationResults<Safari> randomPhotographicSafari();

    @Aggregation(pipeline = {"{'$match':{'typeOfSafari':'cyclingSafari'}}",
            "{$sample:{size:1}}"
    })
    AggregationResults<Safari> randomCyclingSafari();

}
