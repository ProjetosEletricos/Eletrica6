package br.aplicacao.eletrica.janelas.tabelas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFileChooser;

import br.aplicacao.eletrica.uteis.LerCSV;

public class TabelaAcaoClicarItem implements MouseListener {

	private TabelaModeloFrm frm;

	public TabelaAcaoClicarItem(TabelaModeloFrm frm) {

		this.frm = frm;
		this.adicionarMouseListener();
	}

	protected void adicionarMouseListener() {

		frm.getMntmCarregarCSV().addMouseListener(this);
		frm.getMntmSalvarCsv().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Testetetetet: ");
		//if (e.getSource() == frm.getMntmCarregarCSV()) {
			//if (e.getClickCount() == 1) {
				JFileChooser selecao = new JFileChooser();
				selecao.setFileFilter(null);
				int opcao = selecao.showOpenDialog(null);

				if (opcao == JFileChooser.APPROVE_OPTION) {

					LerCSV dados = new LerCSV(selecao.getSelectedFile().toString());
					String[][] tabela = dados.toMatriz();
					Util.salvarMatrizToTabelaCapacidadeCorrente(tabela);
					System.out.println("Passou por aqui novamente");
					System.out.println("Passou por aqui");
				}
		//	}
	//	}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
