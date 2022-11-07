package allDirectories.dao;

import allDirectories.models.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
public class UserDaoHibernate implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;


    public UserDaoHibernate(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<User> show() {
        return entityManager.createQuery("SELECT p from User p", User.class).getResultList();
    }

    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }


    public void add(User user) {
        entityManager.persist(user);
    }


    public void update(int id, User user) {
        User updatedUser = entityManager.find(User.class, id);
        updatedUser.setName(user.getName());
        updatedUser.setAge(user.getAge());

    }

    public User get(int id) {
        return  entityManager.find(User.class, id);

    }
}
