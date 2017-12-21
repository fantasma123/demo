package group4.assignment.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import group4.assignment.model.User;
import group4.assignment.util.HibernateUtil;

public class UserDAO {

	Session session = null;
	public ArrayList<User> getUser(){
		session = HibernateUtil.getSessionFactory().openSession();
        String sql = " FROM User";
        Query query = session.createQuery(sql);
        ArrayList<User>  list = (ArrayList<User> )query.list();
        if (list.size() > 0) {
            return list;
        }
        session.close();
        return null;
	}
}
