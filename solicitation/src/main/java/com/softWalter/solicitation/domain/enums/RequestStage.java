package com.softWalter.solicitation.domain.enums;

public enum RequestStage {

    OPEN("open order"),
    IN_PROGRESS("order in progress"),
    CLOSED("order closed");

    private String description;


    RequestStage(String description) {
        this.description = description;
    }
}
