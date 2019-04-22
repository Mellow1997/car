package servlet;

import entity.User;
import service.IUserServices;
import service.UserServicesImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("userName");
        String pwd = request.getParameter("userPwd");
        IUserServices ius = new UserServicesImpl();

        //查询用户名是否存在
        User user = new User(name, pwd);

        if(!ius.queryUserByUname(user)){

            if (ius.addUser(user)){
//                response.sendRedirect("res/registerSuccess.html");
//            request.getRequestDispatcher("res/registerSuccess.html").forward(request,response);
            }else{
                response.getWriter().write("false");
            }

        }else{
            response.getWriter().write("false");
        }



    }
}
