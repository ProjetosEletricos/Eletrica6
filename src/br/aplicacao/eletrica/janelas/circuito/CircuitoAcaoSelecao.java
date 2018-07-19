package br.aplicacao.eletrica.janelas.circuito;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import br.aplicacao.eletrica.janelas.main.PrincipalFrm;
import br.aplicacao.eletrica.modelo.projeto.Circuito;
import br.aplicacao.eletrica.uteis.Numero;

public class CircuitoAcaoSelecao implements ListSelectionListener {

	private PrincipalFrm frm;

	public CircuitoAcaoSelecao(PrincipalFrm frm) {
		
		this.frm = frm;
		this.AdicionarListSelectionListener();
	}

	private void AdicionarListSelectionListener() {

		frm.getTableCircuitos().getSelectionModel().addListSelectionListener(this);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		
		int firstIndex = e.getFirstIndex();


		if (firstIndex >= 0 && !(Numero.stringToInteger(frm.getLblIdQuadro().getText()) == null)) {

			Circuito circuito = frm.getCircuitoControle().getTabela().loadItem(firstIndex);
			frm.getCircuitoControle().preencheFrm(circuito);
			frm.getCircuitoControle().setTabelaSelecao(firstIndex);
		}

	}
}
