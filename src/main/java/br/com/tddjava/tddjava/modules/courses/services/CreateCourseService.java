package br.com.tddjava.tddjava.modules.courses.services;

import br.com.tddjava.tddjava.modules.courses.entities.Course;
import br.com.tddjava.tddjava.modules.courses.repositories.ICourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseService {

    private ICourseRepository repository;

    public CreateCourseService(ICourseRepository repository) {
        this.repository = repository;
    }

    public Course execute(Course course) {

        // Validar se o curso existe pelo nome
        Course existedCourse = repository.findByName(course.getName());

        // Se sim - retorna erro
        if (existedCourse != null) {
            throw new Error("Curso já existe!");
        }

        // Se não - retorna novo curso
        return repository.save(course);
    }
}
