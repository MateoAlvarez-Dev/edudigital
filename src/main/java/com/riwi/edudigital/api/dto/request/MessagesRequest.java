package com.riwi.edudigital.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessagesRequest {

    @NotBlank(message = "The content is required")
    private String content;

    @NotNull(message = "The sender id is required")
    private int sender_id;

    @NotNull(message = "The receiver id is required")
    private int receiver_id;

    @NotNull(message = "The course id is required")
    private int course_id;

}
