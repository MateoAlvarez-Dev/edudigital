package com.riwi.edudigital.api.dto.response;

import com.riwi.edudigital.domain.entities.Assignment;
import com.riwi.edudigital.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubmissionResponse {
    
    private int id;

    private String content;

    private Double grade;

    private User user;

    private Assignment assignment;

}
