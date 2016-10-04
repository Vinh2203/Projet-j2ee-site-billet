package com.projet.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import javax.persistence.criteria.CriteriaQuery;

public abstract class AbstractDao<E, K> {

	private final EntityManagerFactory emf;
	private final Class<E> model;
	
	protected AbstractDao(EntityManagerFactory emf) {
		this.emf  = emf;
		this.model = getModel();
	}
	
	@SuppressWarnings("unchecked")
	private Class<E> getModel() {
		ParameterizedType generic = (ParameterizedType) getClass().getGenericSuperclass();
		return (Class<E>) generic.getActualTypeArguments()[0];
	}
	
	protected EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	protected E persist(E obj) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.persist(obj);
			em.getTransaction().commit();
		} finally {
			rollback(em.getTransaction());
			em.close();
		}
		return obj;
	}
	
	protected void update(E obj) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.merge(obj);
			em.getTransaction().commit();
		} finally {
			rollback(em.getTransaction());
			em.close();
		}
	}
	
	protected E findById(K id) {
		EntityManager em = getEntityManager();
		try { 
			return em.find(model, id);
		} finally {
			em.close(); 
		}
	}
	
	protected void remove(E obj) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		try {
			em.remove(em.merge(obj));
			em.getTransaction().commit();
		} finally {
			rollback(em.getTransaction());
			em.close();
		}
	}
	
	protected List<E> findAll() {
		EntityManager em = getEntityManager();
		try {
			CriteriaQuery<E> criteriaQuery = em.getCriteriaBuilder().createQuery(model);
			criteriaQuery.from(model);
			return em.createQuery(criteriaQuery).getResultList();
		} finally {
			em.close();
		}
	}
	
	protected void rollback(EntityTransaction t) {
		if(t.isActive()) {
			t.rollback();
		}
	}
}
