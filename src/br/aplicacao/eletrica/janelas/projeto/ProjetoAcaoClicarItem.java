package br.aplicacao.eletrica.janelas.projeto;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class ProjetoAcaoClicarItem implements MouseListener {

	private PrincipalFrm frm;
	//private ProjetoControle controleProjeto;

	public ProjetoAcaoClicarItem(PrincipalFrm frm) {

		//this.controleProjeto = frm.getProjetoControle();
		this.frm = frm;
		this.adicionarMouseListener();
	}

	private void adicionarMouseListener() {

		frm.getTableProjetos().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {

			/*
			 * Integer id =
			 * Integer.valueOf(frm.getTableProjetos().getValueAt(frm.getTableProjetos().
			 * getSelectedRow(), 0).toString()); Projeto projeto =
			 * ProjetoService.getById(id);
			 * 
			 * FonteFrm fonteFrm = new FonteFrm(projeto.getId());
			 * 
			 * Principal.desktopPane.add(fonteFrm); fonteFrm.setVisible(true);
			 * fonteFrm.setPosicao();
			 * 
			 * this.frm.dispose();
			 */

		}
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

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
