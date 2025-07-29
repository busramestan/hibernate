package com.busra.service;

import com.busra.dao.StudentDao;
import com.busra.model.Student;

import java.util.List;

public class StudentService {
    // Service katmanı, DAO katmanını kullanarak iş mantığını uygular.
    // Örneğin, öğrenci ekleme, güncelleme, silme gibi işlemleri burada yapabilirsiniz.


    private final StudentDao studentDao;

    public StudentService (StudentDao studentDao){
        this.studentDao = studentDao;
    }

    public Student saveStudent(Student student) {
        if (student == null || student.getName() == null || student.getEmail()== null){
            throw new IllegalArgumentException("Öğrenci bilgileri eksik veya hatalı");
        }
        return studentDao.save(student);
    }

    public Student updateStudent (Student updateStudent){
        if(updateStudent == null || updateStudent.getId() == 0){
            throw new IllegalArgumentException("Güncellenecek öğrenci bilgileri eksik veya hatalı");
        }
        Student existingStudent = studentDao.getById(updateStudent.getId());

        existingStudent.setName(updateStudent.getName());
        existingStudent.setEmail(updateStudent.getEmail());

        return studentDao.update(existingStudent);
    }

    public Student deleteStudent(long id){
        Student student = studentDao.delete(id);
        if( student == null){
            throw new RuntimeException("Silinicek öğrenci bulunamadı: " +id);
        }
        return student;
    }

    public Student getByIdStudent(long id){
        Student student =  studentDao.getById(id);
        if(student == null){
            throw new RuntimeException("Öğrenci bulunamadı: " + id);
        }
        return student;
    }

    public List<Student> getAllStudents(){
        return studentDao.getAll();
    }
}
