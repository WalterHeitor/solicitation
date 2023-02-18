package com.softWalter.solicitation.presentations.execptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError implements Serializable {

    private int code;
    private String message;
    private Date date;
}
