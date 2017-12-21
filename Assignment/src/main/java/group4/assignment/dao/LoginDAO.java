package group4.assignment.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import group4.assignment.model.User;
import group4.assignment.util.HibernateUtil;


public class LoginDAO {

	Session session = null;
	public boolean checkLogin(String user, String pass){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = " FROM User WHERE id = :user AND passWord = :pass";
        Query query = session.createQuery(sql);
        query.setParameter("user", user);
        query.setParameter("pass", pass);
        List<User> list = query.list();
        if (list.size() > 0) {
            return true;
        }
        session.close();
        return false;
	}
	public List getInforIfLoginSucess(String id){
		session = HibernateUtil.getSessionFactory().openSession();
        //session.beginTransaction();
        String sql = "FROM User WHERE id=:id";
        Query query = session.createQuery(sql);
        query.setParameter("id", id);
        List<User> list = query.list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
	}
}
