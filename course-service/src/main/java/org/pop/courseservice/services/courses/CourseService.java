package org.pop.courseservice.services.courses;

import org.pop.courseservice.dtos.CourseDto;

import java.util.List;


public interface CourseService {
    CourseDto addCourse(CourseDto courseDto);
    List<CourseDto> getAllCourses();
    CourseDto getCourseById(Long oid);
    CourseDto updateCourseDescription(Long oid, CourseDto requestDto);
}
