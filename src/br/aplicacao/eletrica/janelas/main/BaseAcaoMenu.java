package br.aplicacao.eletrica.janelas.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.UIManager;

import br.aplicacao.eletrica.janelas.tabelas.CapacidadeCorrente;
import br.aplicacao.eletrica.janelas.tabelas.TabelaModeloFrm;
import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;
import br.aplicacao.eletrica.uteis.tableModel.GenericTableModel;

public class BaseAcaoMenu implements ActionListener {
	private Base frm;
	private TabelaModeloFrm tabelaFrm;

	public BaseAcaoMenu(Base frm, TabelaModeloFrm tabelaFrm) {
		this.frm = frm;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frm.getMntmCapacidade1().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frm.getMntmCapacidade1()) {

			List<CapacidadeCorrente> lista = CapacidadeCorrenteService.getAll();
			tabelaFrm = new TabelaModeloFrm();
			
			try {
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				Base.desktopPane.add(tabelaFrm);
				tabelaFrm.setVisible(true);
				tabelaFrm.setPosicao();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
			GenericTableModel<CapacidadeCorrente> tabela = new GenericTableModel<>(lista, CapacidadeCorrente.class);
			tabelaFrm.getTable().setModel(tabela);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

}
