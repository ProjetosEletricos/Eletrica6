package br.aplicacao.eletrica.janelas.circuito;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.aplicacao.eletrica.janelas.condutor.CondutorFrm;
import br.aplicacao.eletrica.janelas.curto.CurtoFrm;
import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Circuito;
import br.aplicacao.eletrica.modelo.projeto.Condutor;
import br.aplicacao.eletrica.modelo.projeto.Curto;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.CircuitoService;
import br.aplicacao.eletrica.servico.CondutorService;
import br.aplicacao.eletrica.servico.CurtoService;
import br.aplicacao.eletrica.servico.QuadroService;
import br.aplicacao.eletrica.uteis.Numero;

public class CircuitoAcaoBotoes implements ActionListener {

	private PrincipalFrm frmPrincipal;
	private CondutorFrm frmCondutor;
	private CurtoFrm frmCurto;

	public CircuitoAcaoBotoes(PrincipalFrm frmPrincipal, CondutorFrm frmCondutor, CurtoFrm frmCurto) {

		this.frmPrincipal = frmPrincipal;
		this.frmCondutor = frmCondutor;
		this.frmCurto = frmCurto;
		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		if (event.getSource() == frmPrincipal.getBtnExcluirCircuito()) {

			Quadro quadro = frmPrincipal.getQuadroControle().getQuadro();
			Circuito circuito = frmPrincipal.getCircuitoControle().getCircuito();
			quadro.getCircuitos().remove(circuito);
			CircuitoService.remove(circuito);
			circuito.setCondutor(null);
			circuito.setCurto(null);
			circuito.getEquipamentos().clear();

			frmPrincipal.getCircuitoControle().setTabelaSelecao(-1);
			frmPrincipal.getCircuitoControle()
					.iniciaTabelaCircuitos(Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()));
			frmPrincipal.getCircuitoControle().apagaDadosFrm();

		} else if (event.getSource() == frmPrincipal.getBtnSalvarCircuito()) {

			this.salvar();

		} else if (event.getSource() == frmPrincipal.getBtnCopiarCircuito()) {

			frmPrincipal.getLblIdCircuito().repaint();
			this.salvar();

			// ----------------------------------------------------------------------------------------------------------

		} else if (event.getSource() == frmPrincipal.getBtnCondutorCircuito()) {

			if (Numero.stringToInteger(frmPrincipal.getLblIdCircuito().getText()) != null
					&& frmPrincipal.getCircuitoControle().getCircuito().getCondutor().getId() > 0) {

				Condutor condutor = frmPrincipal.getCircuitoControle().getCircuito().getCondutor();

				frmCondutor.getCondutorControle().abreFrm();
				frmCondutor.getCondutorControle().iniciaCbs();
				frmCondutor.getCondutorControle().preencheFrm(condutor);

			} else {

				frmCondutor.getCondutorControle().abreFrm();
				frmCondutor.getCondutorControle().iniciaCbs();

			}
		} else if (event.getSource() == frmPrincipal.getBtnCurtoCirCircuito()) {

			if (Numero.stringToInteger(frmPrincipal.getLblIdCircuito().getText()) != null
					&& frmPrincipal.getCircuitoControle().getCircuito().getCurto().getId() > 0) {

				Curto curto = frmPrincipal.getCircuitoControle().getCircuito().getCurto();

				frmCurto.getCurtoControle().abreFrm();
				frmCurto.getCurtoControle().preencheFrm(curto);
			} else {

				frmCurto.getCurtoControle().abreFrm();

			}
		}
	}

	private void adicionaActionListener() {

		frmPrincipal.getBtnCopiarCircuito().addActionListener(this);
		frmPrincipal.getBtnExcluirCircuito().addActionListener(this);
		frmPrincipal.getBtnSalvarCircuito().addActionListener(this);
		frmPrincipal.getBtnCondutorCircuito().addActionListener(this);
		frmPrincipal.getBtnCurtoCirCircuito().addActionListener(this);
	}

	private void salvar() {

		if (Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()) > 0) {

			Quadro quadro = QuadroService.getById(Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()));
			Circuito circuito = frmPrincipal.getCircuitoControle().getDadosFrm();

			if (Numero.stringToInteger(frmPrincipal.getLblIdCircuito().getText()) == null) {
				CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
				CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				quadro.addCircuito(circuito);
				QuadroService.salva(quadro);
			} else {

				CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
				CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				CircuitoService.salva(circuito);
			}

			frmPrincipal.getCircuitoControle()
					.iniciaTabelaCircuitos(Numero.stringToInteger(frmPrincipal.getLblIdQuadro().getText()));
		}
	}
}
