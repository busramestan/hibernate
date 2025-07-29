package com.busra.dao;

import com.busra.model.Student;
import com.busra.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentImpl implements StudentDao{


    @Override
    public Student save(Student student) {
        Session session  = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        try {
            session.persist(student);
            tx.commit();

        }catch (Exception e) {
            if (tx != null){
                tx.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null) session.close();
        }
        return student;
    }

    @Override
    public Student update(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(student);
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null) session.close();
        }

        return student;
    }

    @Override
    public Student delete(long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        try{
            Student student = session.get(Student.class, id);
            if(student != null){
                session.remove(student);
                transaction.commit();
            }
            return student;
        }catch (Exception e) {
            if (transaction != null){
                transaction.rollback();
            }
            throw new RuntimeException(e);
        }finally {
            if (session != null) session.close();
        }
    }
    @Override
    public Student getById(long id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            return session.get(Student.class, id);
        } catch (Exception e) {
            throw new RuntimeException("Öğrenci bulunamadı: " + id, e);
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public List<Student> getAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Student",Student.class).list();
        }

    }
}
