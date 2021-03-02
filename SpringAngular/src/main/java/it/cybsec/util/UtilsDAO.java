package it.cybsec.util;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import it.cybsec.model.Esami;
import it.cybsec.model.Skill;

public class UtilsDAO {
	protected static EntityManager em;
	protected static EntityManagerFactory emf;
	protected static EntityTransaction tx = null;
	private static UtilsDAO dao;

	private UtilsDAO() {
		emf = Persistence.createEntityManagerFactory("persistence");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	public static UtilsDAO getInstance() {
		if (emf == null) {
			dao = new UtilsDAO();
		}
		return dao;
	}
	
	public void remEsami(int id) throws SQLException {
		Esami esami = getEsamiID(id);
		
		tx.begin();
		em.remove(esami);
		tx.commit();
	}	
	
	public void remSkill(int id) throws SQLException {
		Skill skill = getSkillID(id);
		
		tx.begin();
		em.remove(skill);
		tx.commit();
	}
		
	public Skill getSkillID(int id) throws SQLException{
		return em.find(Skill.class, id);
	}
	
	public Esami getEsamiID(int id) throws SQLException{
		return em.find(Esami.class, id);
	}
	
	public void newAttori(Esami esami) throws SQLException {
		tx.begin();
		em.merge(esami);
		tx.commit();
	}

	public List<Esami> getAttori() throws SQLException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Esami> cq = cb.createQuery(Esami.class);
		Root<Esami> esami = cq.from(Esami.class);
		cq.select(esami);
		TypedQuery<Esami> q = em.createQuery(cq);
		List<Esami> allEsami = q.getResultList();
		return allEsami;
	}
	
	public void newSkill(Skill skill) throws SQLException {
		tx.begin();
		em.merge(skill);
		tx.commit();
	}
	
	public List<Skill> getSkill() throws SQLException {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Skill> cq = cb.createQuery(Skill.class);
		Root<Skill> skill = cq.from(Skill.class);
		cq.select(skill);
		TypedQuery<Skill> q = em.createQuery(cq);
		List<Skill> allSkill = q.getResultList();
		return allSkill;
	}
	
	public int lastFilm(Skill film) throws SQLException {
		Skill mSkill;
		tx.begin();
		mSkill = em.merge(film);
		tx.commit();
		return mSkill.getId();
	}

}
