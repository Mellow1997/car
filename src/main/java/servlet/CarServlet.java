package servlet;

import entity.Car;
import net.sf.json.JSONArray;
import service.CarServicesImpl;
import service.ICarServices;
import utils.DbUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ICarServices cs = new CarServicesImpl();
        //获取排序方式
        String sort = request.getParameter("sort");
        List<Car> cars;
        JSONArray js;

        if ("desc".equals(sort)) {
            //按租金降序
            cars = cs.queryAllCarByRentDesc();
            js = JSONArray.fromObject(cars);
            response.getWriter().print(js);
        } else if ("asc".equals(sort)) {
            //按租金升序
            cars = cs.queryAllCarByRentAsc();
            js = JSONArray.fromObject(cars);
            response.getWriter().print(js);
        } else if ("default".equals(sort)) {
            //按cname排序
            cars = cs.queryAllCar();
            js = JSONArray.fromObject(cars);
            response.getWriter().print(js);
        } else {
            cars = cs.queryAllCar();
            request.getSession().setAttribute("cars", cars);
            response.sendRedirect("car.jsp");
        }

        }
}
