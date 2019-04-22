package servlet;

import entity.Car;
import service.CarServicesImpl;
import service.ICarServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        ICarServices ics = new CarServicesImpl();
        Car car = ics.queryCarById(id);

        Calendar ca = Calendar.getInstance();
        Date time = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String takeTime = formatter.format(new Date());

        ca.add(Calendar.DATE,2);

        String getTime = formatter.format(ca.getTime());

        request.setAttribute("car",car);
        request.setAttribute("takeTime",takeTime);
        request.setAttribute("getTime",getTime);
        request.getRequestDispatcher("user-order.jsp").forward(request,response);
    }
}
