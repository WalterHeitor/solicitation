package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.RequestStage;
import com.softWalter.solicitation.domain.enums.RequestState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestSolicitationRepository extends JpaRepository<RequestSolicitation, Long> {

    List<RequestSolicitation> findAllByOwnerId(Long Id);

//    @Transactional(readOnly = false)
//    @Modifying
    @Query("UPDATE RequestSolicitation SET requestStage = ?2 WHERE id = ?1")
    RequestSolicitation updateStatus(Long id, RequestState requestState);
}
