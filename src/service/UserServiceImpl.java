package service;

import java.util.List;
import java.util.Map;

import service.interfaces.UserService;
import util.Constants;
import dao.interfaces.UserDao;
import entity.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(){}
    
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public int verifyUser(User user) {

    	Map<String, String> result = userDao.getAccountInfo(user);
    	
    	if(result.isEmpty())
    		return -1;
       
        if( result.get("state").equals(String.valueOf(Constants.int_lock)))
        	return 0;        
 
        return user.getPassword().equals(result.get("password")) ? 1 : -1;

    }

    public List<User> queryUsers() {
        return userDao.queryUsers();
    }

    public void add(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public User queryById(int id) {
        return userDao.queryById(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public boolean exist(String useraccount) {
        return userDao.exist(useraccount);
    }

    public User queryByAccount(String useraccount) {
        return userDao.queryByAccount(useraccount);
    }

    @Override
    public boolean validatePwd(String oldpwd, User user) {
    	
    	Map<String, String> result = userDao.getAccountInfo(user);
    	if(result.isEmpty())
    		return false;
    	
    	return oldpwd.equals(result.get("password")) ? true : false;
    }

}
