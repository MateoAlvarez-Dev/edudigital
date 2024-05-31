package com.riwi.edudigital.api.dto.response;

import com.riwi.edudigital.util.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    
    private int id;

    private String username;

    private String email;

    private String full_name;

    private RoleType role;

}
