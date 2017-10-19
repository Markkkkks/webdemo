import domain.Department;
import jdbc.JdbcUtils;
import jdbc.dao.DepartmentDao;
import jdbc.dao.impl.DepartmentDaoJdbcImpl;
import net.sf.json.JSONObject;
import oracle.jdbc.OraclePreparedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String []args){
//        JSONObject j = new JSONObject();
//        j.element("1","2");
//        System.out.println(j.get("1"));
//        Connection conn = JdbcUtils.getConnection();
        DepartmentDaoJdbcImpl dao = new DepartmentDaoJdbcImpl();
        Department d = dao.find("健身房");
        System.out.println(d.getLocation());
    }
}
