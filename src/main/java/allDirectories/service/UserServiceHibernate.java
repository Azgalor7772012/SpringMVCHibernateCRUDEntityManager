package allDirectories.service;

import allDirectories.dao.UserDao;
import allDirectories.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceHibernate implements UserService {


    private final UserDao userDao;

    @Autowired
    public UserServiceHibernate(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> show() {
      return userDao.show();
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    @Override
    public void update(int id, User user) {
        userDao.update(id, user);
    }

    @Transactional(readOnly = true)
    @Override
    public User get(int id) {
       return userDao.get(id);
    }
}
