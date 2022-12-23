package com.softWalter.solicitation.domain.entities;

import com.softWalter.solicitation.domain.enums.RequestStage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_request_solicitation")
public class RequestSolicitation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String subject;
    private String description;
    private Date creationDate;
    private RequestStage requestStage;
    private User user;

    private List<com.softWalter.solicitation.domain.entities
            .RequestStage> requestStages = new ArrayList<>();
}
