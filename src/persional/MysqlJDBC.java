package persional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

    public class MysqlJDBC {

        private static final String driver = "com.mysql.cj.jdbc.Driver"; // 驱动类名称
        private static final String url = "jdbc:mysql://localhost:3306/Car?characterEncoding=utf8&useSSL=false"; // 连接字符串格式
        private static final String user = "root"; // MySQL用户名
        private static final String password = "123456"; // MySQL密码

        /**
         * 获得MySQL连接
         */
        public static Connection getConnection() {
            try {
                return DriverManager.getConnection(url, user, password);//建立与MySQL数据库的连接。
            } catch (SQLException e) {
                throw new RuntimeException(e);//如果连接过程中出现问题，会将原始的异常转换为一个更通用的异常并抛出。
                //可以确保异常得到适当的处理，或者至少通知调用者有错误发生。
            }
        }
    }



