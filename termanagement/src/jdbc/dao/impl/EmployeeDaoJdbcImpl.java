package jdbc.dao.impl;

import domain.Employee;
import jdbc.JdbcUtils;
import jdbc.dao.EmployeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeDaoJdbcImpl implements EmployeeDao {
    @Override
    public boolean checkEmployee(Employee e) {
        Connection conn = JdbcUtils.getConnection();
        String username = e.getName();
        String password = e.getPassword();
        ResultSet rs = null;
        PreparedStatement ps = null;
        boolean result = false;
        try {
            String query = "SELECT *FROM employee WHERE NAME =  ? AND PWD = ? ";
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next())
                result = true;
        } catch (Exception exception) {
            return false;
        } finally {
            JdbcUtils.free(rs, ps, conn);
        }
        return result;
    }
}
