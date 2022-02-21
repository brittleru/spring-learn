package com.example.dao.user;

import com.example.entity.user.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Repository
public class UserDaoImplementation implements UserDao {

    private final static Logger logger = Logger.getLogger(UserDaoImplementation.class.getName());

    private EntityManager entityManager;

    @Autowired
    public UserDaoImplementation(@Qualifier("customUserDataSource") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public User findByUserName(String userName) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using username
        Query<User> query = currentSession.createQuery("from User where userName=:tempName", User.class);
        query.setParameter("tempName", userName);

        User user = null;

        try {
            user = query.getSingleResult();
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
        }

        return user;
    }

    @Override
    public void save(User user) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the user
        currentSession.saveOrUpdate(user);
    }
}
