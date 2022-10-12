package demo.tripadvisorapp.registrationAndLogin.service;

import demo.tripadvisorapp.trips.models.AdventureHolidays;
import demo.tripadvisorapp.registrationAndLogin.model.User;
import demo.tripadvisorapp.registrationAndLogin.repository.UserRepository;
import demo.tripadvisorapp.trips.repository.AdventureHolidaysRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AdventureHolidaysRepository adventureHolidaysRepository;

    public void saveDocument(String userId, String holidayId) {

        User user = userRepository.findById(userId).orElse(null);
        AdventureHolidays adventureHolidays = adventureHolidaysRepository.findById(holidayId).orElse(null);
        assert user != null;
        user.getAdventureHolidaysList().add(adventureHolidays);
        userRepository.save(user);
    }


}
