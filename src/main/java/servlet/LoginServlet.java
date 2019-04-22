package servlet;

import entity.User;
import service.UserServicesImpl;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("conName");
        String pwd = request.getParameter("conPwd");

        User user = new User(uname,pwd);
        UserServicesImpl usi = new UserServicesImpl();
        if (usi.UserLogin(user)){
            request.getSession().setAttribute("user",user);
            response.sendRedirect("CarServlet");
        }else{
            PrintWriter writer = response.getWriter();
//            response.sendRedirect("index.html");
            writer.print("<script>alert('登陆失败！');window.location.href='index.html';</script>");
        }
    }
}
