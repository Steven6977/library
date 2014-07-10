package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import service.interfaces.UserService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

public class LoginAction implements ModelDriven<User> {
    private User        user = new User();
    private UserService userService;

    public User getModel() {
        return user;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String execute() {
    	int iRet = userService.verifyUser(user);
        if (iRet > 0) {
            User u = userService.queryByAccount(user.getUseraccount());
            ActionContext.getContext().getSession().put("user", u);
            return "success";
        } else if(iRet == 0){
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("loginError", "账户被冻结！");
            return "error";
        }
        else {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("loginError", "用户名或密码错误!");
            return "error";
        }
    }

}
