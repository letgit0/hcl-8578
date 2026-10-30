package org.abes.hrmsdatabase.model;
import jakarta.persistence.*;
@Entity
@Table(name="app_users")
public class AppUser {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false, unique=true) private String email;
 @Column(nullable=false) private String passwordHash;
 @Column(nullable=false) private String displayName;
 public AppUser() {}
 public AppUser(String email,String passwordHash,String displayName){this.email=email;this.passwordHash=passwordHash;this.displayName=displayName;}
 public Long getId(){return id;} public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String v){passwordHash=v;}
 public String getDisplayName(){return displayName;} public void setDisplayName(String v){displayName=v;}
}
