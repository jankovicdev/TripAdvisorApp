package demo.tripadvisorapp.login.api;

import demo.tripadvisorapp.login.payload.request.LoginRequest;
import demo.tripadvisorapp.login.payload.request.SignupRequest;
import demo.tripadvisorapp.login.security.jwt.JwtUtils;
import demo.tripadvisorapp.login.model.User;
import demo.tripadvisorapp.login.payload.response.MessageResponse;
import demo.tripadvisorapp.login.payload.response.UserInfoResponse;
import demo.tripadvisorapp.login.repository.UserRepository;
import demo.tripadvisorapp.login.security.services.UserDetailsImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtUtils jwtHelper;
    @Autowired
    PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    @Transactional
    public ResponseEntity<?> login(@Valid @ModelAttribute("login") LoginRequest loginRequest, Model model) {
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtHelper.generateJwtCookie(user);


        model.addAttribute("login", loginRequest);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/users/tripAdvisorHomePage");
        return new ResponseEntity<String>(headers, HttpStatus.FOUND);

        /*return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(user.getId(),
                        user.getUsername(),
                        user.getEmail()));*/
    }


    @PostMapping("/signup")
    @Transactional
    public ResponseEntity<?> signup(@Valid @ModelAttribute("signup") SignupRequest signupRequest, Model model) throws Exception {

        if (userRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        User user = new User(signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()));

        model.addAttribute("signup", signupRequest);
        userRepository.save(user);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));


    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtHelper.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @GetMapping("/loginAndRegisterForm")
    public String showLoginForm(Model model) {
        // create model object to store form data
        LoginRequest loginRequest = new LoginRequest();
        SignupRequest signupRequest = new SignupRequest();
        model.addAttribute("login", loginRequest);
        model.addAttribute("user", signupRequest);
        return "loginAndRegisterForm";
    }
}