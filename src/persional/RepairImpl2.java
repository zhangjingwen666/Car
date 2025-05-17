package persional;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class RepairImpl2 {
        private static Connection connection = null;
        private static PreparedStatement statement = null;
        private static ResultSet resultSet = null;

        public static void closeAll(ResultSet resultSet, PreparedStatement statement, Connection connection) {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        public static Integer update(String sql, Object... array) {
            try {
                connection = MysqlJDBC.getConnection();
                statement = connection.prepareStatement(sql);
                for (int i = 0; i < array.length; i++) {
                    statement.setObject(i + 1, array[i]);
                }
                return statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } finally {
                closeAll(null, statement, connection);
            }
        }

        public static Repairment2 selectBySon(String id) {
            connection = MysqlJDBC.getConnection();
            String sql = "SELECT * FROM t_repair_record where id = ?";
            Repairment2 repair = null;
            try {
                statement = connection.prepareStatement(sql);
                statement.setObject(1, id);
                resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    repair = new Repairment2();
                    repair.setId(resultSet.getInt("id"));
                    repair.setDate_time(resultSet.getString("date_time"));
                    repair.setRepair_address(resultSet.getString("repair_address"));
                    repair.setRepair_project(resultSet.getString("repair_project"));
                    repair.setCost(resultSet.getFloat("cost"));
                    repair.setResponsible(resultSet.getString("responsible"));
                    repair.setCar_id(resultSet.getInt("car_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeAll(resultSet, statement, connection);
            }
            return repair;
        }

        public static List<Repairment2> selectAll() {
            connection = MysqlJDBC.getConnection();
            String sql = "SELECT * FROM t_repair_record";
            List<Repairment2> repairList = new ArrayList<>();
            try {
                statement = connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Repairment2 repair = new Repairment2();
                    repair.setId(resultSet.getInt("id"));
                    repair.setDate_time(resultSet.getString("date_time"));
                    repair.setRepair_address(resultSet.getString("repair_address"));
                    repair.setRepair_project(resultSet.getString("repair_project"));
                    repair.setCost(resultSet.getFloat("cost"));
                    repair.setResponsible(resultSet.getString("responsible"));
                    repair.setCar_id(resultSet.getInt("car_id"));
                    repairList.add(repair);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeAll(resultSet, statement, connection);
            }
            return repairList;
        }
    }

