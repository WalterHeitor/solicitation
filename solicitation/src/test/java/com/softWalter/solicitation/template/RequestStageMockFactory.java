package com.softWalter.solicitation.template;

import com.softWalter.solicitation.domain.entities.RequestStage;

import java.util.ArrayList;
import java.util.List;

public class RequestStageMockFactory {
    public static RequestStage createRequestStage() {
        RequestStage requestStage = new RequestStage();
    }
    public static List<RequestStage> createNewListStages() {
        List<RequestStage> stages = new ArrayList<RequestStage>();
        stages.add(RequestStage.builder().build());
    }
}
