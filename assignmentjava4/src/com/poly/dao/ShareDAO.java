package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Share;
import com.poly.jpa.JPA;

public class ShareDAO {
	private EntityManager em = JPA.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}
	public Share create(Share entity) {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public Share update(Share entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public Share delete(String keyWord) {
		try {
			em.getTransaction().begin();
			Share entity = findById(keyWord);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public Share findById(String keyWord) {
		try {
			em.getTransaction().begin();
			Share entity = em.find(Share.class, keyWord);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public List<Share> selectAll (){
		String jqpl = "select o from Share o";
		TypedQuery<Share> query = em.createQuery(jqpl, Share.class);
		List<Share> list = query.getResultList();
		return list;
	}
}
