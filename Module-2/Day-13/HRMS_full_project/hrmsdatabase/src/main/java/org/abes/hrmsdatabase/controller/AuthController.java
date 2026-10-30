package org.abes.hrmsdatabase.controller;
import org.abes.hrmsdatabase.model.AppUser;
import org.abes.hrmsdatabase.repository.AppUserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.Map;
@RestController @RequestMapping("/api/auth")
@CrossOrigin(origins={"http://localhost:5173","http://127.0.0.1:5173"})
public class AuthController {
 private final AppUserRepository users; private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
 public AuthController(AppUserRepository users){this.users=users;}
 @PostMapping("/login") public ResponseEntity<?> login(@RequestBody LoginRequest request){
  if(request==null || request.email()==null || request.password()==null) return ResponseEntity.badRequest().body(Map.of("message","Email and password are required"));
  AppUser user=users.findByEmailIgnoreCase(request.email().trim()).orElse(null);
  if(user==null || !encoder.matches(request.password(),user.getPasswordHash())) return ResponseEntity.status(401).body(Map.of("message","Incorrect email or password"));
  return ResponseEntity.ok(Map.of("message","Login successful","email",user.getEmail(),"name",user.getDisplayName()));
 }
 public record LoginRequest(String email,String password){}
}
