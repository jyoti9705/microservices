package com.jyoti.webservices.restfulwebserviceswithspringboot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Entity(name = "USER")
@SequenceGenerator(name = "USER_SEQ",sequenceName = "USER_SEQUENCE",allocationSize = 50,initialValue = 1)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "USER_SEQ")
    private Integer id;
    @Column(name = "NAME")
    @Size(min = 2, message = "Name should have atleast 2 Characters")
    private String name;
    @Column(name = "BIRTHDATE")
    @Past(message = "Date should be in past")
    private LocalDate birthdate;
    @OneToMany(mappedBy = "user")
    private List<Post> posts;
}
