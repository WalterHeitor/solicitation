package com.softWalter.solicitation.domain.usecases;

import com.softWalter.solicitation.domain.entities.RequestStage;

import java.util.List;

public interface UseCaseRequestStage {

    RequestStage save(RequestStage stage);
    RequestStage getById(Long id);
    List<RequestStage> findAllByRequestId(Long requestId);
}
