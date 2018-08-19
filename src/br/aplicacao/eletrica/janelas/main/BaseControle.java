package br.aplicacao.eletrica.janelas.main;

public class BaseControle {

	private Base frmBase;

	public BaseControle(Base frm) {
		this.frmBase = frm;
		adicionaActionListener();
		adicionaListSelectionListener();
		adicionaMouseListener();
		adicionaChangeListener();
		adicionaKeyListener();
	}

	private void adicionaActionListener() {
		new BaseAcaoMenu(frmBase);
	}

	private void adicionaChangeListener() {
		// new FonteAcaoAba(frm);
	}

	private void adicionaKeyListener() {
		// new FonteAcaoDigitar(frm);
	}

	private void adicionaListSelectionListener() {
		// new FonteAcaoSelecao(frm);
	}

	private void adicionaMouseListener() {
		// new FonteAcaoClicarItem(frm);
	}

}
