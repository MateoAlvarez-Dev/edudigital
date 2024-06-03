package com.riwi.edudigital.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.riwi.edudigital.api.dto.request.MessagesRequest;
import com.riwi.edudigital.api.dto.response.MessagesResponse;
import com.riwi.edudigital.infrastructure.abstract_services.IMessagesService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/messages")
@AllArgsConstructor
public class MessageController {

    @Autowired
    private final IMessagesService messageService;

    @GetMapping
    public ResponseEntity<Page<MessagesResponse>> getAll(@RequestParam(defaultValue = "0") int page, 
                                                         @RequestParam(defaultValue = "10") int size) {
        return new ResponseEntity<>(messageService.getAll(page, size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MessagesResponse> create(@RequestBody MessagesRequest request) {
        return new ResponseEntity<>(messageService.create(request), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MessagesResponse> update(@PathVariable Integer id, 
                                                   @RequestBody MessagesRequest request) {
        return new ResponseEntity<>(messageService.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        messageService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MessagesResponse> getById(@PathVariable Integer id) {
        return new ResponseEntity<>(messageService.getById(id), HttpStatus.OK);
    }
}