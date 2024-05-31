package com.riwi.edudigital.infrastructure.abstract_services;

import com.riwi.edudigital.api.dto.request.CourseRequest;
import com.riwi.edudigital.api.dto.response.CourseResponse;

public interface ICourseService extends CRUDAbstractService<CourseRequest, CourseResponse, Integer> {
    
}
