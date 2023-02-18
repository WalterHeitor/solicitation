package com.softWalter.solicitation.domain.usecases.impl;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.enums.RequestState;
import com.softWalter.solicitation.domain.repositories.RequestSolicitationRepository;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestSolicitation;
import com.softWalter.solicitation.domain.usecases.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class RequestSolicitationImpl implements UseCaseRequestSolicitation {
    @Autowired
    RequestSolicitationRepository requestSolicitationRepository;
    @Override
    public RequestSolicitation save(RequestSolicitation requestSolicitation) {

        requestSolicitation.setRequestState(RequestState.OPEN);
        requestSolicitation.setCreationDate(new Date());

        RequestSolicitation createRequestSolicitation =
                requestSolicitationRepository.save(requestSolicitation);
        return createRequestSolicitation;
    }

    @Override
    public RequestSolicitation update(RequestSolicitation requestSolicitation) {
        RequestSolicitation updateRequestSolitation =
                requestSolicitationRepository.save(requestSolicitation);
        return updateRequestSolitation;
    }

    @Override
    public RequestSolicitation getById(Long id) {
        Optional<RequestSolicitation> optionalRequestSolicitation =
                requestSolicitationRepository.findById(id);
        return optionalRequestSolicitation.orElseThrow(
                () -> new NotFoundException("There are not request solicitation with id " + id));
    }

    @Override
    public List<RequestSolicitation> listAll() {
        List<RequestSolicitation> requestSolicitations = requestSolicitationRepository.findAll();
        return requestSolicitations;
    }

    @Override
    public List<RequestSolicitation> findAllByOwnerId(Long Id) {
        List<RequestSolicitation> requestSolicitations = requestSolicitationRepository.findAllByOwnerId(Id);
        return requestSolicitations;
    }
}
