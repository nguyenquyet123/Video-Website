package eu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import edu.poly.model.Video;

public class VideoDao extends AbstractEntityDao<Video>{

	public VideoDao() {
		super(Video.class);
	}

	public List<Video> findAllVideo() {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT o FROM Video o WHERE o.active = 1";
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		return query.getResultList();
	}


}
