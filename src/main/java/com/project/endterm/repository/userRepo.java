package com.project.endterm.repository;

import com.project.endterm.model.user;
import org.springframework.stereotype.Repository;
import javax.persistence.*;
import java.util.List;

@Repository
public class userRepo {

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;
    public boolean addNewUser(user newUser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(newUser);
            transaction.commit();
            return true;

        } catch (Exception e) {

            System.out.println(e.getMessage());
            transaction.rollback();
            return false;
        }
    }

    public List<user> getAllPosts() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<user> query = entityManager.createQuery("SELECT u from user u",user.class);
        List<user> result = query.getResultList();
        return result;
    }

    public void deleteUser(Integer userId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            user user = entityManager.find(user.class, userId);
            entityManager.remove(user);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }

    public void editUser(Integer userId) {

    }

    public void updateUser(user updateuser) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(updateuser);
            transaction.commit();

        } catch (Exception e) {
            System.out.println(e);
            transaction.rollback();
        }
    }
}