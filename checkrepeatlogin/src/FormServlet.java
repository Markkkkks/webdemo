import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Created by zeus on 2017/10/16.
 */
@WebServlet("/FormServlet")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String token =TokenProcesser.getInstance().makeToken();
        request.getSession().setAttribute("token",token);
        out.println("<form action='/checkrepeatlogin/check' method='post'>");
        out.println("向数据库插入:<input type='text' name='contain'></br>");
        out.println("<input type='hidden' name = 'token' value='"+ token+"'>");
        out.println("<input type='submit' val='提交'>");
        out.println(" </form>");
        request





    }
}
class TokenProcesser{
    private TokenProcesser(){};
    private static final TokenProcesser instance = new TokenProcesser();

    public static TokenProcesser getInstance() {
        return instance;
    }
    public String makeToken(){
        String token = ""+System.currentTimeMillis()+ new Random().nextInt(999999999);
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte[] md5 = md.digest(token.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            throw  new RuntimeException(e);
        }
    }
}
