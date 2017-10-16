import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by zeus on 2017/10/16.
 */
@WebServlet("/item")
public class item extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =  response.getWriter();
        out.println("你想购买这本书吗");
        db db = new db();
        Book book = db.getBookMap().get(Integer.parseInt(request.getParameter("id")));
        out.println(book.getId() + "    " +book.getName()+" "+book.getAuthor()+"    "+book.getPrice());




        String history = makehistory(Integer.parseInt(request.getParameter("id")),request);
        Cookie cookie = new Cookie("bookhistory",history);
        response.addCookie(cookie);
        out.println("<a href = '/shoppingcar/mall'>返回</br>");
    }

    private String makehistory(int id, HttpServletRequest request) {
        String bookhistory = "";
        //获取当前的历史
        Cookie[] cookies = request.getCookies();
        for(int i = 0;cookies!=null&&i<cookies.length;i++){
            Cookie cookie = cookies[i];
            if(cookie.getName().equals("bookhistory"))
                bookhistory = cookie.getValue();
        }

        //当前历史为空 直接加数字返回
        if(bookhistory =="") {
            bookhistory += id;
            return bookhistory;
        }

        //有历史的情况下创造list处理数据
        int maxlength =3;
        LinkedList<String>books = new LinkedList<String>(Arrays.asList(bookhistory.split("\\_")));

        //有当前历史则置1
        if(books.contains(""+id))
        {
            books.remove(""+id);
            books.addFirst(""+id);
        }
        //无则添加
        else {
            books.addFirst(""+id);
            if(books.size()>3)
                books.removeLast();
        }

        //输出list
        StringBuilder sb = new StringBuilder();
        for (String book : books) {
            sb.append(book+"_");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}

class Book {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book(String id, String name, String author, double price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String author;
    private double price;
}

class db {
    private Map<Integer, Book> bookMap = new HashMap<>();
    public db()
    {
        bookMap.put(1,new Book("1","name1","author1",50));
        bookMap.put(2,new Book("2","name2","author2",50));
        bookMap.put(3,new Book("3","name3","author3",50));

    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }
}
