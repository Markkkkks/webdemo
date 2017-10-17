import domain.Department;
import jdbc.dao.DepartmentDao;
import jdbc.dao.impl.DepartmentDaoJdbcImpl;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/mServlet")
public class mServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应内容类型
        response.setContentType("text/html");
//设置逻辑实现
        PrintWriter out = response.getWriter();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getParameter("test1").equals("123"))
        {
//            Student s = new Student();
//            s.setName("wanger");s.setGender(true);s.setAge(12);
            DepartmentDao dao = new DepartmentDaoJdbcImpl();
            Department department = dao.find("健身房");
            JSONObject jsonObject = (JSONObject) JSONSerializer.toJSON(department);
            Department d2 = new Department();
            d2.setId(2);
            d2.setLocation("3f");
            d2.setName("健身房2");
            Department d3 = new Department();
            d3.setId(3);
            d3.setLocation("4f");
            d3.setName("健身房3");
            JSONObject[] jsonObjects =new JSONObject[3];
            jsonObjects[0]=jsonObject;
            jsonObjects[1]=(JSONObject) JSONSerializer.toJSON(d2);
            jsonObjects[2]=(JSONObject) JSONSerializer.toJSON(d3);
            response.setHeader("Cache-Control", "no-cache");
            response.setHeader("Pragma", "no-cache");
            response.setDateHeader("expires", -1);
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter pw = response.getWriter();
            String s =Utils.getJsonString(jsonObjects);
            pw.write(s);
//            JSONObject objects = (JSONObject)JSONSerializer.toJSON(jsonObjects);

        }

    }


}
