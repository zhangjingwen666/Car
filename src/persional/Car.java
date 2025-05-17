package persional;

/**
 * 车实体类
 */
public class Car {
    private int id;//id主键
    private String car_number;//车牌号
    private String model;//车型
    private int car_age;//车龄
    private String color;//颜色
    private int is_unused;//是否闲置


    public Car() {
    }
    
    public Car(int id, String car_number, String model, int car_age, String color, int is_unused) {
        this.id = id;
        this.car_number = car_number;
        this.model = model;
        this.car_age = car_age;
        this.color = color;
        this.is_unused = is_unused;
    }
    public int getId() {
        return id;
    } 

    public void setId(int id) {
        this.id = id;
    }
    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCar_age() {
        return car_age;
    }

    public void setCar_age(int Car_age) {
        this.car_age = Car_age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getIs_unused() {
        return is_unused;
    }

    public void setIs_unused(int is_unused) {
        this.is_unused = is_unused;
    }


    @Override
    public String toString() {
        return "Carldy{" +
                "id=" + id +
                ", car_number='" + car_number + '\'' +
                ", model='" + model + '\'' +
                ", car_age='" + car_age + '\'' +
                ", color=" + color +
                ", is_unused='" + is_unused + '\'' +
                ", is_unused='" + is_unused + '\'' +
                '}';
    }

	
}
