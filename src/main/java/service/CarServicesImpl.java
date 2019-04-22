package service;

import dao.CarDaoImpl;
import dao.ICarDao;
import entity.Car;

import java.util.List;

public class CarServicesImpl implements ICarServices {
    ICarDao cd = new CarDaoImpl();

    //返回所有车辆信息
    public List<Car> queryAllCar() {
        return cd.queryAllCar();
    }

    //按租金倒序
    public List<Car> queryAllCarByRentDesc() {
        return cd.queryAllCarByRentDesc();
    }

    //按租金升序
    public List<Car> queryAllCarByRentAsc() {
        return cd.queryAllCarByRentAsc();
    }

    //模糊查询
    public List<Car> fuzzyQueryByCar(String name) {
        return cd.fuzzyQueryByCar(name);
    }

    //根据车辆id 返回 car
    public Car queryCarById(String id){
        return cd.queryCarById(id);
    }

    //根据分页 返回car
    public List<Car> queryCarByLimit(int page, int limit) {
       return cd.queryCarByLimit(page,limit);
    }

    //更改车辆状态
    public void changeCarStatus(int id, int status){
        cd.changeCarStatus(id,status);
    }

    //返回数据总数
    public int carTotal(){
        return cd.carTotal();
    }

    //新增 一条 car
    public void addCar(Car car){
     cd.addCar(car);
    }
}
