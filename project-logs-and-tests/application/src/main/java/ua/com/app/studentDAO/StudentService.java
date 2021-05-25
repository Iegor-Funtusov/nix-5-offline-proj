package ua.com.app.studentDAO;

import ua.com.lib.ArrayCrudService;
import ua.com.lib.ArrayImpl;

public class StudentService {
    private static final ArrayCrudService<Student> studentCrudService = new ArrayCrudService<>();

    public void createStudent(Student student) {
        studentCrudService.create(student);
    }

    public Student readStudent(String id) {
        return studentCrudService.read(id);
    }

    public void updateStudent(Student student) {
        studentCrudService.update(student);
    }

    public void deleteStudent(String id) {
        studentCrudService.delete(id);
    }

    public ArrayImpl readAllStudents() {
        return studentCrudService.readAll();
    }

}
