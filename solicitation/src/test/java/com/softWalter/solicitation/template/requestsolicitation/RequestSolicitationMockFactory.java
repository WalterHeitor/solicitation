package com.softWalter.solicitation.template.requestsolicitation;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.User;
import com.softWalter.solicitation.domain.enums.RequestStage;

import java.util.Date;
import java.util.List;

public class RequestSolicitationMockFactory {
    public static RequestSolicitation newRequestSolicitation(
            User user,
            List<com.softWalter.solicitation.domain.entities.RequestStage> stages) {
        return new RequestSolicitation(1L,"", "", new Date(), RequestStage.OPEN, user, stages);
    }
}
