package org.pop.courseservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.pop.courseservice.enumerations.AssignmentStatus;


@Entity
@Table(name = "ASSIGNMENTS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Builder
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String title;
    private String description;
    private AssignmentStatus status;
    private Integer grade;
    private Integer maxGrade;
    private Integer minGrade;
    @ManyToOne
    private Module module;

}
