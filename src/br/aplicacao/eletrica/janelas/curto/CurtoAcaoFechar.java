package br.aplicacao.eletrica.janelas.curto;

import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class CurtoAcaoFechar implements InternalFrameListener {

	private CurtoFrm frm;

	public CurtoAcaoFechar(CurtoFrm frm) {

		this.frm = frm;
		this.addInternalFrameListener();
	}

	private void addInternalFrameListener() {
		frm.addInternalFrameListener(this);

	}

	@Override
	public void internalFrameClosed(InternalFrameEvent e) {
		frm.getCurtoControle().atualizaDados();
	}

	@Override
	public void internalFrameOpened(InternalFrameEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void internalFrameClosing(InternalFrameEvent e) {
		// TODO Auto-generated method stub

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
