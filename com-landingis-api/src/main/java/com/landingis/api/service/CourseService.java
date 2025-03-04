package com.landingis.api.service;

import com.landingis.api.dto.course.CourseAcademicReportDto;
import com.landingis.api.dto.course.CourseDto;
import com.landingis.api.model.criteria.CourseCriteria;
import com.landingis.api.dto.PaginationDto;
import com.landingis.api.form.course.CourseCreateForm;
import com.landingis.api.form.course.CourseUpdateForm;
import com.landingis.api.model.entity.Course;
import com.landingis.api.projection.CourseAcademicReportProjection;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    PaginationDto<CourseDto> getCoursesPagination(CourseCriteria courseCriteria, Pageable pageable);
    CourseDto getOne(Long id);
    CourseDto create(CourseCreateForm request);
    CourseDto update(CourseUpdateForm request);
    void delete(Long id);
    void deleteWithDataSource(Long id);
    Course findCourseById(Long id);
    CourseAcademicReportDto getAcademicReport();
    CourseAcademicReportProjection getAcademicReportProjection();
}
