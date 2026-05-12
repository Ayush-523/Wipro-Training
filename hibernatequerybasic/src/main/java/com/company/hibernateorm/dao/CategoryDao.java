package com.company.hibernateorm.dao;

import com.company.hibernateorm.config.HibernateUtil;
import com.company.hibernateorm.entity.Category;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CategoryDao {

    public void saveCategory(Category category) {

        Session session =
                HibernateUtil.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.persist(category);

        tx.commit();

        session.close();
    }
}