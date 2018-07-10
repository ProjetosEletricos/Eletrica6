package br.aplicacao.eletrica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.PersistentObjectException;

import br.aplicacao.eletrica.modelo.projeto.Entidade;

public class JpaDAO<T extends Entidade<T>> {

	private static EntityManager entityManager = ConnectionFactory.getEntityManager();
	private Class<T> entityClass;

	public JpaDAO(Class<T> entityClass) {

		this.entityClass = entityClass;

	}

	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		List<T> lista = entityManager.createQuery("FROM " + entityClass.getName()).getResultList();
		return lista;
	}

	public List<T> getByExpres(String expres, Object[] parameter) {

		TypedQuery<T> query = entityManager.createQuery(expres, entityClass);

		if (!(parameter.length == 0)) {
			int i = 0;
			for (int x = 0; x < parameter.length - 1; x++) {

				query.setParameter((String) parameter[i], parameter[i + 1]);
				i += 2;
			}
		}

		List<T> lista = query.getResultList();

		return lista;
	}

	public List<Object> getByExpres(String expres, Object[] parameter, Class<Object> clazz) {

		TypedQuery<Object> query = entityManager.createQuery(expres, clazz);

		if (!(parameter.length == 0)) {
			int i = 0;
			for (int x = 0; x < parameter.length - 1; x++) {

				query.setParameter((String) parameter[i], parameter[i + 1]);

				i += 2;
			}
		}

		List<Object> lista = query.getResultList();

		return lista;
	}

	public T getById(Integer id) {
		return entityManager.find(entityClass, id);
	}

	public void remove(T entity) {
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entity);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(Integer id) {
		try {
			T t = getById(id);
			remove(t);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void salva(T obj) {
		try {
			entityManager.getTransaction().begin();
			if (obj.getId() == null) {
				entityManager.persist(obj);
			} else {
				entityManager.merge(obj);
			}
			entityManager.getTransaction().commit();
		} catch (PersistentObjectException e) {
			System.out.println("NÃO SALVOU!!: ");
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	/*
	 * public void atualiza(T obj) { try { entityManager.getTransaction().begin();
	 * 
	 * entityManager.merge(obj);
	 * 
	 * entityManager.getTransaction().commit(); } catch (Exception e) {
	 * entityManager.getTransaction().rollback(); } }
	 */

}
