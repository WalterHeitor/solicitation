package com.softWalter.solicitation.domain.usecases.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageModel<T> {

    private Long totalElements;
    private int pageSize;
    private int totalPages;
    private List<T> elements;
}
