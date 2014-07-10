package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import service.interfaces.UserService;
import util.Constants;

import com.opensymphony.xwork2.ActionContext;

import entity.User;

public class UserManagementAction {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    private User user;

    public User getUser() {
        return user;
    }

    public String execute() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String operation = req.getParameter("operation");
        if (operation.equals("new")) {
            String name = req.getParameter("name");
            String useraccount = req.getParameter("useraccount");
            String pwd = req.getParameter("password");
            String email = req.getParameter("email");
            String string_type = req.getParameter("type");
            int type = Integer.parseInt(string_type);
            User user = new User(name, pwd, email, type);
            user.setUseraccount(useraccount);
            userService.add(user);
            req.setAttribute("userNewMessage", "用户添加成功");
            return "add";
        } else if (operation.equals("active")) {
            String id = req.getParameter("id");
            User user = userService.queryById(Integer.valueOf(id));
            if (user != null) {
                user.setState(Constants.int_active);
                userService.update(user);
            }
            return "active";
        } else if (operation.equals("lock")) {
            String id = req.getParameter("id");
            User user = userService.queryById(Integer.valueOf(id));
            if (user != null) {
                user.setState(Constants.int_lock);
                userService.update(user);
            }
            return "lock";
        } else if (operation.equals("delete")) {
            int id = Integer.valueOf(req.getParameter("id"));
            userService.delete(id);
            return "delete";
        } else if (operation.equals("password")) {
            String pwd = req.getParameter("newpassword");
            User user = (User) ActionContext.getContext().getSession().get("user");
            user.setPassword(pwd);
            userService.update(user);
            req.setAttribute("tipMessage", "密码修改成功");
            return "password";
        } else if (operation.equals("edit")) {
            int id = Integer.valueOf(req.getParameter("id"));
            user = userService.queryById(id);
            return "edit";
        } else if (operation.equals("save")) {
            int id = Integer.valueOf(req.getParameter("id"));
            user = userService.queryById(id);
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String string_type = req.getParameter("type");
            int type = Integer.parseInt(string_type);
            user.setName(name);
            user.setEmail(email);
            user.setType(type);
            try {
                userService.update(user);
            } catch (HibernateOptimisticLockingFailureException e) {
                req.setAttribute("userEditMessage", "乐观锁,有其他管理员正在修改");
                return "edit";
            }
            req.setAttribute("userEditMessage", "资料修改成功");
            return "save";
        }
        return "error";
    }
}
