package allDirectories.dao;

import allDirectories.models.User;
import java.util.List;

public interface UserDao {

     List<User> show();

     void delete(int id);

     void add(User user);

     void update(int id, User user);

     User get(int id);
}
