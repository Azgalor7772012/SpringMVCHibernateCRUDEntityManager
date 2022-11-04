package allDirectories.dao;

import allDirectories.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

    //    @Transactional Почему-то с транзакшионал не работает. Почему?
    public List<User> show() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createQuery("SELECT p from User p", User.class).getResultList();
        session.getTransaction().commit();
        return users;
    }

    public void delete(int id) {
        Transaction tx = null;
        try(Session session = sessionFactory.openSession()) {
            tx = session.beginTransaction();
            User user = session.get(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch(Exception e) {
            if(tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }


    public void add(User user) {
        Transaction tx = null;
       try(Session session = sessionFactory.openSession()) {
           tx = session.beginTransaction();
           session.save(user);

           session.getTransaction().commit();
       } catch (Exception e) {
           if(tx != null) {
               tx.rollback();
           }
           e.printStackTrace();
       }


    }

    public void update(int id, User user) {
        Transaction tx = null;
        try (Session session = sessionFactory.openSession()) {

            tx = session.beginTransaction();
            User user1 = session.get(User.class, id);
            user1.setAge(user.getAge());
            user1.setName(user.getName());
            session.getTransaction().commit();
        } catch (Exception e) {
            if(tx != null) {
                tx.rollback();
            }
        }


    }

    @Override
    public User get(int id) {
        Session session = sessionFactory.openSession();
        return session.get(User.class, id);


    }
}
