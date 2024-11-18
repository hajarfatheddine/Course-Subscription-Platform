package org.pop.courseservice.dtos;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Builder
public class ModuleDto {
    private String title;
    private String description;
    private Integer orderIndex;
    private Set<AssignmentDto> moduleAssignments = new HashSet<>();
}
