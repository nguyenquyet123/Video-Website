package eu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import edu.poly.model.Favorite;
import edu.poly.model.Video;
import poly.edu.todo.FavoriteReport;
import poly.edu.todo.FavoriteUserReport;

public class FavoriteDao extends AbstractEntityDao<Favorite> {

	public FavoriteDao() {
		super(Favorite.class);
	}
	
	public List<FavoriteUserReport> reportFavoriteUserByVideo(String videoId){
		String jpql = "select new poly.edu.todo.FavoriteUserReport(f.user.username, f.user.fullname,"
				+ "f.user.email, f.likeDate) from Favorite f where f.video.videoId = :videoId";
		EntityManager em = JpaUtils.getEntityManager();
		
		List<FavoriteUserReport> list = null;
		
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql, FavoriteUserReport.class);
			
			query.setParameter("videoId", videoId);
			
			list = query.getResultList();
		}finally {
			em.close();
		}
		
		return list;
	}
	
	public List<FavoriteReport> reportFavoritesByVideos(){
		String jpql = "select new poly.edu.todo.FavoriteReport(f.video.title, count(f), min(f.likeDate), max(f.likeDate)) "
				+ " from Favorite f group by f.video.title ";
		
		EntityManager em = JpaUtils.getEntityManager();
		
		List<FavoriteReport> list = null;
		
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql, FavoriteReport.class);
			
			list = query.getResultList();
		} finally {
			em.close();
		}
		
		return list;
	}
	
	public List<Favorite> findFavoriteByUsername(String username) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o FROM Favorite o WHERE o.user.username = :username";
		TypedQuery<Favorite> query = em.createQuery(jpql, Favorite.class);
		query.setParameter("username", username);
		return query.getResultList();
	}
	
	public List findVideoByUsername(String username) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o.video FROM Favorite o WHERE o.user.username = :username";
		Query query = em.createQuery(jpql, Video.class);
		query.setParameter("username", username);
		return query.getResultList();
	}
	
	

}
