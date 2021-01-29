package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Favorite;
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
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public Favorite Update (Favorite entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			throw new RuntimeException();
		}
	}
	public Favorite delete (String keyWord) {
		try {
			em.getTransaction().begin();
			Favorite entity = findById(keyWord);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public Favorite findById(String keyWord) {
		try {
			em.getTransaction().begin();
			Favorite entity = em.find(Favorite.class, keyWord);
			em.getTransaction().commit();
			return entity;
		}catch(Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}
	public List<Favorite> selectAll(){
		String jqpl = "select o from Favorite o";
		TypedQuery<Favorite> query = em.createQuery(jqpl, Favorite.class);
		List<Favorite> list = query.getResultList();
		return list;
	}
}
