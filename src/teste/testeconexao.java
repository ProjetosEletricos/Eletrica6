package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.aplicacao.eletrica.modelo.Projeto;
import br.aplicacao.eletrica.uteis.DataUtil;

public class testeconexao {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("EletricaPU");
		EntityManager em = emf.createEntityManager();

		Projeto projeto = new Projeto();
		projeto.setNome("Chris");
		projeto.setAutor("projeto");
		projeto.setDescricao("teste");
		projeto.setData(DataUtil.Atual());

		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
		
		Projeto projeto2 = projeto.clonarSemID();
		

		em.getTransaction().begin();
		em.persist(projeto2);
		em.getTransaction().commit();
	}

}
