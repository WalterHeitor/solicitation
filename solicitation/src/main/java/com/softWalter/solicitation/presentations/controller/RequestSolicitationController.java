package com.softWalter.solicitation.presentations.controller;

import com.softWalter.solicitation.domain.entities.RequestSolicitation;
import com.softWalter.solicitation.domain.entities.RequestStage;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestSolicitation;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "softwalter/v1/solicitation")
public class RequestSolicitationController {

    @Autowired
    private UseCaseRequestSolicitation useCaseRequestSolicitation;
    @Autowired
    private UseCaseRequestStage useCaseRequestStage;

    @PostMapping
    public ResponseEntity<RequestSolicitation> save(
            @RequestBody RequestSolicitation requestSolicitation) {
        RequestSolicitation createRequest =
                useCaseRequestSolicitation.save(requestSolicitation);

        return ResponseEntity.status(HttpStatus.CREATED).body(createRequest);
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<RequestSolicitation> update(
            @PathVariable(name = "id") Long id,
            @RequestBody RequestSolicitation requestSolicitation) {
        requestSolicitation.setId(id);
        RequestSolicitation updateSolicit =
                useCaseRequestSolicitation.update(requestSolicitation);
        return ResponseEntity.status(HttpStatus.OK).body(updateSolicit);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<RequestSolicitation> getById(
            @PathVariable(name = "id") Long id) {
        RequestSolicitation requestSolicitation =
                useCaseRequestSolicitation.getById(id);

        return ResponseEntity.status(HttpStatus.OK).body(requestSolicitation);
    }

    @GetMapping
    public ResponseEntity <List<RequestSolicitation>> findAll(){
        List<RequestSolicitation> requestSolicitations =
                useCaseRequestSolicitation.listAll();
        return ResponseEntity.status(HttpStatus.OK).body(requestSolicitations);
    }

    @GetMapping("/{id}/request-stages")
    public ResponseEntity<List<RequestStage>> listAllStagesById(
            @PathVariable(name="id") Long id) {
        List<RequestStage> useCaseRequestStageAllByRequestId =
                useCaseRequestStage.findAllByRequestId(id);
        return ResponseEntity.ok(useCaseRequestStageAllByRequestId);
    }
}
