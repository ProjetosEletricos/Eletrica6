package br.aplicacao.eletrica.janelas.quadro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.Condutor;
import br.aplicacao.eletrica.modelo.Curto;
import br.aplicacao.eletrica.modelo.Fonte;
import br.aplicacao.eletrica.modelo.Quadro;
import br.aplicacao.eletrica.servico.CondutorService;
import br.aplicacao.eletrica.servico.CurtoService;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.QuadroService;
import br.aplicacao.eletrica.uteis.Numero;
import br.aplicacao.eletrica.uteis.TrataID;

public class QuadroAcaoBotoes implements ActionListener {

	private PrincipalFrm frmPrincipal;
	private CondutorFrm frmCondutor;
	private CurtoFrm frmCurto;

	public QuadroAcaoBotoes(PrincipalFrm frmPrincipal, CondutorFrm frmCondutor, CurtoFrm frmCurto) {

		this.frmPrincipal = frmPrincipal;
		this.frmCondutor = frmCondutor;
		this.frmCurto = frmCurto;
		this.adicionaActionListener();
	}

	private void adicionaActionListener() {

		frmPrincipal.getBtnCopiarQuadro().addActionListener(this);
		frmPrincipal.getBtnExcluirQuadro().addActionListener(this);
		frmPrincipal.getBtnSalvarQuadro().addActionListener(this);
		frmPrincipal.getBtnCondutorQuadro().addActionListener(this);
		frmPrincipal.getBtnCurtoCirQuadro().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frmPrincipal.getBtnExcluirQuadro()) {

			Fonte fonte = frmPrincipal.getFonteControle().getFonte();
			Quadro quadro = frmPrincipal.getQuadroControle().getQuadro();
			Quadro quadroPai = (Quadro) frmPrincipal.getCbQuadroPai().getSelectedItem();
			fonte.getQuadros().remove(quadro);
			QuadroService.remove(quadro);
			//quadro.apagar();
			if (quadroPai != null) {
				quadroPai.getQuadros().remove(quadro);
			}

			frmPrincipal.getTableQuadros().clearSelection();
			frmPrincipal.getQuadroControle().iniciaTabelaQuadros(fonte.getQuadros());
			frmPrincipal.getQuadroControle().apagaDadosFrm();

		} else if (event.getSource() == frmPrincipal.getBtnSalvarQuadro()) {

			this.salvar();

		} else if (event.getSource() == frmPrincipal.getBtnCopiarQuadro()) {

			frmPrincipal.getLblIdQuadro().setText("0");
			this.salvar();

			// ----------------------------------------

		} else if (event.getSource() == frmPrincipal.getBtnCondutorQuadro()) {

			if (TrataID.StringToInteger(frmPrincipal.getLblIdQuadro().getText()) != null
					&& frmPrincipal.getQuadroControle().getQuadro().getCondutor().getId() > 0) {

				Condutor condutor = frmPrincipal.getQuadroControle().getQuadro().getCondutor();

				frmCondutor.getCondutorControle().abreFrm();
				frmCondutor.getCondutorControle().iniciaCbs();
				frmCondutor.getCondutorControle().preencheFrm(condutor);

			} else {

				frmCondutor.getCondutorControle().abreFrm();
				frmCondutor.getCondutorControle().iniciaCbs();

			}
		} else if (event.getSource() == frmPrincipal.getBtnCurtoCirQuadro()) {

			if (TrataID.StringToInteger(frmPrincipal.getLblIdQuadro().getText()) != null
					&& frmPrincipal.getQuadroControle().getQuadro().getCurto().getId() > 0) {

				Curto curto = frmPrincipal.getQuadroControle().getQuadro().getCurto();

				frmCurto.getCurtoControle().abreFrm();
				frmCurto.getCurtoControle().preencheFrm(curto);
			} else {

				frmCurto.getCurtoControle().abreFrm();

			}
		}
	}

	private void salvar() {

		if (Integer.valueOf(frmPrincipal.getLblIdFonte().getText()) > 0) {

			Fonte fonte = FonteService.getById(Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText(),0));
			Quadro quadro = frmPrincipal.getQuadroControle().getDadosFrm();
			Quadro quadroPai = (Quadro) frmPrincipal.getCbQuadroPai().getSelectedItem();

			if (quadro.getId() == null) {
				CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
				CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				fonte.addQuadro(quadro);
				FonteService.salva(fonte);
				if (quadroPai != null) {
					quadroPai.getQuadros().add(quadro);
				}

			} else {

				CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
				CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				QuadroService.salva(quadro);
				if (quadroPai != null) {
					quadroPai.getQuadros().add(quadro);
				}
			}
			frmPrincipal.getQuadroControle().apagaDadosFrm();
			frmPrincipal.getQuadroControle().setTabelaSelecao(-1);
			frmPrincipal.getQuadroControle().iniciaTabelaQuadros(fonte.getQuadros());
		}
	}

}
