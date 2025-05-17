
//注册用户实体类，通过无参或有参构造方法来创建，并通过getter和setter方法来操作其属性。
package persional;

//无参构造方法,创建没有任何属性值的用户对象。
public class User {

    private Long userId;//用户的唯一标识符
    private String userName;//用户名
    private String userPassword;//密码
    public User() {
    }//公共的无参构造函数,不会执行任何初始化操作,创建的对象的所有属性都将保持其默认值。

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }//有参构造方法,在创建对象时可以直接传入用户名和密码作为参数，
    //getter方法用于获取属性的值，setter方法用于设置属性的值,保证数据的封装性和安全性
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}