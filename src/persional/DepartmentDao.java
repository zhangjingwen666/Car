package persional;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

    public interface DepartmentDao {

        // 关闭资源的方法
        public void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection);

        // 添加、修改和删除的方法
        public Integer update(String sql, Object... array);

        // 通过id查询某部门的方法
        public Department selectBySon(String sno);

        // 查询全部部门的方法
        public List<Department> selectAll();
    }
