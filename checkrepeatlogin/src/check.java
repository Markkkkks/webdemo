import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zeus on 2017/10/16.
 */
@WebServlet("/check")
public class check extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("check servlet start");
        boolean repect = checkToken(request);
        if(repect==true)
            System.out.println("重复提交");
        else {
            request.getSession().removeAttribute("token");
            System.out.println("插入用户" + request.getParameter("contain"));
        }
    }

    private boolean checkToken(HttpServletRequest request) {
        String client_Token =request.getParameter("token");
        String server_token = (String) request.getSession().getAttribute("token");
        if(client_Token==null)//非合法网站访问
            return true;
        if(server_token==null)//没有server_token 因为第一次处理请求时会删除token
            return true;
        if(!server_token.equals(client_Token))
            return true;
        return false;
    }
}
