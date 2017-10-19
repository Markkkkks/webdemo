package dao.impl;

import dao.UserDao;
import domain.User;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import utils.XmlUtils;

import java.sql.Date;

public class UserDaoXmlImpl implements UserDao {
    @Override
    public User find(String username, String password){
        try {
            Document d = XmlUtils.getDocument();
            Element e = d.getRootElement();
            Element node = (Element) e.selectSingleNode("//user[@username='"+username+"' and @password = '"+password+"']");
            if(node==null)
                return null;
            User user = new User();
            user.setId(node.attributeValue("id"));
            user.setEmail(node.attributeValue("email"));
            user.setPassword(node.attributeValue("password"));
            user.setUsername(node.attributeValue("username"));
            user.setBirthday(Date.valueOf(node.attributeValue("birthday")));
            return user;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void add(User user){
        try {
            Document d = XmlUtils.getDocument();
            Element e  = d.getRootElement();
            Element usernode = e.addElement("user")
                    .addAttribute("id",user.getId())
                    .addAttribute("username",user.getUsername())
                    .addAttribute("password",user.getPassword())
                    .addAttribute("email",user.getEmail())
                    .addAttribute("birthday",user.getBirthday().toString());
            XmlUtils.write(d);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public User find(String username){
        try {
            Document d = XmlUtils.getDocument();
            Element  e = d.getRootElement();
            Element node = (Element) e.selectSingleNode("//user[@username='"+username+"']");
            if (node==null)
                return null;

            User user = new User();
            user.setId(node.attributeValue("id"));
            user.setEmail(node.attributeValue("email"));
            user.setPassword(node.attributeValue("password"));
            user.setUsername(node.attributeValue("username"));
            user.setBirthday(Date.valueOf(node.attributeValue("birthday")));
            return user;
        } catch (DocumentException e) {
            throw new RuntimeException(e);
        }


    }
}
