package com.busra.dao;

import com.busra.model.Student;

import java.util.List;

public interface StudentDao {
    Student save(Student student);
    Student update(Student user);
    Student delete(long id);
    Student getById(long id);
    List<Student> getAll();

}
