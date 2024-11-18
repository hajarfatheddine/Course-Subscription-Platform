package org.pop.courseservice.repositories;

import org.pop.courseservice.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCoursesByOid(Long oid);
}
