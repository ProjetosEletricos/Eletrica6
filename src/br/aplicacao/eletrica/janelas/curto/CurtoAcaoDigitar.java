package br.aplicacao.eletrica.janelas.curto;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import br.aplicacao.eletrica.uteis.ApenasNumero;

public class CurtoAcaoDigitar implements KeyListener {

	private CurtoFrm frm;

	public CurtoAcaoDigitar(CurtoFrm frm) {

		this.frm = frm;
		this.adicionarKeyListener();
	}

	private void adicionarKeyListener() {

		frm.getTxtCorrenteCurto().addKeyListener(this);
		frm.getTxtTempAdmissRegimeCurto().addKeyListener(this);
		frm.getTxtTempMaxCurto().addKeyListener(this);
		frm.getTxtTempoElimDefCurto().addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent event) {

		ApenasNumero.campo(event, "txtCorrenteCurto");
		ApenasNumero.campo(event, "txtTempAdmissRegimeCurto");
		ApenasNumero.campo(event, "txtTempMaxCurto");
		ApenasNumero.campo(event, "txtTempoElimDefCurto");
	}

}
