package com.riwi.edudigital.api.dto.response;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesResponse {

    private int id;

    private String content;

    private Date date;

    private UserResponse sender;

    private UserResponse receiver;

    private CourseResponse course;

}
