package com.Music.dto;

import com.Music.model.Role;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpInput {

    @Pattern(regexp = "[A-Z][a-z]*" , message = "First Letter of Name should be Capital")
    private String userName;

    @NotBlank
    private String password;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Enter Valid Email")
    private String email;

    @NotNull
    private Integer age;
    @ManyToOne
    private Role role;
}
