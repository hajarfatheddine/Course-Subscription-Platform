package org.pop.courseservice.dtos;

import lombok.*;
import org.pop.courseservice.enumerations.AssignmentStatus;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Builder
public class AssignmentDto {
    private String title;
    private String description;
    private AssignmentStatus status;
    private Integer grade;
    private Integer maxGrade;
    private Integer minGrade;
}
