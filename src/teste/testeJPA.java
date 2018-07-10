package teste;

import java.util.List;

import br.aplicacao.eletrica.modelo.projeto.Projeto;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.DataUtil;

public class testeJPA {

	public static void main(String[] args) {
		Projeto projeto = new Projeto();

		projeto.setNome("CHRIS");
		projeto.setAutor("projeto");
		projeto.setDescricao("teste");
		projeto.setData(DataUtil.Atual());

		// daoTesteProjeto.getInstance().merge(projeto);
		// ProjetoService.salve(projeto);

		List<Projeto> lista = ProjetoService.getAll();
		System.out.println("lista: " + lista);

		/*
		 * Class<Projeto> projetot = null; JpaDAO<Projeto> projetoDAO = new
		 * JpaDAO<Projeto>(projetot); projetoDAO.salva(projeto);
		 */

	}

}
