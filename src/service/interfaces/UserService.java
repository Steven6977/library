package service.interfaces;

import java.util.List;

import entity.User;

public interface UserService {
    public int verifyUser(User user);

    public List<User> queryUsers();

    public void add(User user);

    public void update(User user);

    public User queryById(int id);

    public void delete(int id);

    public boolean exist(String useraccount);

    public User queryByAccount(String useraccount);

    public boolean validatePwd(String password, User user);
}
