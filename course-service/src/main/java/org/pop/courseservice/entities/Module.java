package org.pop.courseservice.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "MODULES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String title;
    private String description;
    @Column(name = "order_index")
    private Integer orderIndex;
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    private Set<Assignment> moduleAssignments = new HashSet<>();

}
