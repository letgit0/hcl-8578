package org.abes.hrmsdatabase.config;
import org.abes.hrmsdatabase.model.AppUser;
import org.abes.hrmsdatabase.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration public class AdminInitializer {
 @Bean CommandLineRunner createDefaultAdmin(AppUserRepository users){return args->{
  if(users.findByEmailIgnoreCase("admin@abes.ac.in").isEmpty()){
   users.save(new AppUser("admin@abes.ac.in",new BCryptPasswordEncoder().encode("Admin@123"),"HR Administrator"));
  }
 };}
}
