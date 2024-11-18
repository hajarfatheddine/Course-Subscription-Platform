package org.pop.courseservice.controllers;

import lombok.RequiredArgsConstructor;
import org.pop.courseservice.dtos.CourseDto;
import org.pop.courseservice.enumerations.MessageCode;
import org.pop.courseservice.services.courses.CourseService;
import org.pop.courseservice.services.response.ResponseBody;
import org.pop.courseservice.services.response.ResponseBodyFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;
    private final ResponseBodyFactory<CourseDto> responseBodyFactory;
    private final ResponseBodyFactory<List<CourseDto>> listResponseBodyFactory;
    @PostMapping("/courses")
    public ResponseEntity<ResponseBody<CourseDto>> addCourse(@RequestBody CourseDto courseDto){
        CourseDto newCourse = courseService.addCourse(courseDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseBodyFactory.get(MessageCode.SUCCESSFUL_OPERATION, newCourse));
    }
    @GetMapping("/courses")
    public ResponseEntity<ResponseBody<List<CourseDto>>> getAllCourses(){
        List<CourseDto> courses = courseService.getAllCourses();
        return ResponseEntity.ok(listResponseBodyFactory.get(MessageCode.COURSES_LIST,courses));
    }
    @GetMapping("/courses/{oid}")
    public ResponseEntity<ResponseBody<CourseDto>> getCourseById(@PathVariable(name = "oid") Long oid){
        return ResponseEntity.ok(responseBodyFactory
                .get(MessageCode.COURSE_FOUND,courseService.getCourseById(oid)));
    }
    @PatchMapping("/courses/{oid}")
    public ResponseEntity<ResponseBody<CourseDto>> updateCourseStatus(
            @PathVariable(name = "oid")Long oid,
            @RequestBody CourseDto requestDto
    ){
        CourseDto courseDto = courseService.updateCourseStatus(oid,requestDto);
        return ResponseEntity.ok(responseBodyFactory.get(MessageCode.SUCCESSFUL_UPDATE,courseDto));
    }

    @DeleteMapping("/courses/{oid}")
    public ResponseEntity<ResponseBody<CourseDto>> deleteCourse(@PathVariable(name = "oid") Long oid){
        courseService.deleteCourse(oid);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(responseBodyFactory.get(MessageCode.SUCCESSFUL_DELETION,null));
    }
}
