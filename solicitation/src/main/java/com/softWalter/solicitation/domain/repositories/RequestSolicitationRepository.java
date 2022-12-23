package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestSolicitationRepository extends JpaRepository<RequestSolicitation, Long> {

    List<RequestSolicitation> findAllByOwnerId(Long Id);
}
