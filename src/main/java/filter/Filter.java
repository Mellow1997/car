package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Filter", urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest newReq = (HttpServletRequest) req;
        HttpServletResponse newResp = (HttpServletResponse) resp;
//        newReq.setCharacterEncoding("utf-8");
//        newResp.setCharacterEncoding("utf-8");
//        newResp.setContentType("text/html;charset=UTF-8");
//        chain.doFilter(newReq, newResp);

        newReq.setCharacterEncoding("utf-8");
        newResp.setCharacterEncoding("utf-8");
        newResp.setContentType("text/html;charset=UTF-8");

        String spath = newReq.getServletPath();

        String[] urls = {"car.jsp","order-order.jsp"};
        boolean flag = false;
        for (String str : urls) {
            if (spath.indexOf(str) != -1) {
                flag = true;
                break;
            }
        }
        System.out.println(spath);

        if (flag) {
            System.out.println("false");
            if(newReq.getSession().getAttribute("user") == null){
                System.out.println("非法登陆");
                newResp.sendRedirect("index.html");
            }else{
                chain.doFilter(newReq, newResp);
            }
        }else{
            chain.doFilter(newReq, newResp);
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
