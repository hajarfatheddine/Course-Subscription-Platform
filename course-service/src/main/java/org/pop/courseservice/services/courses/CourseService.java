package org.pop.courseservice.services.courses;

import org.pop.courseservice.dtos.CourseDto;
import org.pop.courseservice.exceptions.BusinessException;

import java.util.List;


public interface CourseService {
    CourseDto addCourse(CourseDto courseDto) throws BusinessException;
    List<CourseDto> getAllCourses() throws BusinessException;
    CourseDto getCourseById(Long oid) throws BusinessException;
    CourseDto updateCourseStatus(Long oid, CourseDto requestDto) throws BusinessException;
    void deleteCourse(Long oid) throws BusinessException;
}
