package com.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.User;
import com.poly.jpa.JPA;

public class UserDAO {
	private EntityManager em = JPA.getEntityManager();

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		em.close();
		super.finalize();
	}

	public User create(User entity) {
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

	public User update(User entity) {
		try {
			em.getTransaction().begin();
			em.merge(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User delete(String keyWord) {
		try {
			em.getTransaction().begin();
			User entity = findById(keyWord);
			em.remove(entity);
			em.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			em.getTransaction().rollback();
			throw new RuntimeException();
		}
	}

	public User findById(String keyWord) {
		User entity = em.find(User.class, keyWord);
		return entity;
	}

	public List<User> findAll() {
		String jqpl = "SELECT o FROM User o";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);

		List<User> list = query.getResultList();
		return list;
	}

	public List<User> findByRole(boolean role) {
		String jqpl = "SELECT o from User o where o.role = :role";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("role", role);
		List<User> list = query.getResultList();
		return list;
	}

	public List<User> findByFullname(String keyWord) {
		String jqpl = "SELECT o from User o where o.Fullname like ?name";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("name", keyWord);
		List<User> list = query.getResultList();
		return list;
	}

	public User findOne(String Id, String password) {
		String jqpl = "select o from User o where o.Id = :id and o.Password = :pw";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("id", Id);
		query.setParameter("pw", password);
		User entity = query.getSingleResult();
		return entity;
	}

	public List<User> findPage(int page, int size) {
		String jqpl = "select o from User o ";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setFirstResult(page * size);
		query.setMaxResults(size);
		List<User> list = query.getResultList();
		return list;
	}

	public List<User> findVideoFavorByVideoId(String keyWord) {
		String jqpl = "select o.user from Favorite o where o.video.id = :uid ";
		TypedQuery<User> query = em.createQuery(jqpl, User.class);
		query.setParameter("uid", keyWord);
		List<User> list = query.getResultList();
		return list;
	}
}
