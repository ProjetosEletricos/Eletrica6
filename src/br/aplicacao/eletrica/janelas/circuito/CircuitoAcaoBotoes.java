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

public class CircuitoAcaoBotoes implements ActionListener {

	private PrincipalFrm frmPrincipal;
	private CircuitoControle circuitoControle;

	private CondutorFrm frmCondutor = new CondutorFrm();
	private CurtoFrm frmCurto = new CurtoFrm();

	public CircuitoAcaoBotoes(PrincipalFrm frmPrincipal) {
		this.frmPrincipal = frmPrincipal;

		this.adicionaActionListener();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		this.circuitoControle = frmPrincipal.getCircuitoControle();

		if (event.getSource() == frmPrincipal.getBtnExcluirCircuito()) {
			int row = circuitoControle.getTabelaSelecao();

			if (row >= 0) {

				QuadroService.getById(circuitoControle.getIdQuadro()).getCircuitos()
						.remove(circuitoControle.getTabela().loadItem(row));

				circuitoControle.setTabelaSelecao(-1);
				circuitoControle.iniciaTabelaCircuitos(circuitoControle.getIdQuadro());
				circuitoControle.apagaDadosFrm();
			}
		} else if (event.getSource() == frmPrincipal.getBtnSalvarCircuito()) {
			this.salvar();
		} else if (event.getSource() == frmPrincipal.getBtnCopiarCircuito()) {
			frmPrincipal.getLblIdQuadro().setText("0");
			this.salvar();
		} else if (event.getSource() == frmPrincipal.getBtnCondutorCircuito()) {

			if (circuitoControle.getIdCircuito() > 0) {

				Condutor condutor = CircuitoService.getById(circuitoControle.getIdCircuito()).getCondutor();

				frmCondutor.getCondutorControle().abreFrm();
				frmCondutor.getCondutorControle().iniciaCbs();
				frmCondutor.getCondutorControle().preencheFrm(condutor);

			} else {

				frmCondutor.getCondutorControle().abreFrm();
				frmCondutor.getCondutorControle().iniciaCbs();

			}
		} else if (event.getSource() == frmPrincipal.getBtnCurtoCirCircuito()) {

			if (circuitoControle.getIdCircuito() > 0) {

				Curto curto = CircuitoService.getById(circuitoControle.getIdCircuito()).getCurto();

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

		if (circuitoControle.getIdQuadro() > 0) {
			Quadro quadro = QuadroService.getById(circuitoControle.getIdQuadro());
			Circuito circuito = circuitoControle.getDadosFrm(frmCondutor.getCondutorControle(),
					frmCurto.getCurtoControle());
			if (!(circuito.equals(null))) {

				if (circuitoControle.getIdCircuito() == 0) {
					quadro.addCircuito(circuito);
					QuadroService.salva(quadro);
				} else {
					CircuitoService.salva(circuito);
					CondutorService.salva(frmCondutor.getCondutorControle().getCondutor());
					CurtoService.salva(frmCurto.getCurtoControle().getCurto());
				}
			}
			circuitoControle.iniciaTabelaCircuitos(circuitoControle.getIdQuadro());
		}
	}
}
