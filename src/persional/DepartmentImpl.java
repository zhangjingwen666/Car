package persional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



    /**
     *
     */
    public class DepartmentImpl {


        private static Connection connection = null;
        private static PreparedStatement statement = null;
        private static ResultSet resultSet = null;

        /**
         * 关闭资源
         */
        public static void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection) {
            // 关闭resultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            // 关闭statement
            if (statement != null) {
                try {
                    statement.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            // 关闭connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

        }

        /**
         * 添加、修改和删除的方法
         */
        public static Integer update(String sql, Object... array) {
            try {
                connection = MysqlJDBC.getConnection();//获得MySQL连接
                statement = connection.prepareStatement(sql);//prepareStatement用于执行参数化查询
                for (int i = 0; i < array.length; i++) {//将sql中的“？”替换为对应的参数
                    statement.setObject(i + 1, array[i]);
                }
                return statement.executeUpdate();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                closeAll(null, statement, connection);//关闭资源
            }
        }

        /**
         * 通过id查询某部门
         */
        public static Department selectBySon(String sno) {
            connection = MysqlJDBC.getConnection();
            String sql = "SELECT * FROM t_department where id = ?";
            Department department = null;
            try {
                statement = connection.prepareStatement(sql);
                statement.setObject(1, sno);//将sql中的“？”替换为对应的参数
                resultSet = statement.executeQuery();
                //处理查询到的数据
                if (resultSet.next()) {
                    department = new Department();//实例化对象
                    department.setId(resultSet.getInt("id"));
                    department.setManager_num(resultSet.getString("manager_num"));
                    department.setName(resultSet.getString("name"));
                    department.setTelephone(resultSet.getString("telephone"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeAll(resultSet, statement, connection);//关闭资源
            }
            return department;//返回departmentList对象
        }

        /**
         * 查询全部部门
         */
        public static List<Department> selectAll() {
            connection = MysqlJDBC.getConnection();
            String sql = "SELECT * FROM t_department";
            List<Department> departmentList = new ArrayList<>();
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                //处理查询到的数据
                while (resultSet.next()) {
                    Department department = new Department();
                    department.setId(resultSet.getInt("id"));
                    department.setName(resultSet.getString("name"));
                    department.setManager_num(resultSet.getString("manager_num"));
                    department.setTelephone(resultSet.getString("telephone"));
                    departmentList.add(department);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeAll(resultSet, statement, connection);//关闭资源
            }
            return departmentList;//返回学生对象
        }

    }
