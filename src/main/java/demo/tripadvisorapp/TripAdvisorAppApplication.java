package demo.tripadvisorapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TripAdvisorAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TripAdvisorAppApplication.class, args);
    }



   /* @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            userService.saveUser(new User(null, "Stefan", "stefanadmin", "stefanadmin", new ArrayList<>()));
            userService.saveUser(new User(null, "Marko", "markoadmin", "markoadmin", new ArrayList<>()));
            userService.saveUser(new User(null, "Jovan", "jovanobicanuser", "jovanobicanuser", new ArrayList<>()));

            userService.addRoleToUser("stefanadmin", "ROLE_ADMIN");
            userService.addRoleToUser("stefanadmin", "ROLE_USER");
            userService.addRoleToUser("markoadmin", "ROLE_ADMIN");
            userService.addRoleToUser("jovanobicanuser", "ROLE_USER");


        };
    }*/

}
