package servlet;

import entity.Car;
import net.sf.json.JSONArray;
import service.CarServicesImpl;
import service.ICarServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CarSearchServlet")
public class CarSearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String str = request.getParameter("str");
        ICarServices ics = new CarServicesImpl();

        List<Car> cars = ics.fuzzyQueryByCar(str);
        JSONArray js = JSONArray.fromObject(cars);
        System.out.println(cars);

        if(cars!=null){
            System.out.println(js);
            response.getWriter().print(js);
        }else{
            response.getWriter().print("false");
        }
    }
}
