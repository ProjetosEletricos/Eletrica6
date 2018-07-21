package br.aplicacao.eletrica.janelas.quadro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Condutor;
import br.aplicacao.eletrica.modelo.projeto.Curto;
import br.aplicacao.eletrica.modelo.projeto.Fonte;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.CondutorService;
import br.aplicacao.eletrica.servico.CurtoService;
import br.aplicacao.eletrica.servico.FonteService;
import br.aplicacao.eletrica.servico.QuadroService;
import br.aplicacao.eletrica.uteis.Numero;

public class QuadroAcaoBotoes implements ActionListener {

	private PrincipalFrm frmPrincipal;;
	private CondutorFrm frmCondutor;
	private CurtoFrm frmCurto;

	public QuadroAcaoBotoes(PrincipalFrm frmPrincipal, CondutorFrm frmCondutor, CurtoFrm frmCurto) {

		this.frmPrincipal = frmPrincipal;
		this.frmCondutor = frmCondutor;
		this.frmCurto = frmCurto;
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frmPrincipal.getBtnExcluirQuadro()) {

			Fonte fonte = frmPrincipal.getFonteControle().getFonte();
			Quadro quadro = frmPrincipal.getQuadroControle().getQuadro();
			fonte.getQuadros().remove(quadro);
			QuadroService.remove(quadro);
			quadro.setCondutor(null);
			quadro.setCurto(null);
			quadro.getCircuitos().clear();

			frmPrincipal.getQuadroControle().setTabelaSelecao(-1);
			frmPrincipal.getQuadroControle()
					.iniciaTabelaQuadros(Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText()));
			frmPrincipal.getQuadroControle().apagaDadosFrm();

		} else if (event.getSource() == frmPrincipal.getBtnSalvarQuadro()) {

			this.salvar();

		} else if (event.getSource() == frmPrincipal.getBtnCopiarQuadro()) {

			frmPrincipal.getLblIdQuadro().repaint();
			this.salvar();

			// ----------------------------------------

		} else if (event.getSource() == frmPrincipal.getBtnCondutorQuadro()) {

			if (Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()) != null
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

			if (Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()) != null
					&& frmPrincipal.getQuadroControle().getQuadro().getCurto().getId() > 0) {

				Curto curto = frmPrincipal.getQuadroControle().getQuadro().getCurto();

				frmCurto.getCurtoControle().abreFrm();
				frmCurto.getCurtoControle().preencheFrm(curto);
			} else {

				frmCurto.getCurtoControle().abreFrm();

			}
		}
	}

	private void adicionaActionListener() {

		frmPrincipal.getBtnCopiarQuadro().addActionListener(this);
		frmPrincipal.getBtnExcluirQuadro().addActionListener(this);
		frmPrincipal.getBtnSalvarQuadro().addActionListener(this);
		frmPrincipal.getBtnCondutorQuadro().addActionListener(this);
		frmPrincipal.getBtnCurtoCirQuadro().addActionListener(this);
	}

	private void salvar() {

		if (Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText()) > 0) {

			Fonte fonte = FonteService.getById(Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText()));
			Quadro quadro = frmPrincipal.getQuadroControle().getDadosFrm();

			if (Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()) == null) {
				CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
				CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				fonte.getQuadros().add(quadro);
				FonteService.salva(fonte);
			} else {

				CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
				CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				QuadroService.salva(quadro);
			}
			frmPrincipal.getQuadroControle()
					.iniciaTabelaQuadros(Numero.stringToInteger(frmPrincipal.getLblIdFonte().getText()));
		}
	}

}
