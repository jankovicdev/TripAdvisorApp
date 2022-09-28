package demo.tripadvisorapp.security.appuser;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional(readOnly = true)
@Repository
public interface AppUserRepository extends MongoRepository<AppUser, Long> {

    Optional<AppUser> findByEmail(String email);

}
