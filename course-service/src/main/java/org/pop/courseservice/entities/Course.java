package org.pop.courseservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.pop.courseservice.enumerations.CourseField;
import org.pop.courseservice.enumerations.CourseState;
import org.pop.courseservice.enumerations.PricingType;
import org.pop.courseservice.enumerations.CourseType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name = "COURSES")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Generated
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long oid;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private CourseState courseStatus;

    @Enumerated(EnumType.STRING)
    private CourseType courseType;

    @Enumerated(EnumType.STRING)
    private PricingType pricingType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "course_fields_of_study",
            joinColumns = @JoinColumn(name = "course_id")
    )
    @Column(name = "field_of_study")
    @Enumerated(EnumType.STRING)
    private Set<CourseField> fieldsOfStudy;

   @OneToMany(mappedBy = "course", cascade = CascadeType.ALL,orphanRemoval = true)
    @OrderBy("orderIndex")
    private Set<Module> courseModules = new HashSet<>();

    @Column(nullable = false)
    private Date createdAt;
    private Date updatedAt;
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
