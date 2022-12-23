package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {

    List<RequestStage> findAllByRequestSolicitationId(Long requestId);

    @Query("UPDATE  RequestStage  SET requestState = ?2 WHERE id = ?1")
    RequestStage updateStatus(Long requestId, String requestState);
}
