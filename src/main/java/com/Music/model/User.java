package com.Music.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = User.class,property = "userId")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotBlank(message = "Name cannot be blank")
    @Pattern(regexp = "[A-Z][a-z]*" , message = "First Letter of Name should be Capital")
    private String userName;

    @NotBlank(message = "Password cannot be blank")
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter Valid Email")
    private String email;

    @NotNull
    @Min(value = 5 , message = "Age should not be smaller than 5")
    @Max(value = 70 , message = "Age should not be greater than 70")
    private Integer age;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_playList")
    private PlayList playList;


    public User(String userName , String password , String email , Integer age ,  Role role ){
        this. userName = userName;
        this.password = password;
        this.email = email;
        this.age = age;
        this.role = role;
    }
}
