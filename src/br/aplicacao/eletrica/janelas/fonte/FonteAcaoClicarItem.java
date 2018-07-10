package br.aplicacao.eletrica.janelas.fonte;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;

public class FonteAcaoClicarItem implements MouseListener {

	private PrincipalFrm frm;
	@SuppressWarnings("unused")
	private FonteControle controle;

	public FonteAcaoClicarItem(PrincipalFrm frm) {

		this.frm = frm;
		
		this.adicionarMouseListener();
	}

	protected void adicionarMouseListener() {

		frm.getTableFontes().addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getClickCount() == 2) {

			/*this.controle = frm.getFonteControle();
			 * Integer id =
			 * Integer.valueOf(frm.getTableFontes().getValueAt(frm.getTableFontes().
			 * getSelectedRow(), 0).toString()); Fonte fonte = FonteService.getById(id);
			 * 
			 * FonteFrm fonteFrm = new FonteFrm(fonte.getId());
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
