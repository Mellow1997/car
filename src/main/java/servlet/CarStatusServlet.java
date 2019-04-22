package servlet;

import service.CarServicesImpl;
import service.ICarServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CarStatusServlet")
public class CarStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //返回 操作 指示
        String msg = request.getParameter("msg");

        ICarServices ics = new CarServicesImpl();

        if ("put".equals(msg)) {
            ics.changeCarStatus(id, 1);
        } else {
            ics.changeCarStatus(id, -1);
        }


    }
}
