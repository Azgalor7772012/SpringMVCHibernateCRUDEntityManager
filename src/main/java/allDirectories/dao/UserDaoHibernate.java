package allDirectories.dao;

import allDirectories.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDaoHibernate implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernate(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> show() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("SELECT p from User p", User.class).getResultList();
        return users;
    }

    public void delete() {

    }

    public void add() {

    }

    public void update() {

    }
}
