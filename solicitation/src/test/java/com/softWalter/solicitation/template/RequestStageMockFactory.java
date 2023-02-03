package com.softWalter.solicitation.template;



import java.util.ArrayList;
import java.util.List;
import com.softWalter.solicitation.domain.entities.RequestStage;
public class RequestStageMockFactory {
    public static RequestStage createRequestStage() {
        RequestStage requestStage = new RequestStage();
        return requestStage;
    }
    public static List<RequestStage> createNewListStages() {
        List<RequestStage> stages = new ArrayList<RequestStage>();
        stages.add(RequestStage.builder().build());
        return stages;
    }
}
