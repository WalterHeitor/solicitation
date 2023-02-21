package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestStage;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest()
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RequestStageRepositoryTest {

    RequestStage requestStage = new RequestStage();

    @Test
    void findAllByRequestSolicitationId() {
    }

    @Test
    void updateStatus() {
    }
}