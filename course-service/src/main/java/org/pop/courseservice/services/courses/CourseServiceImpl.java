package org.pop.courseservice.services.courses;

import lombok.RequiredArgsConstructor;
import org.pop.courseservice.dtos.AssignmentDto;
import org.pop.courseservice.dtos.ModuleDto;
import org.pop.courseservice.dtos.CourseDto;
import org.pop.courseservice.entities.Assignment;
import org.pop.courseservice.entities.Course;
import org.pop.courseservice.entities.Module;
import org.pop.courseservice.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository coursesRepository;

    @Override
    public CourseDto addCourse(CourseDto courseDto) {
        Course newCourse = Course.builder()
                .title(courseDto.getTitle())
                .description(courseDto.getDescription())
                .courseType(courseDto.getCourseType())
                .pricingType(courseDto.getPricingType())
                .fieldsOfStudy(courseDto.getFieldsOfStudy())
                .courseStatus(courseDto.getCourseStatus())
                .build();
        newCourse.setCourseModules(createModules(courseDto.getCourseModules(), newCourse));
        coursesRepository.save(newCourse);
        return mapToCourseDto(newCourse);
    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courseList = coursesRepository.findAll();
        return courseList.stream()
                .map(this::mapToCourseDto)
                .toList();
    }

    @Override
    public CourseDto getCourseById(Long oid) {
        return mapToCourseDto(coursesRepository.findCoursesByOid(oid));
    }

    @Override
    public CourseDto updateCourseDescription(Long oid, CourseDto requestDto) {
        Course course = coursesRepository.findCoursesByOid(oid);
        course.setDescription(requestDto.getDescription());
        return mapToCourseDto(coursesRepository.save(course));
    }

    private CourseDto mapToCourseDto(Course newCourse) {
        return CourseDto.builder()
                .title(newCourse.getTitle())
                .description(newCourse.getDescription())
                .courseType(newCourse.getCourseType())
                .courseStatus(newCourse.getCourseStatus())
                .pricingType(newCourse.getPricingType())
                .fieldsOfStudy(newCourse.getFieldsOfStudy())
                .courseModules(mapModuleDtoSet(newCourse.getCourseModules())).build();
    }

    private Set<ModuleDto> mapModuleDtoSet(Set<Module> modules) {
        return modules.stream()
                .map(this::mapToModuleDto)
                .collect(Collectors.toSet());
    }

    private ModuleDto mapToModuleDto(Module module) {
        return ModuleDto.builder()
                .title(module.getTitle())
                .description(module.getDescription())
                .orderIndex(module.getOrderIndex())
                .moduleAssignments(mapAssignmentDtoSet(module.getModuleAssignments()))
                .build();
    }

    private Set<AssignmentDto> mapAssignmentDtoSet(Set<Assignment> assignments) {
        return assignments.stream()
                .map(this::mapToAssignmentDto)
                .collect(Collectors.toSet());
    }

    private AssignmentDto mapToAssignmentDto(Assignment assignment) {
        return AssignmentDto.builder()
                .title(assignment.getTitle())
                .description(assignment.getDescription())
                .status(assignment.getStatus())
                .grade(assignment.getGrade())
                .maxGrade(assignment.getMaxGrade())
                .minGrade(assignment.getMinGrade())
                .build();
    }

    private Set<Module> createModules(Set<ModuleDto> moduleDtos, Course course) {
        return moduleDtos.stream()
                .map(dto -> createModule(dto, course))
                .collect(Collectors.toSet());
    }

    private Module createModule(ModuleDto moduleDto, Course course) {
        Module module = new Module();
        module.setTitle(moduleDto.getTitle());
        module.setDescription(moduleDto.getDescription());
        module.setOrderIndex(module.getOrderIndex());
        module.setCourse(course);
        module.setModuleAssignments(createAssignments(moduleDto.getModuleAssignments(), module));
       return module;
    }

    private Set<Assignment> createAssignments(Set<AssignmentDto> assignmentDtos, Module module) {
        return assignmentDtos.stream()
                .map(dto -> createAssignment(dto, module))
                .collect(Collectors.toSet());
    }

    private Assignment createAssignment(AssignmentDto assignmentDto, Module module) {
        return Assignment.builder()
                .title(assignmentDto.getTitle())
                .description(assignmentDto.getDescription())
                .maxGrade(assignmentDto.getMaxGrade())
                .module(module)
                .build();

    }

}