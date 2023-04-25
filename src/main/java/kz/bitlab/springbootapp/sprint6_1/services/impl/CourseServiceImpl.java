package kz.bitlab.springbootapp.sprint6_1.services.impl;

import kz.bitlab.springbootapp.sprint6_1.models.Course;
import kz.bitlab.springbootapp.sprint6_1.repositories.CourseRepository;
import kz.bitlab.springbootapp.sprint6_1.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Override
    public List<Course> getAll() {
        return courseRepository.findAll();
    }
}
