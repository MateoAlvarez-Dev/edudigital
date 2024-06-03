package com.riwi.edudigital.infrastructure.abstract_services;

import com.riwi.edudigital.api.dto.request.UserRequest;
import com.riwi.edudigital.api.dto.response.UserResponse;
import com.riwi.edudigital.api.dto.response.UserResponseFull;

public interface IUserService extends CRUDAbstractService<UserRequest, UserResponse, Integer> {
    public UserResponseFull getByIdFull(Integer id);
}
