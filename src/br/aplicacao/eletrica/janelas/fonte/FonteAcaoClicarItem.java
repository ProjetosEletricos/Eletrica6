package br.aplicacao.eletrica.janelas.fonte;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.uteis.Numero;

public class FonteAcaoClicarItem implements MouseListener {

	private PrincipalFrm frm;

	public FonteAcaoClicarItem(PrincipalFrm frm) {

		this.frm = frm;
		this.adicionarMouseListener();
	}

	protected void adicionarMouseListener() {

		frm.getAbas().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (frm.getAbas().getSelectedComponent() == frm.getPanelFonte()) {
			if (e.getClickCount() == 1) {
				Integer idProjeto = Numero.stringToInteger(frm.getLblIdProjeto().getText(),0);
				if (idProjeto != null) {
					//frm.getFonteControle().apagaDadosFrm();
					frm.getFonteControle().iniciaTabelaFontes(frm.getProjetoControle().getProjeto().getFontes());
				}
			}
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
