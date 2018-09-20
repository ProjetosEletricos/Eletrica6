package br.aplicacao.eletrica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.aplicacao.eletrica.modelo.Entidade;

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

	// Query query = manager.createQuery("update Usuario set ativo = false where
	// email like :email");
	// query.setParameter("email", "%@algaworks.com");
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

	@SuppressWarnings("unchecked")
	public List<T> getByExpres2(String expres, Object[] parameter) {

		Query query = entityManager.createQuery(expres);

		if (parameter.length > 0) {
			int i = 0;
			for (int x = 0; x < parameter.length - 1; x++) {

				query.setParameter((String) parameter[i], parameter[i + 1]);

				i += 2;
			}
		}

		List<T> lista = query.getResultList();

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
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void excluirTodos(String tabelaNome) {
		long init = 0;
		long end;
		long diff;
		init = System.currentTimeMillis();
		try {
			entityManager.getTransaction().begin();
			entityManager.createNativeQuery("DELETE FROM " + tabelaNome).executeUpdate();
			entityManager.createNativeQuery("TRUNCATE TABLE " + tabelaNome).executeUpdate();
		} catch (Exception e) {
			System.out.println("Deu erro!" + e);
			entityManager.getTransaction().rollback(); // desfaz transacao se ocorrer erro ao persitir
		} finally {
			if (entityManager.getTransaction().isActive()) {
				entityManager.getTransaction().commit();
			}
			end = System.currentTimeMillis();
			diff = end - init;
			System.out.println("Tempo de resposta = " + (diff / 1000.0) + " segundos em JPA - Hibernate");
		}
	}
}
