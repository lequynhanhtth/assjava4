package com.poly.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Favorite;
import com.poly.entity.ReportShare;
import com.poly.entity.videoLike;
import com.poly.jpa.JPA;

public class FavoriteDAO {
	private EntityManager em = JPA.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}

	public Favorite create(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public Favorite Update(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public Favorite delete(Favorite entity) {
		try {
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public List<Favorite> findById(Integer keyWord) {
		try {
			em.getTransaction().begin();
			String jpql = "select o from Favorite";
			TypedQuery<Favorite> query =  em.createQuery(jpql,Favorite.class);
			List<Favorite> list = query.getResultList();
			em.getTransaction().commit();
			return list;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public List<Favorite> selectAll() {
		String jqpl = "select o from Favorite o";
		TypedQuery<Favorite> query = em.createQuery(jqpl, Favorite.class);
		List<Favorite> list = query.getResultList();
		return list;
	}

	public videoLike selectLikeByID(int id) {
		String jpql = "select new videoLike(o.video.id,count(o),o.video.title,o.video.poster,o.video.views,o.video.description) from Favorite o where o.video.id = :id group by o.video.id,o.video.title,o.video.poster,o.video.views,o.video.description ";
		TypedQuery<videoLike> query = em.createQuery(jpql, videoLike.class);
		query.setParameter("id", id);
		videoLike list = query.getSingleResult();
		return list;
	}
	public Favorite findByIdAndVideo(String idUser, int idVideo) {
		String jpql = "select o from Favorite o where o.video.id = :idvideo and o.user.id = :iduser";
		TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
		query.setParameter("idvideo", idVideo);
		query.setParameter("iduser", idUser);
		Favorite  list = query.getSingleResult();
		return list;
	}

}
