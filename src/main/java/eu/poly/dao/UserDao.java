package eu.poly.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.model.User;

public class UserDao extends AbstractEntityDao<User> {

	public UserDao() {
		super(User.class);
	}

	public void changePassword(String username, String newPassword) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();

		EntityTransaction trans = em.getTransaction();

		String jpql = "select u from User u where u.username = :username";

		try {
			trans.begin();
			TypedQuery<User> query = em.createQuery(jpql, User.class);
			query.setParameter("username", username);

			User user = query.getSingleResult();

			user.setPassword(newPassword);
			em.merge(user);
			trans.commit();

		} catch (Exception e) {
			trans.rollback();

			throw e;
		} finally {
			em.close();
		}
	}
}
