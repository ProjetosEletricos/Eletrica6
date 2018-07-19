package br.aplicacao.eletrica.janelas.curto;

import javax.swing.UIManager;

import br.aplicacao.eletrica.janelas.main.Base;
import br.aplicacao.eletrica.modelo.projeto.Curto;
import br.aplicacao.eletrica.uteis.Numero;

public class CurtoControle {

	private CurtoFrm frm;
	private Curto curto =new Curto();

	public CurtoControle(CurtoFrm frm) {
		this.frm = frm;
		this.adicionaInternalFrameListener();
	}

	public void abreFrm() {
		
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			Base.desktopPane.add(frm);
			frm.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void adicionaInternalFrameListener() {
		new CurtoAcaoFechar(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtCorrenteCurto().setText("");
		frm.getTxtTempAdmissRegime().setText("");
		frm.getTxtTempMaxCurto().setText("");
		frm.getTxtTempoElimDef().setText("");
		frm.getLblIdCurto().setText(null);
	}

	public Curto atualizaDados() {

		curto.setId(Numero.stringToInteger(frm.getLblIdCurto().getText()));
		curto.setCorrenteCurto(Numero.stringToDouble(frm.getTxtCorrenteCurto().getText()));
		curto.setTempAdmissRegime(Numero.stringToDouble(frm.getTxtTempAdmissRegime().getText()));
		curto.setTempMaxCurto(Numero.stringToDouble(frm.getTxtTempMaxCurto().getText()));
		curto.setTempoElimDef(Numero.stringToDouble(frm.getTxtTempoElimDef().getText()));

		return curto;
	}

	public void preencheFrm(Curto curto) {

		if (curto != null) {
			this.curto = curto;

			frm.getLblIdCurto().setText(curto.getId().toString());
			frm.getTxtCorrenteCurto().setText(Numero.decimal(curto.getCorrenteCurto(), "##,00"));
			frm.getTxtTempAdmissRegime().setText(Numero.decimal(curto.getTempAdmissRegime(), "##,00"));
			frm.getTxtTempMaxCurto().setText(Numero.decimal(curto.getTempMaxCurto(), "##,00"));
			frm.getTxtTempoElimDef().setText(Numero.decimal(curto.getTempoElimDef(), "##,00"));
		}
	}

	public Curto getCurto() {
		return curto;
	}

	public void setCurto(Curto curto) {
		this.curto = curto;
	}

}
