package com.example.dao.user;

import com.example.entity.user.Role;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.logging.Logger;

@Repository
public class RoleDaoImplementation implements RoleDao {

    private final static Logger logger =  Logger.getLogger(RoleDaoImplementation.class.getName());

    private EntityManager entityManager;

    @Autowired
    public RoleDaoImplementation(@Qualifier("customUserDataSource") EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Role findRoleByName(String roleName) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using name
        Query<Role> query = currentSession.createQuery("from Role where name=:roleName", Role.class);
        query.setParameter("roleName", roleName);

        Role role = null;

        try {
            role = query.getSingleResult();
        }
        catch (Exception e) {
            logger.warning(e.getMessage());
        }

        return role;
    }


}
