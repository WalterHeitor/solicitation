package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.template.requestsolicitation.RequestSolicitationMockFactory;
import com.softWalter.solicitation.template.user.UserMockFacktory;
import lombok.val;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class RequestSolicitationRepositoryTest {

    @Autowired
    private RequestSolicitationRepository requestSolicitationRepository;
    private List<RequestSolicitation> requestSolicitations = new ArrayList<RequestSolicitation>();

    private RequestSolicitation requestSolicitation =
            RequestSolicitationMockFactory.newRequestSolicitation(UserMockFacktory.createNewUser(), requestSolicitations);


    @Test
    @Order(0)
    public void save_user_test(){

        RequestSolicitation requestSolicitationTest = requestSolicitationRepository.save(requestSolicitation);
        assertThat(requestSolicitationTest.getId()).isEqualTo(1L);
    }
}