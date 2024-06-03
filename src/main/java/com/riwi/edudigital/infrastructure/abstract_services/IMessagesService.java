package com.riwi.edudigital.infrastructure.abstract_services;

import com.riwi.edudigital.api.dto.request.MessagesRequest;
import com.riwi.edudigital.api.dto.response.MessagesResponse;

public interface IMessagesService extends CRUDAbstractService<MessagesRequest, MessagesResponse, Integer>{
    
}
