package dao;

import entity.Car;
import utils.DbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarDaoImpl implements ICarDao {

    //返回所有 可租 车辆信息
    public List<Car> queryAllCar() {
        String sql = "select * from  carport where status = '1' order by cname";
        return returnCars(DbUtils.query(sql, null));
    }

    //按租金倒序
    public List<Car> queryAllCarByRentDesc() {
        String sql = "select * from  carport where status = '1' order by crent desc";
        return returnCars(DbUtils.query(sql, null));
    }

    //按租金升序
    public List<Car> queryAllCarByRentAsc() {
        String sql = "select * from  where status = '1' carport order by crent ";
        return returnCars(DbUtils.query(sql, null));
    }


    //从ResultSet中返回List
    public List<Car> returnCars(ResultSet rs) {
        List<Car> cars = new ArrayList<>();
        try {
            while (rs.next()) {
                //根据 status 返回状态
                String status;
                int i = rs.getInt("status");
                if (i == -1) {
                    status = "下架";
                } else if (i == 0) {
                    status = "租用中";
                } else {
                    status = "可租";
                }
                int cid = rs.getInt("cid");
                String cimg = rs.getString("cimg");
                String cinfo = rs.getString("cinfo");
                String cname = rs.getString("cname");
                double crent = rs.getDouble("crent");
                cars.add(new Car(cid, cimg, cinfo, cname, crent, status));
            }
            return cars;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DbUtils.close();
        }
        return null;
    }


    //从ResultSet中返回car
    public Car returnCar(ResultSet rs) {
        try {
            if (rs.next()) {
                return new Car(rs.getInt("cid"), rs.getString("cimg"), rs.getString("cinfo"), rs.getString("cname"), rs.getDouble("crent"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            DbUtils.close();
        }
        return null;
    }


    //模糊查询
    public List<Car> fuzzyQueryByCar(String name) {
        String sql = "select * from carport where status = '1' and cname like ?";
        String str = "%" + name + "%";
        Object[] objects = {str};
        return returnCars(DbUtils.query(sql, objects));
    }

    //根据车辆id 返回 car
    public Car queryCarById(String id) {
        String sql = "select * from carport where cid = ?";
        Object[] objects = {id};
        return returnCar(DbUtils.query(sql, objects));
    }

    //根据分页 返回car
    public List<Car> queryCarByLimit(int page, int limit) {
        String sql = "select * from carport limit ?,?";
        Object[] obs = {page, limit};
        return returnCars(DbUtils.query(sql, obs));
    }

    //更改车辆状态
    public void changeCarStatus(int id, int status) {
        String sql = "update carport set status = ? where cid = ?";
        Object[] obs = {status, id};
        DbUtils.update(sql, obs);

    }

    //返回数据总数
    public int carTotal() {
        String sql = "select count(*) from carport";
        ResultSet rs = DbUtils.query(sql, null);

        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                DbUtils.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    //新增 一条 car
    public void addCar(Car car){
        String sql = "insert into carport (cimg,cinfo,cname,crent,status) values(?,?,?,?,?)";
        Object[] obs = {car.getImgPath(),car.getCarInfo(),car.getName(),car.getRent(),car.getiStatus()};
        DbUtils.update(sql,obs);
    }
}
