package com.riwi.edudigital.infrastructure.abstract_services;

import com.riwi.edudigital.api.dto.request.UserRequest;
import com.riwi.edudigital.api.dto.response.UserResponse;

public interface IUserService extends CRUDAbstractService<UserRequest, UserResponse, Integer> {
    
}
