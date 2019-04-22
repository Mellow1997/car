package utils;

import entity.Car;

import java.sql.*;
import java.util.List;

public class DbUtils {
    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mysql://localhost:3306/car?useSSL=false&characterEncoding=UTF-8";
    static String root = "root";
    static String pwd = "li1234";
    static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    //获取连接
    static Connection getCon() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, root, pwd);
            if (con == null) {
                System.out.println("null");
            }
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //通用的增 删 改
    public static boolean update(String sql, Object[] objects) {
        try {
            ps = getCon().prepareStatement(sql);
            int i = 1;
            for (Object ob : objects) {
                ps.setObject(i++, ob);
            }

            i = ps.executeUpdate();
            if (i > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return false;
    }

    //查
    static public ResultSet query(String sql, Object[] obs) {
        try {
            ps = getCon().prepareStatement(sql);
            int i = 1;
            if (obs == null) {
                return ps.executeQuery();
            } else {
                for (Object ob : obs) {
                    ps.setObject(i++, ob);
                }
                return ps.executeQuery();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    //关闭
    static public void close() {
        try {
            if (con != null) {
                con.close();
            }

            if (ps != null) {
                con.close();
            }

            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //排序
    public  static String sort(List<Car> cars){
        StringBuffer str = new StringBuffer();
        for (Car car : cars) {
            String html = "            <div class='carlist clearfix'>\n" +
                    "                <ul>\n" +
                    "                    <li>\n" +
                    "                        <div class='car-img'>\n" +
                    "                            <img src='"+car.getImgPath() +"'>\n" +
                    "                        </div>\n" +
                    "                    </li>\n" +
                    "                    <li>\n" +
                    "                        <div class='carinfo'>\n" +
                    "                            <p class='name'>"+car.getName() +"</p>\n" +
                    "                            <p class='info'>"+car.getCarInfo()+"</p>\n" +
                    "                        </div>\n" +
                    "                    </li>\n" +
                    "                    <li>\n" +
                    "                        <div class='price'>\n" +
                    "                            <span class='rmb'>￥</span>\n" +
                    "                            <span class='num'>"+car.getRent()+"</span>\n" +
                    "                            <span class='unit'>/套餐价</span>\n" +
                    "                        </div>\n" +
                    "                        <div class='price-a'><a href='javascript:;'>套餐预约</a></div>\n" +
                    "                    </li>\n" +
                    "                </ul>\n" +
                    "            </div>\n" ;

            str.append(html);

        }
        return str.toString();
    }

}
