package org.pop.courseservice.dtos;


import lombok.*;
import org.pop.courseservice.enumerations.CourseField;
import org.pop.courseservice.enumerations.CourseState;
import org.pop.courseservice.enumerations.CourseType;
import org.pop.courseservice.enumerations.PricingType;

import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Builder
public class CourseDto {
    private String title;
    private String description;
    private CourseState courseStatus;
    private CourseType courseType;
    private PricingType pricingType;
    private Set<CourseField> fieldsOfStudy = new HashSet<>();
    private Set<ModuleDto> courseModules = new HashSet<>();
}
