package persional;

/**
 * 员工实体类
 */
public class Temployee {

    private String number;//id主键
    private String name;//员工姓名
    private String IDCard;//身份证号
    private String phone;//电话号码
    private String position;//职位
    private String seniority;//工龄
    private int dep_id;//部门id

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSeniority() {
        return seniority;
    }

    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }

    public int getDep_id() {
        return dep_id;
    }

    public void setDep_id(int dep_id) {
        this.dep_id = dep_id;
    }

    public Temployee() {
    }

    public Temployee(String number, String name, String IDCard, String phone, String position, String seniority, int dep_id) {
        this.number = number;
        this.name = name;
        this.IDCard = IDCard;
        this.phone = phone;
        this.position=position;
        this.seniority=seniority;
        this.dep_id=dep_id;
    }



    @Override
    public String toString() {
        return "Temployee{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", IDCard='" + IDCard + '\'' +
                ", phone='" + phone + '\'' +
                ", position='" + position + '\'' +
                ", seniority='" + seniority + '\'' +
                ", dep_id='" + dep_id + '\'' +
                '}';
    }
}
