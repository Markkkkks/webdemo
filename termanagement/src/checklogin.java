import domain.Employee;
import jdbc.dao.EmployeeDao;
import jdbc.dao.impl.EmployeeDaoJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checklogin")
public class checklogin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username =  request.getParameter("username");
        String password =  request.getParameter("password");
        String answer = null;
        Employee e = new Employee();
        e.setName(username);
        e.setPassword(password);
        EmployeeDao dao = new EmployeeDaoJdbcImpl();
        if(dao.checkEmployee(e)==true)
        //if("abc".equals(username))
            answer= "success";
//            response.sendRedirect("index.html");
        else
            answer = "fail";
        System.out.println(answer);
        response.getOutputStream().write(answer.getBytes());
    }
}
