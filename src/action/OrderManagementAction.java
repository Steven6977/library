package action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.orm.hibernate3.HibernateOptimisticLockingFailureException;

import service.interfaces.OrderService;
import entity.Order;

public class OrderManagementAction {
    private OrderService orderSerivce;

    public void setOrderService(OrderService orderSerivce) {
        this.orderSerivce = orderSerivce;
    }

    public String execute() {
        HttpServletRequest req = ServletActionContext.getRequest();
        String operation = req.getParameter("operation");
        if (operation.equals("delete")) {
            int id = Integer.valueOf(req.getParameter("id"));
            orderSerivce.delete(id);
            return "delete";
        } else if (operation.equals("ret")) {
            int id = Integer.valueOf(req.getParameter("id"));
            Order order = orderSerivce.queryById(id);
            try {
                orderSerivce.returnBook(order);
            } catch (HibernateOptimisticLockingFailureException e) {
                req.setAttribute("orderretMessage", "乐观锁,有其他管理员正在还书");
                return "ret";
            }
            req.setAttribute("orderretMessage", "还书成功");
            return "ret";
        } else if (operation.equals("new")) {
            String useraccount = req.getParameter("useraccount");
            String[] bookIds = req.getParameterValues("bookIds");
            try {
                orderSerivce.add(useraccount, bookIds);
            } catch (Exception e) {
                req.setAttribute("orderNewMessage", "借阅事务出错");
                return "new";
            }
            req.setAttribute("orderNewMessage", "借阅添加成功");
            return "new";
        } else if (operation.equals("deleteall")) {
            orderSerivce.deleteAll();
            return "deleteall";
        }
        return "error";
    }

}
