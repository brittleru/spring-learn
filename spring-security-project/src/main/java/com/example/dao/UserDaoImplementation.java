package com.example.dao;

import com.example.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserDaoImplementation implements UserDao {

    // need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    @Transactional
    public User findByUserName(String userName) {
        // get curent hibernate session
        Session currentSession = sessionFactory.getCurrentSession();

        // retrieve/read form tha database using username
        Query<User> query = currentSession.createQuery("from User where userName=:uName", User.class);
        query.setParameter("uName", userName);

        User user = null;

        try {
            user = query.getSingleResult();
        }
        catch (Exception e) {
            user = null;
        }

        return user;
    }

    @Override
    @Transactional
    public void save(User user) {
        Session currentSession = sessionFactory.getCurrentSession();

        // create the user... finally...
        currentSession.saveOrUpdate(user);
    }
}
