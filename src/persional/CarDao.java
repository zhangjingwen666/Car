package persional;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;


public interface CarDao {

    // 关闭资源的方法
    public static void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection) {
	}

    // 添加、修改和删除的方法
    public Integer update(String sql, Object... array);

    // 通过id查询某辆车的方法
    public Car selectBySon(String sno);

    // 查询全部车辆的方法
    public List<Car> selectAll();
}
