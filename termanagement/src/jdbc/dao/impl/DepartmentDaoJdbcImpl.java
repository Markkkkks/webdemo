package jdbc.dao.impl;

import domain.Department;
import jdbc.JdbcUtils;
import jdbc.dao.DepartmentDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentDaoJdbcImpl implements DepartmentDao{

    @Override
    public void add(Department de) {

    }

    @Override
    public void delect(String name) {

    }

    @Override
    public void update(Department de) {

    }

    @Override
    public Department find(String name) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Department answer = null;
        Connection conn = JdbcUtils.getConnection();
        System.out.println(conn);
        try {
            ps = conn.prepareStatement("SELECT DEPARTMENT_ID,name,location FROM  DEPARTMENT  WHERE  name = ?");
            ps.setString(1,name);
            rs =  ps.executeQuery();
            while(rs.next()){
//                System.out.println("ID: "+rs.getInt("DEPARTMENT_ID")+"\t" +
//                        "name: " + rs.getString("name")+"\tlocation: "+rs.getString("location"));
                answer = new Department();
                answer.setName(rs.getString("name"));
                answer.setLocation(rs.getString("location"));
                answer.setId(rs.getInt("department_id"));
                return answer;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.free(rs,ps,conn);
        }
        return answer;
    }
}
