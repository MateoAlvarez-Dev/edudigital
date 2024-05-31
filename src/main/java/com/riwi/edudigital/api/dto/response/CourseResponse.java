package com.riwi.edudigital.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {
    
    private int id;

    private String name;

    private String description;

    private UserResponse instructor;

}
