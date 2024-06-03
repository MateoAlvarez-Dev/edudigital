package com.riwi.edudigital.util.mappers;

import com.riwi.edudigital.api.dto.request.MessagesRequest;
import com.riwi.edudigital.api.dto.response.MessagesResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Message;
import com.riwi.edudigital.domain.entities.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageMapper {

    private UserMapper userMapper;
    private CourseMapper courseMapper;

    public MessagesResponse entityToResponse(Message message){
        MessagesResponse response = MessagesResponse.builder()
                                  .id(message.getId())
                                  .content(message.getContent())
                                  .date(message.getDate())
                                  .sender(this.userMapper.entityToResponse(message.getSender()))
                                  .receiver(this.userMapper.entityToResponse(message.getReceiver()))
                                  .course(this.courseMapper.entityToResponse(message.getCourse_id()))
                                  .build();
                                  
        return response;
    }
    
    public Message requestToEntity(MessagesRequest request){
        User sender = User.builder().id(request.getSender_id()).build();
        User receiver = User.builder().id(request.getReceiver_id()).build();
        Course course = Course.builder().id(request.getCourse_id()).build();

        Message message = Message.builder()
                      .content(request.getContent())
                      .sender(sender)
                      .receiver(receiver)
                      .course_id(course)
                      .build();

        return message;
    }
}
