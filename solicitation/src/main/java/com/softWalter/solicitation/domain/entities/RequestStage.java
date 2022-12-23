package com.softWalter.solicitation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_request_stage")
public class RequestStage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String description;
    private Date realizationDate;
    private com.softWalter.solicitation.domain.enums
            .RequestStage requestStage;
    private RequestSolicitation requestSolicitation;
    private  User user;
}
