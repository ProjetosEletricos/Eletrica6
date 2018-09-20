package br.aplicacao.eletrica.janelas.curto;

import javax.swing.UIManager;

import br.aplicacao.eletrica.janelas.main.Base;
import br.aplicacao.eletrica.modelo.Curto;
import br.aplicacao.eletrica.uteis.Numero;

public class CurtoControle {

	private CurtoFrm frm;
	private Curto curto =new Curto();

	public CurtoControle(CurtoFrm frm) {
		this.frm = frm;
		this.adicionaInternalFrameListener();
		this.adicionarKeyListener();
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
	private void adicionarKeyListener() {
		new CurtoAcaoDigitar(frm);
	}

	public void apagaDadosFrm() {

		frm.getTxtCorrenteCurto().setText("");
		frm.getTxtTempAdmissRegimeCurto().setText("");
		frm.getTxtTempMaxCurto().setText("");
		frm.getTxtTempoElimDefCurto().setText("");
		frm.getLblIdCurto().setText(null);
	}

	public Curto atualizaDados() {
		
		Curto curto = new Curto();

		curto.setId(Numero.stringToInteger(frm.getLblIdCurto().getText(),0));
		curto.setCorrenteCurto(Numero.stringToDouble(frm.getTxtCorrenteCurto().getText(),0));
		curto.setTempAdmissRegime(Numero.stringToDouble(frm.getTxtTempAdmissRegimeCurto().getText(),0));
		curto.setTempMaxCurto(Numero.stringToDouble(frm.getTxtTempMaxCurto().getText(),0));
		curto.setTempoElimDef(Numero.stringToDouble(frm.getTxtTempoElimDefCurto().getText(),0));

		this.curto = curto;
		return curto;
	}

	public void preencheFrm(Curto curto) {

		if (curto != null) {
			this.curto = curto;

			frm.getLblIdCurto().setText(curto.getId().toString());
			frm.getTxtCorrenteCurto().setText(Numero.decimal(curto.getCorrenteCurto(), "##,00"));
			frm.getTxtTempAdmissRegimeCurto().setText(Numero.decimal(curto.getTempAdmissRegime(), "##,00"));
			frm.getTxtTempMaxCurto().setText(Numero.decimal(curto.getTempMaxCurto(), "##,00"));
			frm.getTxtTempoElimDefCurto().setText(Numero.decimal(curto.getTempoElimDef(), "##,00"));
		}
	}

	public Curto getCurto() {
		return curto;
	}

	public void setCurto(Curto curto) {
		this.curto = curto;
	}

}
