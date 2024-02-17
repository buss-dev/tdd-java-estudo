package br.com.tddjava.tddjava.services;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.CourseInMemoryRepository;
import br.com.tddjava.tddjava.modules.courses.services.CreateCourseService;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateCourseServiceTest {

    @Test
    public void should_be_able_to_create_a_new_course() {
        // Criar um novo curso
        // Criar table curso (Entidade)
        // ID, description, name, workload
        Course course = new Course();
        course.setDescription("Curso_Description_Test");
        course.setName("Curso_Name");
        course.setWorkload(100);

        // Criar um novo service
        CreateCourseService createCourseService = new CreateCourseService(new CourseInMemoryRepository());
        Course createdCourse = createCourseService.execute(course);

        // Criar um repositório de curso

        assertNotNull(createdCourse.getId());

    }

    @Test(expected = Error.class)
    public void should_be_able_to_create_a_new_course_if_exists() {
        Course course = new Course();
        course.setDescription("Not_create_course");
        course.setName("Not_create_course");
        course.setWorkload(100);

        CreateCourseService createCourseService = new CreateCourseService(new CourseInMemoryRepository());
        createCourseService.execute(course);
        createCourseService.execute(course);

    }

}
