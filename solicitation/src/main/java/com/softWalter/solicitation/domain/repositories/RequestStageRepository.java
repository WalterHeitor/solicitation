package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestStageRepository extends JpaRepository<RequestStage, Long> {
}
