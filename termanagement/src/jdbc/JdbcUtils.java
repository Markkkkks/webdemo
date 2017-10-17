package jdbc;

import oracle.jdbc.pool.OracleDataSource;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public final class JdbcUtils {
    private static String url;
    private static String username;
    private static String password;
    private JdbcUtils(){
    }
    static {
//        Properties p = new Properties();

        try {

//            p.load(new FileInputStream("web/WEB-INF/classes/jdbc/JdbcConfig.properties"));

//            InputStream in = Object.class.getResourceAsStream("jdbcconfig.properties");
//            p.load(in);
//            url = p.getProperty("url");
//            username = p.getProperty("username");
//            password = p.getProperty("password");//            url = p.getProperty("url");
            url = "(DESCRIPTION =(ADDRESS_LIST =(ADDRESS = (PROTOCOL = TCP)(HOST = 127.0.0.1)(PORT = 1521)))(CONNECT_DATA =(SID = 8888)(SERVER = DEDICATED)))";
            username = "test";
            password = "1234";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection(){
        Connection conn = null;
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@" + "(DESCRIPTION =\n" +
                    "    (ADDRESS_LIST =\n" +
                    "      (ADDRESS = (PROTOCOL = TCP)(HOST = 132.109.64.198)(PORT = 1521))\n" +
                    "    )\n" +
                    "    (CONNECT_DATA =\n" +
                    "      (SERVICE_NAME = ora11g)\n" +
                    "    )\n" +
                    "  )");
            ods.setUser(username);
            ods.setPassword(password);
            conn = ods.getConnection();
            System.out.println(conn);
            return conn;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

    public static void free(ResultSet rs, Statement st,Connection conn){
        try {
            if(rs!=null)
                rs.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(st!=null)
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                if(conn!=null)
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
        }
    }
}
