// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Set;

// @Entity
// @Table(name = "users")
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String name;

//     @Column(unique = true)
//     private String email;

//     private String password;

//     @ElementCollection
//     private Set<String> roles;

//     private LocalDateTime createdAt;

//     // relationship (used by FraudAlertRecord)
//     @OneToMany(mappedBy = "user")
//     private List<FraudAlertRecord> alerts;

//     // no-args constructor
//     public User() {
//     }

//     // core constructor
//     public User(String name, String email, String password, Set<String> roles) {
//         this.name = name;
//         this.email = email;
//         this.password = password;
//         this.roles = roles;
//     }

//     @PrePersist
//     public void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }

//     // -------- getters & setters --------

//     public Long getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getEmail() {
//         return email;
//     }
 
//     public void setEmail(String email) {
//         this.email = email;
//     }
 
//     public String getPassword() {
//         return password;
//     }
 
//     public void setPassword(String password) {
//         this.password = password;
//     }
 
//     public Set<String> getRoles() {
//         return roles;
//     }
 
//     public void setRoles(Set<String> roles) {
//         this.roles = roles;
//     }
 
//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }

//     public List<FraudAlertRecord> getAlerts() {
//         return alerts;
//     }

//     public void setAlerts(List<FraudAlertRecord> alerts) {
//         this.alerts = alerts;
//     }
// }
