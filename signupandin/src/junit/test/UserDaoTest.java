package junit.test;

import dao.impl.UserDaoXmlImpl;
import domain.User;
import org.junit.Test;

import java.util.Date;

public class UserDaoTest {
    @Test
    public void testAdd() {
        User u = new User();
        u.setUsername("test");
        u.setPassword("testpassword");
        u.setId("testid");
        u.setEmail("test@test.com");
        u.setBirthday(new Date());

        UserDaoXmlImpl userdao = new UserDaoXmlImpl();
        userdao.add(u);

    }

    @Test
    public void testfind(){
        UserDaoXmlImpl userdao = new UserDaoXmlImpl();
        User u = userdao.find("aaa");
    }
    @Test
    public void testfind2(){
        UserDaoXmlImpl userDao = new UserDaoXmlImpl();
        User u =userDao.find("aaa","123456");
    }
}
