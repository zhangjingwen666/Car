package persional;


public interface UserDao {
//执行数据库更新操作。
    Integer update(String sql, Object... array);
//根据用户名查询用户信息。
    User selectByUserName(String userName);

}