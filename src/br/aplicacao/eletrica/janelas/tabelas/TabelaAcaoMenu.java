package br.aplicacao.eletrica.janelas.tabelas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;
import br.aplicacao.eletrica.uteis.GravarCSV;
import br.aplicacao.eletrica.uteis.JanelaSelecao;
import br.aplicacao.eletrica.uteis.LerCSV;
import br.aplicacao.eletrica.uteis.Lista;

public class TabelaAcaoMenu implements ActionListener {

	private TabelaModeloFrm frm;

	public TabelaAcaoMenu(TabelaModeloFrm frm) {

		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getMntmCarregarCSV().addActionListener(this);
		frm.getMntmSalvarCsv().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == frm.getMntmCarregarCSV()) {
			
			JFileChooser selecao = new JFileChooser();
			selecao.setFileFilter(null);
			int opcao = selecao.showOpenDialog(null);
			
			if (opcao == JFileChooser.APPROVE_OPTION) {

				LerCSV dados = new LerCSV(selecao.getSelectedFile().toString());
				String[][] tabela = dados.toMatriz();
				Util.salvarMatrizToTabelaCapacidadeCorrente(tabela);

				frm.getTabelaControle().iniciaTabela(CapacidadeCorrenteService.getAll());
			}
		}
/*			
			JanelaSelecao janela = new JanelaSelecao();
			janela.abre();
			
			if (janela.confirma()) {

				LerCSV dados = new LerCSV(janela.getSelecao().toString());
				String[][] tabela = dados.lerTabela();
				Util.salvarMatrizToTabelaCapacidadeCorrente(tabela);
				System.out.println("Passou por aqui novamente");
				System.out.println("Passou por aqui");
			}*/

		if (event.getSource() == frm.getMntmSalvarCsv()) {

			JanelaSelecao janela = new JanelaSelecao();
			janela.abre();

			if (janela.confirma()) {
				GravarCSV arquivo = null;
				try {
					arquivo = new GravarCSV(janela.getSelecao().toString() + ".csv");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				// lista de objetos
				List<CapacidadeCorrente> lista = CapacidadeCorrenteService.getAll();
				List<String> array1 = new ArrayList<String>();
				array1.add("BITOLA");
				for (int i = 0; i < lista.size(); i++) {
					array1.add(lista.get(i).getMetodo());
				}

				// lista de metodos
				array1 = Lista.tiraRepetidos(array1);
				try {
					arquivo.writeLine(array1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				List<String> array2 = new ArrayList<String>();

				for (int i = 0; i < lista.size(); i++) {
					array2.add(lista.get(i).getSecao().toString());
				}

				// lista de secoes
				array2 = Lista.tiraRepetidos(array2);
				array2 = Lista.converteToString(Lista.ordenaCrescDouble(Lista.converteToDouble(array2)));

				List<String> array3 = new ArrayList<String>();

				for (int i = 0; i < array2.size(); i++) {
					array3.add(array2.get(i));
					for (int j = 1; j < array1.size(); j++) {
						loop: for (int r = 0; r < lista.size(); r++) {
							if (lista.get(r).getSecao().toString().equals(array2.get(i).toString())
									&& lista.get(r).getMetodo().equals(array1.get(j).toString())) {
								array3.add(lista.get(r).getCorrente().toString());
								break loop;
							}
						}
					}

					try {
						arquivo.writeLine(array3);
						array3.clear();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				arquivo.salva();
			}
		}
	}
}
