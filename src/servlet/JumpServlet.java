package servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JumpServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        String link = req.getParameter("link");
        String[] kind = link.split("-");
        StringBuffer sb = new StringBuffer();
        sb.append("/WEB-INF/");
        sb.append(kind[0]);
        sb.append("/");
        sb.append(link);
        sb.append(".jsp");
        RequestDispatcher rd = req.getRequestDispatcher(sb.toString());
        try {
            rd.forward(req, resp);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
