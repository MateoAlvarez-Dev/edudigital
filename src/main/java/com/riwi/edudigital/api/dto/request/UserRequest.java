package com.riwi.edudigital.api.dto.request;

import com.riwi.edudigital.util.enums.RoleType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private int id;

    @Size(min = 4, max = 20, message = "Please insert an username with at least 4 characters, max is 20")
    @NotBlank(message = "The username is required")
    private String username;

    @Size(min = 8, max = 20, message = "Minimum length is 8 for the password, max is 20")
    @NotBlank(message = "The password is required")
    private String password;

    @Email(message = "Please insert a valid email")
    @NotBlank(message = "The email is required")
    private String email;

    @NotBlank(message = "Your full name is required")
    private String full_name;

    @NotBlank(message = "The role is required")
    private RoleType role;

}
