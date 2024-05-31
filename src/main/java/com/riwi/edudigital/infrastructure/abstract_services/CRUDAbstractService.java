package com.riwi.edudigital.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

public interface CRUDAbstractService<RQ, RS, ID> {

    Page<RS> getAll(int page, int size);

    RS create(RQ request);

    RS update(ID id, RQ request);

    void delete(ID id);

    RS getById(ID id);
    
}
