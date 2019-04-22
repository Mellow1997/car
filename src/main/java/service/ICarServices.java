package service;

import entity.Car;

import java.util.List;

public interface ICarServices {
    //返回所有车辆信息
    List<Car> queryAllCar();

    //按租金倒序
    List<Car> queryAllCarByRentDesc();

    //按租金升序
    List<Car> queryAllCarByRentAsc();

    //模糊查询
    List<Car> fuzzyQueryByCar(String name);

    //根据车辆id 返回 car
    public Car queryCarById(String id);

    //根据分页 返回car
    List<Car> queryCarByLimit(int page, int limit);

    //更改车辆状态
    public void changeCarStatus(int id, int status);

    //返回数据总数
    int carTotal();

    //新增 一条 car
    void addCar(Car car);
}
