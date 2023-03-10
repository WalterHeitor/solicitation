package com.softWalter.solicitation.domain.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class PageRequestModel {
    private int page;
    private int size;
}
