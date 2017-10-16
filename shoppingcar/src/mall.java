import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zeus on 2017/10/16.
 */
@WebServlet("/mall")
public class mall extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset = UTF-8");
        PrintWriter out = response.getWriter();
        out.println("本店有以下书籍</br>");
        db db = new db();
        Map<Integer,Book> map =  db.getBookMap();
        for (Integer i:
             map.keySet()) {
            Book item =map.get(i);
            out.println("<a href='/shoppingcar/item?id="+item.getId()+"'>书籍"+i +"   " +item.getName()+"</br>");
        }

        //浏览过的商品
        String history ="";
        Cookie[] cookies = request.getCookies();

        for(int i = 0;cookies!=null&&i<cookies.length;i++){
            Cookie cookie1 = cookies[i];
            if(cookie1.getName().equals("bookhistory"))
                history = cookie1.getValue();
        }
        if (!history.equals("")){
            String[] items = history.split("\\_");
            for (String id:
                 items) {
                Book book =map.get(Integer.parseInt(id));
                out.println("<a href='/shoppingcar/item>id="+book.getId()+"'>"+book.getName() +"</br>");
            }
        }

    }
}
