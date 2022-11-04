package allDirectories.dao;

import allDirectories.models.User;

import java.util.List;

public interface UserDao {

    public List<User> show();

    public void delete();

    public void add();

    public void update();
}
