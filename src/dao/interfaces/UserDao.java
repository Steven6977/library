package dao.interfaces;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserDao {
	public boolean existsAdmin(User user);
	public Map<String,String> getAccountInfo(User user);
	public List<User> queryUsers();
	public void save(User user);
	public void update(User user);
	public User queryById(int id);
	public void delete(int id);
	public User queryByAccount(String account);
	public User queryByAccountAndPwd(String account, String pwd);
	public boolean exist(String useraccount);
}
