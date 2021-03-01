package com.poly.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.poly.entity.Report;
import com.poly.entity.ReportUser;
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

	public Video delete(int keyWord) {
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

	public Video findById(int keyWord) {

		Video entity = em.find(Video.class, keyWord);
		return entity;
	}

	public List<Video> selectAll() {
		String jqpl = "select o from Video o order by o.video.view DESC";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		List<Video> list = query.getResultList();
		return list;
	}

	public List<Report> selectVideoFavorite() {
		String jpql = "Select new Report(o.video.title,count(o),max(o.likedate),min(o.likedate)) from Favorite o group by o.video.title";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		List<Report> list = query.getResultList();
		return list;
	}

	public List<ReportUser> selectUserFavorite(String title) {
		String jpql = "Select new ReportUser(o.user.id,o.user.fullname,o.user.email,o.likedate) from Favorite o where o.video.title = :title";
		TypedQuery<ReportUser> query = em.createQuery(jpql, ReportUser.class);
		query.setParameter("title", title);
		List<ReportUser> list = query.getResultList();
		return list;
	}

	public List<String> selectTitle() {
		String jqpl = "Select o.video.title from Favorite o";
		TypedQuery<String> query = em.createQuery(jqpl, String.class);
		List<String> list = query.getResultList();
		return list;
	}

	public List<Video> selectCountFavoritesVideo(int count, int page, String id) {
		String jqpl = "select o.video from Favorite o where o.user.id = :id";
		TypedQuery<Video> query = em.createQuery(jqpl, Video.class);
		query.setParameter("id", id);
		List<Video> list = query.getResultList();
		List<Video> listcount = new ArrayList<Video>();
		if (count * page > list.size()) {
			for (int i = count * (page - 1); i < list.size(); i++) {
				listcount.add(list.get(i));
			}
		} else {
			for (int i = count * (page - 1); i < count; i++) {
				listcount.add(list.get(i));
			}
		}
		return listcount;
	}

	public List<Video> selectCountVideo(int count, int page) {
		List<Video> list = selectAll();
		List<Video> listcount = new ArrayList<Video>();
		if (count * page > list.size()) {
			for (int i = count * (page - 1); i < list.size(); i++) {
				listcount.add(list.get(i));
			}
		} else {
			for (int i = count * (page - 1); i < count; i++) {
				listcount.add(list.get(i));
			}
		}
		return listcount;
	}

	public List<Video> selectInRow(int row, List<Video> listPage) {
		List<Video> list = new ArrayList<Video>();
		if (row * 4 > listPage.size()) {
			for (int i = (row - 1) * 4; i < listPage.size(); i++) {
				list.add(listPage.get(i));
			}
		} else {
			for (int i = (row - 1) * 4; i < row * 4; i++) {
				list.add(listPage.get(i));
			}
		}
		return list;
	}
}
