package dao;

import entity.Student;

import java.util.ArrayList;

public interface StudentDAO {
    ArrayList<Student> all(); // select * from students
    Student findById(Integer id);
    Boolean create(Student s);// insert into ...
    Boolean update(Student s);// update students set....
    Boolean delete(Integer id); // delete from...
}