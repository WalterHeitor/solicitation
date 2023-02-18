package com.softWalter.solicitation.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.softWalter.solicitation.domain.enums.RequestState;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
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
    @Column(length = 75, nullable = false)
    private String subject;
    @Column(columnDefinition = "text")
    private String description;
    @Column(name = "creation_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Column(length = 75, nullable = false)
    //@Enumerated(EnumType.STRING)
    private RequestState requestState;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;
    @Getter(onMethod = @__({@JsonIgnore}))
    @OneToMany(mappedBy = "requestSolicitation", fetch = FetchType.LAZY)
    private List<RequestStage> requestStages = new ArrayList<>();
}
