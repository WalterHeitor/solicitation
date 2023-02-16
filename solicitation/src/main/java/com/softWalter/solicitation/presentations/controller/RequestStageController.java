package com.softWalter.solicitation.presentations.controller;

import com.softWalter.solicitation.domain.entities.RequestStage;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestSolicitation;
import com.softWalter.solicitation.domain.usecases.UseCaseRequestStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "softwalter/v1/request-stages")
public class RequestStageController {

    @Autowired
    private UseCaseRequestStage useCaseRequestStage;

    @PostMapping
    public ResponseEntity<RequestStage> save(@RequestBody RequestStage requestStage) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(useCaseRequestStage.save(requestStage));
    }

    @GetMapping("/{id}")
    public ResponseEntity<RequestStage> getById(Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(useCaseRequestStage.getById(id));
    }
}
