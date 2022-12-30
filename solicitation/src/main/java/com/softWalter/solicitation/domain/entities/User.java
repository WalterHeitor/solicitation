package com.softWalter.solicitation.domain.entities;

import com.softWalter.solicitation.domain.enums.Role;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name = "tb_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 75, nullable = false)
    private String name;
    @Column(length = 75, nullable = false, unique = true)
    private String email;
    @Column(length = 100, nullable = false)
    private String password;
    @Column(length = 75, nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "owner")
    private List<RequestSolicitation> requests = new ArrayList<>();
    @OneToMany(mappedBy = "owner")
    private List<RequestStage> requestStages = new ArrayList<>();

}
