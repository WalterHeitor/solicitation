package com.softWalter.solicitation.domain.repositories;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.RequestStage;
import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.template.RequestStageMockFactory;
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
    private UserRepository userRepository;
    private User user = UserMockFacktory.createNewUser();
    @Autowired
    private RequestSolicitationRepository requestSolicitationRepository;
    private List<RequestStage> requestStages = RequestStageMockFactory.createNewListStages();
    private List<RequestSolicitation> requestSolicitations = new ArrayList<RequestSolicitation>();




    @Test
    @Order(0)
    public void save_request_solicitation_test(){


        User userTest = userRepository.save(user);
        RequestSolicitation requestSolicitation =
                RequestSolicitationMockFactory.newRequestSolicitation(
                        userTest, requestStages);
        RequestSolicitation requestSolicitationTest = requestSolicitationRepository.save(requestSolicitation);

        assertThat(requestSolicitationTest.getId()).isEqualTo(1L);
    }
}