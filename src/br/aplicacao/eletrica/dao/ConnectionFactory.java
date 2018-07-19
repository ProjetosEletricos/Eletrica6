package br.aplicacao.eletrica.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConnectionFactory {

	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("EletricaPU");

	public static EntityManager getEntityManager() {

		return factory.createEntityManager();
	}
}
