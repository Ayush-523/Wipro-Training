package com.company.hibernateorm.dao;

import com.company.hibernateorm.config.HibernateUtil;
import com.company.hibernateorm.entity.Product;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ProductDao {

    // Save Product

    public void saveProduct(Product product) {

        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        Transaction tx =
                session.beginTransaction();

        session.persist(product);

        tx.commit();

        session.close();
    }

    public List<Product> getAllProducts() {

        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        String hql =
                "from Product";

        Query<Product> query =
                session.createQuery(hql, Product.class);

        List<Product> products =
                query.list();

        session.close();

        return products;
    }

    public List<Product> getProductsGreaterThan(double price) {

        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        String hql =
                "from Product where price > :p";

        Query<Product> query =
                session.createQuery(hql, Product.class);

        query.setParameter("p", price);

        List<Product> products =
                query.list();

        session.close();

        return products;
    }

    public List<Product> getProductsUsingCriteria() {

        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        CriteriaBuilder cb =
                session.getCriteriaBuilder();

        CriteriaQuery<Product> cq =
                cb.createQuery(Product.class);

        Root<Product> root =
                cq.from(Product.class);

        cq.select(root);

        Query<Product> query =
                session.createQuery(cq);

        List<Product> products =
                query.list();

        session.close();

        return products;
    }
    public List<Product> getProductsUsingNativeQuery() {

        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        String sql =
                "select * from product";

        NativeQuery<Product> query =
                session.createNativeQuery(
                        sql,
                        Product.class
                );

        List<Product> products =
                query.list();

        session.close();

        return products;
    }

    public Double getMaximumPrice() {

        Session session =
                HibernateUtil
                        .getSessionFactory()
                        .openSession();

        String hql =
                "select max(price) from Product";

        Query<Double> query =
                session.createQuery(hql, Double.class);

        Double maxPrice =
                query.uniqueResult();

        session.close();

        return maxPrice;
    }
}