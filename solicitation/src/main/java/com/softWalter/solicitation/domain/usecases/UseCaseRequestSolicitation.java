package com.softWalter.solicitation.domain.usecases;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;

import java.util.List;

public interface UseCaseRequestSolicitation {

    //save
    RequestSolicitation save(RequestSolicitation requestSolicitation);
    //update
    RequestSolicitation update(RequestSolicitation requestSolicitation);
    //get
    RequestSolicitation getById(Long id );
    //list
    List<RequestSolicitation> listAll();
    //listByOwner
    List<RequestSolicitation> findAllByOwnerId(Long Id);

}
