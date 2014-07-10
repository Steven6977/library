package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.aspectj.lang.JoinPoint;

import entity.Entity;
import entity.User;

public class AopClass {
    
    /**
     * 当update entity时添加审计字段update_date和updated_by
     * 
     * @param jp
     */
    public void doBeforeUpdate(JoinPoint jp) {
        Object args[] = jp.getArgs();
        if (args != null && args.length == 1) {
           if(args[0] instanceof Entity){
               HttpServletRequest req = ServletActionContext.getRequest();
               HttpSession session = req.getSession();
               User user = (User) session.getAttribute("user");
               Entity entity = (Entity)args[0];
               String updateDate = Util.getDate();
               entity.setUpdateddate(updateDate);
               entity.setUpdatedby(user.getUseraccount());
           }
        }
    }
    
    /**
     * 当save entity时添加审计字段create_date和created_by
     * 
     * @param jp
     */
    public void doBeforeSave(JoinPoint jp) {
        Object args[] = jp.getArgs();
        if (args != null && args.length == 1) {
           if(args[0] instanceof Entity){
               HttpServletRequest req = ServletActionContext.getRequest();
               HttpSession session = req.getSession();
               User user = (User) session.getAttribute("user");
               Entity entity = (Entity)args[0];
               String createDate = Util.getDate();
               entity.setCreateddate(createDate);
               entity.setCreatedby(user.getUseraccount());
           }
        }
    }
}
