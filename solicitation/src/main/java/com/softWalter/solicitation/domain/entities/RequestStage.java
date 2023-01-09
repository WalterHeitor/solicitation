package com.softWalter.solicitation.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_request_stage")
public class RequestStage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "realization_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date realizationDate;
    @Column(length = 75, nullable = false)
    @Enumerated(EnumType.STRING)
    private com.softWalter.solicitation.domain.enums
            .RequestStage requestStage;
    @ManyToOne
    @JoinColumn(name = "request_soliciation_id")
    private RequestSolicitation requestSolicitation;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private  User owner;
}
