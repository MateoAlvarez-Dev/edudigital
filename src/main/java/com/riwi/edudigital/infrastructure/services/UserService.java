package com.riwi.edudigital.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.edudigital.api.dto.request.UserRequest;
import com.riwi.edudigital.api.dto.response.UserResponse;
import com.riwi.edudigital.api.dto.response.UserResponseFull;
import com.riwi.edudigital.domain.entities.User;
import com.riwi.edudigital.domain.repositories.UserRepository;
import com.riwi.edudigital.infrastructure.abstract_services.IUserService;
import com.riwi.edudigital.util.mappers.UserMapper;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserService extends UserMapper implements IUserService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public Page<UserResponse> getAll(int page, int size) {
        if(page < 0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(this::entityToResponse);
    }

    @Override
    public UserResponse create(UserRequest request) {
        User userToSave = this.requestToEntity(request);
        User userSaved = this.userRepository.save(userToSave);
        UserResponse response = this.entityToResponse(userSaved);
        return response;
    }

    @Override
    public UserResponse update(Integer id, UserRequest request) {
        this.findById(id);

        User userToUpdate = this.requestToEntity(request);

        userToUpdate.setId(id);

        this.userRepository.save(userToUpdate);

        return this.entityToResponse(userToUpdate);
    }

    @Override
    public void delete(Integer id) {
        User userToDelete = this.findById(id);

        this.userRepository.delete(userToDelete);
    }

    @Override
    public UserResponse getById(Integer id) {
        return this.entityToResponse(this.findById(id));
    }

    public UserResponseFull getByIdFull(Integer id) {
        return this.entityToResponseFull(this.findById(id));
    }

    // Utils
    
    public User findById(Integer id){
        return this.userRepository.findById(id).orElseThrow();
    }

}
