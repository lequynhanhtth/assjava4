package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Video;
import com.poly.jpa.JPA;

public class VideoDAO {
	private EntityManager em = JPA.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}

	public Video create(Video entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
		return entity;
	}

	public Video update(Video entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
		return entity;
	}

	public Video delete(String keyWord) {
		try {
			em.getTransaction().begin();
			Video entity = findById(keyWord);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public Video findById(String keyWord) {
		
		Video entity = em.find(Video.class, Integer.parseInt(keyWord));
		return entity;
	}

	public List<Video> selectAll() {
		String jqpl = "select o from Video o";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}

}
