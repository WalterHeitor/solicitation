package com.softWalter.solicitation.domain.enums;

public enum RequestState {

    OPEN("open order"),
    IN_PROGRESS("order in progress"),
    CLOSED("order closed");

    private String description;


    RequestState(String description) {
        this.description = description;
    }
}
