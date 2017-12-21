package group4.assignment.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import group4.assignment.model.Group;
import group4.assignment.model.User;
import group4.assignment.util.HibernateUtil;

public class ImportDAO {


	/*-------------Tìm hiểu thêm để thay thế ----------*/
	public boolean insertDataFormFile(User user){
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			if(session!=null){
				session.close();
			}
		}
		return false;
	}

}
