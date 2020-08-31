package servlet;

import User.User;
import dao.UserDaoImpl.UserDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// 1. 设置request编码
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        UserDaoImpl userDao = new UserDaoImpl();
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        User user1 = userDao.user1(user);


        HttpSession session = req.getSession();
        String heckCode_session = (String) session.getAttribute("heckCode_session");
        System.out.println(heckCode_session);
        session.removeAttribute("heckCode_session");
        if(heckCode_session!=null &&heckCode_session.equalsIgnoreCase(checkCode))
        {
             if(user1.getName().equals(username)&&user1.getPassword().equals(password)){
               req.setAttribute("success",username);
               resp.sendRedirect(req.getContextPath()+"/success.jsp");
             }else {
                 req.setAttribute("login_error","用户名或者密码错误");
                 req.getRequestDispatcher(req.getContextPath()+"/longin.jsp").forward(req,resp);
             }

        }else
        {
req.setAttribute("cc_error","验证码错误");
req.getRequestDispatcher(req.getContextPath()+"/longin.jsp").forward(req,resp);
        }


    }
}
