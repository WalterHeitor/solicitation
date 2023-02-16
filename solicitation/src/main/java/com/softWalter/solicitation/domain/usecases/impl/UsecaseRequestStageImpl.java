package com.softWalter.solicitation.domain.usecases.impl;

import com.softWalter.solicitation.domain.entities.RequestStage;
import com.softWalter.solicitation.domain.enums.RequestState;
import com.softWalter.solicitation.domain.repositories.RequestSolicitationRepository;
import com.softWalter.solicitation.domain.repositories.RequestStageRepository;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class UsecaseRequestStageImpl implements UseCaseRequestStage {

    @Autowired
    private RequestStageRepository requestStageRepository;
    @Autowired
    private RequestSolicitationRepository requestSolicitationRepository;

    @Override
    public RequestStage save(RequestStage stage) {

        stage.setRealizationDate(new Date());
        RequestStage createStage = requestStageRepository.save(stage);

        Long requestSolicitatinId =
                stage.getRequestSolicitation().getId();
        RequestState state =
                stage.getRequestState();
        requestSolicitationRepository.updateStatus(requestSolicitatinId, state);

        return createStage;
    }

    @Override
    public RequestStage getById(Long id) {
        Optional<RequestStage> optionalRequestStage =
                requestStageRepository.findById(id);
        return optionalRequestStage.get();
    }

    @Override
    public List<RequestStage> findAllByRequestId(Long requestId) {
        List<RequestStage> requestStages = requestStageRepository.findAllByRequestSolicitationId(requestId);
        return requestStages;
    }


}
