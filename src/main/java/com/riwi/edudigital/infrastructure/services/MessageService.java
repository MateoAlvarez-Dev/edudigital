package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.MessagesRequest;
import com.riwi.edudigital.api.dto.response.MessagesResponse;
import com.riwi.edudigital.domain.entities.Course;
import com.riwi.edudigital.domain.entities.Message;
import com.riwi.edudigital.domain.entities.User;
import com.riwi.edudigital.domain.repositories.MessageRepository;
import com.riwi.edudigital.infrastructure.abstract_services.IMessagesService;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MessageService implements IMessagesService{

    @Autowired
    private final MessageRepository messageRepository;

    @Override
    public Page<MessagesResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.messageRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public MessagesResponse create(MessagesRequest request) {
        Message messageToSave = this.requestToEntity(request);
        Message messageSaved = this.messageRepository.save(messageToSave);
        MessagesResponse response = this.entityToResponse(messageSaved);
        return response;
    }

    @Override
    public MessagesResponse update(Integer id, MessagesRequest request) {
        this.findById(id);

        Message messageToUpdate = this.requestToEntity(request);

        messageToUpdate.setId(id);

        this.messageRepository.save(messageToUpdate);

        return this.entityToResponse(messageToUpdate);
    }

    @Override
    public void delete(Integer id) {
        Message messageToDelete = this.findById(id);

        this.messageRepository.delete(messageToDelete);
    }

    @Override
    public MessagesResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }
    
    // Utils

    public Message findById(Integer id){
        return this.messageRepository.findById(id).orElseThrow();
    }

    public MessagesResponse entityToResponse(Message message){
        MessagesResponse response = MessagesResponse.builder()
                                  .id(message.getId())
                                  .content(message.getContent())
                                  .date(message.getDate())
                                  .sender(message.getSender())
                                  .receiver(message.getReceiver())
                                  .course(message.getCourse_id())
                                  .build();
                                  
        return response;
    }
    
    private Message requestToEntity(MessagesRequest request){
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