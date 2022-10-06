package demo.tripadvisorapp.registrationAndLogin.api;

import demo.tripadvisorapp.registrationAndLogin.payload.request.LoginRequest;
import demo.tripadvisorapp.registrationAndLogin.payload.request.SignupRequest;
import demo.tripadvisorapp.registrationAndLogin.security.jwt.JwtUtils;
import demo.tripadvisorapp.registrationAndLogin.model.User;
import demo.tripadvisorapp.registrationAndLogin.payload.response.MessageResponse;
import demo.tripadvisorapp.registrationAndLogin.repository.UserRepository;
import demo.tripadvisorapp.registrationAndLogin.security.services.UserDetailsImpl;
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
import java.net.URI;

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

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/api/users/tripAdvisorHomePage"))
                .header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .build();

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

        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/api/auth/loginAndRegisterForm"))
                .build();
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtHelper.getCleanJwtCookie();
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create("/api/auth/loginAndRegisterForm"))
                .header(HttpHeaders.SET_COOKIE, cookie.toString())
                .build();
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