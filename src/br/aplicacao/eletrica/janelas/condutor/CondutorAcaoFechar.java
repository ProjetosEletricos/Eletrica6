package br.aplicacao.eletrica.janelas.condutor;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class CondutorAcaoFechar implements InternalFrameListener {

	private CondutorFrm frm;
	private CondutorControle controle;

	public CondutorAcaoFechar(CondutorFrm frm) {

		
		this.frm = frm;
		
		this.addInternalFrameListener();
	}

	private void addInternalFrameListener() {
		frm.addInternalFrameListener(this);

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		this.controle = frm.getCondutorControle();
		controle.atualizaDados();
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {

	}

	@Override
	public void internalFrameIconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeiconified(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameActivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameDeactivated(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

}
