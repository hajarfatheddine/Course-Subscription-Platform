package org.pop.courseservice.services.courses;

import org.pop.courseservice.dtos.CourseDto;
import org.pop.courseservice.exceptions.BusinessException;

import java.util.List;


public interface CourseService {
    CourseDto addCourse(CourseDto courseDto) throws BusinessException;
    List<CourseDto> getAllCourses();
    CourseDto getCourseById(Long oid);
    CourseDto updateCourseStatus(Long oid, CourseDto requestDto);
    void deleteCourse(Long oid);
}
