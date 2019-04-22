package entity;

public class Car {
    private int id; //车辆编号
    private String imgPath; //车辆图片
    private String carInfo; //车辆信息
    private String name; //车辆名称
    private double rent; //车辆租金
    private String status;
    private int iStatus;//车辆状态 -1 下架 ；0 出租 ；1 可租

    public int getiStatus() {
        return iStatus;
    }

    public void setiStatus(int iStatus) {
        this.iStatus = iStatus;
    }

    public Car(int id, String imgPath, String carInfo, String name, double rent, String status) {
        this.id = id;
        this.imgPath = imgPath;
        this.carInfo = carInfo;
        this.name = name;
        this.rent = rent;
        this.status = status;
    }

    public Car(String imgPath, String carInfo, String name, double rent,int iStatus) {
        this.imgPath = imgPath;
        this.carInfo = carInfo;
        this.name = name;
        this.rent = rent;
        this.iStatus = iStatus;
    }

    public Car(int id, String imgPath, String carInfo, String name, double rent) {
        this.id = id;
        this.imgPath = imgPath;
        this.carInfo = carInfo;
        this.name = name;
        this.rent = rent;
    }

    public Car() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCarInfo() {
        return carInfo;
    }

    public void setCarInfo(String carInfo) {
        this.carInfo = carInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
