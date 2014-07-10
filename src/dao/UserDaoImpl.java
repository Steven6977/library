package dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import dao.interfaces.UserDao;
import entity.User;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao {

    public static String HQL_QUERY_ADMIN      = "from User where name = ? and password = ? and type = 1";
    public static String HQL_QUERY_LOGIN        = "select password,state from User where useraccount = ?";
    public static String HQL_QUERY_USERS      = "from User";
    public static String HQL_QUERY_BY_ID      = "from User where id = ?";
    public static String HQL_DELETE_BY_ID     = "delete User where id = ?";
    public static String HQL_QUERY_BY_ACCOUNT = "from User where useraccount = ?";
    public static String HQL_LOGIN            = "from User where useraccount = ? and password = ? and type = 1";
    public static String HQL_QUERY_EXIST      = "from User where useraccount = ?";

    public boolean existsAdmin(User user) {
        String[] para = new String[] { String.valueOf(user.getId()), user.getPassword() };
        List<User> list = this.getHibernateTemplate().find(HQL_QUERY_ADMIN, para);
        if (list.size() == 0)
            return false;
        else
            return true;
    }

    @SuppressWarnings("unchecked")
	public Map<String, String> getAccountInfo(User user) {
		List<Object[]> result = this.getHibernateTemplate().find(
				HQL_QUERY_LOGIN, user.getUseraccount());
		Map<String, String> ret = new HashMap<String, String>();

		if (result.size() > 0) {
			ret.put("password", (String) result.get(0)[0]);
			ret.put("state", String.valueOf(result.get(0)[1]));
		}
		return ret;

	}

    public List<User> queryUsers() {
        List<User> list = this.getHibernateTemplate().find(HQL_QUERY_USERS);
        return list;
    }

    public void save(User user) {
        this.getHibernateTemplate().save(user);
    }

    public void update(User user) {
        String hql = "update User set name = '" + user.getName() + "', password = '"
                     + user.getPassword() + "', email = '" + user.getEmail() + "', type = '"
                     + user.getType() + "', state = '" + user.getState() + "' where id = ?";
        this.getHibernateTemplate().merge(user);
    }

    public User queryById(int id) {
        List<User> list = this.getHibernateTemplate().find(HQL_QUERY_BY_ID, id);
        return list.size() > 0 ? list.get(0) : null;
    }

    public void delete(int id) {
        this.getHibernateTemplate().bulkUpdate(HQL_DELETE_BY_ID, id);
    }

    public User queryByAccount(String account) {
    	//this.getSession().createQuery("from User");
        List<User> list = this.getHibernateTemplate().find(HQL_QUERY_BY_ACCOUNT, account);
        return list.size() > 0 ? list.get(0) : null;
    }

    public User queryByAccountAndPwd(String account, String pwd) {
        Object[] para = new Object[] { account, pwd };
        List<User> list = this.getHibernateTemplate().find(HQL_LOGIN, para);
        return list.size() > 0 ? list.get(0) : null;
    }

    public boolean exist(String useraccount) {
        List<User> list = this.getHibernateTemplate().find(HQL_QUERY_EXIST, useraccount);
        return list.size() > 0 ? true : false;
    }

}
