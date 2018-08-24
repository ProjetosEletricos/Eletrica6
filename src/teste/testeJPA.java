package teste;

import java.util.List;

import br.aplicacao.eletrica.modelo.Projeto;
import br.aplicacao.eletrica.servico.ProjetoService;
import br.aplicacao.eletrica.uteis.DataUtil;

public class testeJPA {

	public static void main(String[] args) {
		Projeto projeto = new Projeto();

		projeto.setNome("CHRIS");
		projeto.setAutor("projeto");
		projeto.setDescricao("teste");
		projeto.setData(DataUtil.Atual());


		ProjetoService.salva(projeto);

		List<Projeto> lista = ProjetoService.getByExpres2("select nome from Projeto",new String[] {});
		System.out.println("lista: " + lista.get(0).getNome().toString());

	}

}
