package demo.tripadvisorapp.userProfile.api;

import com.sun.security.auth.UserPrincipal;
import demo.tripadvisorapp.registrationAndLogin.model.User;
import demo.tripadvisorapp.registrationAndLogin.repository.UserRepository;
import demo.tripadvisorapp.trips.models.AdventureHolidays;
import demo.tripadvisorapp.trips.repository.AdventureHolidaysRepository;
import demo.tripadvisorapp.userProfile.model.UserProfile;
import demo.tripadvisorapp.userProfile.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Optional;

@Controller
@RequestMapping("/api/userProfile")
public class UserProfileController {

    @Autowired
    AdventureHolidaysRepository adventureHolidaysRepository;

    @Autowired
    UserProfileRepository userProfileRepository;
    @Autowired
    UserRepository userRepository;


    @PostMapping("/savedAdventureHolidays/post/{postId}")
    public UserProfile createComment(@PathVariable(value = "postId") String postId,
                                     Model model) {

        UserProfile comment = new UserProfile();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return adventureHolidaysRepository.findById(postId).map(post -> {
            comment.setAdventureHolidaysList(Collections.singletonList(post));
            comment.setLoggedUserId(username);
            model.addAttribute("comment", comment);
            return userProfileRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }


}
