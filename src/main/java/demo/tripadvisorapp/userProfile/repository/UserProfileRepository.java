package demo.tripadvisorapp.userProfile.repository;

import demo.tripadvisorapp.userProfile.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {


}
