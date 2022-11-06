package allDirectories.service;

import allDirectories.dao.UserDao;
import allDirectories.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceHibernate implements UserService {

    @Autowired
    UserDao userDao;


    @Override
    public List<User> show() {
      return userDao.show();
    }

    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Override
    public User get(int id) {
       return userDao.get(id);
    }
}
