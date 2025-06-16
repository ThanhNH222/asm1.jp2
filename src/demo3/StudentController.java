package demo3;

import dao.RepositoryDAO;
import dao.StudentDAOImpl;
import entity.Student;

public class StudentController {
    private RepositoryDAO<Student, Integer> studentDAO = new StudentDAOImpl();

    public Student findStudent(int id) {
        return studentDAO.findById(id);
    }

    public boolean updateStudent(Student s) {
        return studentDAO.update(s);
    }

    public boolean deleteStudent(int id) {
        return studentDAO.delete(id);
    }
}
