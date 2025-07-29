package com.busra;

import com.busra.dao.StudentImpl;
import com.busra.model.Student;
import com.busra.service.StudentService;
import com.busra.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentImpl studentImpl = new StudentImpl();
        StudentService studentService = new StudentService(studentImpl);

        Student newStudent = new Student("Student3","mail23@mail.com");

        try {
            //Create a new student
            Student savedStudent = studentService.saveStudent(newStudent);
            System.out.println("Öğrenci başarıyla kaydedildi: " + savedStudent.getName() + ", Email: " + savedStudent.getEmail());
        } catch (Exception e) {
            System.out.println("Öğrenci kaydedilemedi" + e.getMessage());
        }

        try{
            //Get all students
            List<Student> studentList = studentService.getAllStudents();
            for(Student student : studentList){
                System.out.println(student.getId() + " - "  +student.getName() + " - " + student.getEmail());
            }
        }catch (Exception e){
            System.out.println("Öğrenciler alınamadı: " + e.getMessage());
        }
//
        //update a student
        try {
            Student studentToUpdate = studentService.getByIdStudent(1);
            studentToUpdate.setName("Büşra Güncel");
            studentToUpdate.setEmail("busra.guncel@mail.com");

            Student updatedStudent = studentService.updateStudent(studentToUpdate);

            System.out.println("Güncellenen öğrenci: " + updatedStudent.getName());

        } catch (RuntimeException e) {
            System.out.println("Güncelleme hatası: " + e.getMessage());
        }

        try{
            //Delete a studemt
            Student deletedStudent = studentService.deleteStudent(1);
            System.out.println("Öğrenci başarıyla silindi: " + deletedStudent.getName());
        } catch (Exception e) {
            throw new RuntimeException("Öğrenci silme işlemi başarısız: " +e.getMessage());
        }



        // Hibernate session açıyoruz
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction tx = null;

//        try {
            // 1. CREATE - Yeni öğrenci ekleme
//            tx = session.beginTransaction();
//            Student student = new Student();
//            student.setName("Mestan1");
//            student.setEmail("mestan@gmail..com");
//            session.persist(student);
//            tx.commit();
//            System.out.println("Öğrenci başarıyla eklendi: " + student);

            // 2. READ - Tek bir öğrenci okuma
//            tx = session.beginTransaction();
//            Student foundStudent = session.get(Student.class, student.getId());
//            if (foundStudent != null) {
//                System.out.println("Okunan öğrenci: " + foundStudent);
//            }
//            tx.commit();

            // 3. READ - Tüm öğrencileri listeleme
//            tx = session.beginTransaction();
//            List<Student> students = session.createQuery("FROM Student", Student.class).list();
//            System.out.println("Tüm öğrenciler:");
//            for (Student st : students) {
//                System.out.println(st);
//            }
//            tx.commit();

//            // 4. UPDATE - Öğrenci bilgisi güncelleme
//            tx = session.beginTransaction();
//            Student studentToUpdate = session.get(Student.class, student.getId());
//            if (studentToUpdate != null) {
//                studentToUpdate.setName("Kübra");
//                // session.update(studentToUpdate); // Opsiyonel, Hibernate dirty checking yapar
//         }
//            tx.commit();
//            System.out.println("Öğrenci güncellendi: " + studentToUpdate);

            // 5. DELETE - Öğrenciyi silme
//            tx = session.beginTransaction();
//            Student studentToDelete = session.get(Student.class, student.getId());
//            if (studentToDelete != null) {
//                session.delete(studentToDelete);
//            }
//            tx.commit();
//            System.out.println("Öğrenci silindi: " + studentToDelete);

//        } catch (Exception e) {
//            if (tx != null) tx.rollback();
//            e.printStackTrace();
//
//        } finally {
//            session.close();
//            HibernateUtil.shutdown();
//        }
    }
}
