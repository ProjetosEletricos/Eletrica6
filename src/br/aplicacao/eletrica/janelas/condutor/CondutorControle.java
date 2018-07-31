package br.aplicacao.eletrica.janelas.condutor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;

import br.aplicacao.eletrica.janelas.main.Base;
import br.aplicacao.eletrica.modelo.projeto.Condutor;
import br.aplicacao.eletrica.uteis.Numero;

public class CondutorControle {

	private CondutorFrm frm;
	private Condutor condutor = new Condutor();

	public CondutorControle(CondutorFrm frm) {
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
		new CondutorAcaoFechar(frm);
	}
	private void adicionarKeyListener() {
		new CondutorAcaoDigitar(frm);
	}

	private void iniciaCbInstalacaoCondutor() {
		frm.getCbInstalacaoCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbInstalacaoCondutor().addItem("A1");
		frm.getCbInstalacaoCondutor().addItem("B1");
		frm.getCbInstalacaoCondutor().setSelectedIndex(0);
	}

	private void iniciaCbTempAmbienteCondutor() {
		frm.getCbTempAmbienteCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbTempAmbienteCondutor().addItem("30");
		frm.getCbTempAmbienteCondutor().addItem("35");
		frm.getCbTempAmbienteCondutor().setSelectedIndex(0);
	}

	private void iniciaCbMaterialCondutor() {
		frm.getCbMaterialCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbMaterialCondutor().addItem("Cobre");
		frm.getCbMaterialCondutor().addItem("Alumínio");
		frm.getCbMaterialCondutor().setSelectedIndex(0);
	}

	private void iniciaCbIsolacaoCondutor() {
		frm.getCbIsolacaoCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbIsolacaoCondutor().addItem("PVC");
		frm.getCbIsolacaoCondutor().addItem("XLPE");
		frm.getCbIsolacaoCondutor().setSelectedIndex(0);
	}

	private void iniciaCbEnterradoCondutor() {
		frm.getCbEnterradoCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbEnterradoCondutor().addItem("Sim");
		frm.getCbEnterradoCondutor().addItem("Não");
		frm.getCbEnterradoCondutor().setSelectedIndex(0);
	}

	private void iniciaCbEspacaCabosCondutor() {
		frm.getCbEspacaCabosCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbEspacaCabosCondutor().addItem("Modo1");
		frm.getCbEspacaCabosCondutor().addItem("Modo2");
		frm.getCbEspacaCabosCondutor().setSelectedIndex(0);
	}

	private void iniciaCbMultipolarCondutor() {
		frm.getCbMultipolarCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbMultipolarCondutor().addItem("Sim");
		frm.getCbMultipolarCondutor().addItem("Não");
		frm.getCbMultipolarCondutor().setSelectedIndex(0);
	}

	private void iniciaCbAgrupamentoCondutor() {
		frm.getCbAgrupamentoCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbAgrupamentoCondutor().addItem("Modo1");
		frm.getCbAgrupamentoCondutor().addItem("Modo2");
		frm.getCbAgrupamentoCondutor().setSelectedIndex(0);
	}

	private void iniciaCbBitolSucessCondutor() {
		frm.getCbBitolSucessCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbBitolSucessCondutor().addItem("Sim");
		frm.getCbBitolSucessCondutor().addItem("Não");
		frm.getCbBitolSucessCondutor().setSelectedIndex(0);
	}

	private void iniciaCbNcirAgrupadosCondutor() {
		frm.getCbNcirAgrupadosCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbNcirAgrupadosCondutor().addItem("1");
		frm.getCbNcirAgrupadosCondutor().addItem("2");
		frm.getCbNcirAgrupadosCondutor().setSelectedIndex(0);
	}

	private void iniciaCbNCamadasCondutor() {
		frm.getCbNCamadasCondutor().setModel(new DefaultComboBoxModel<>());
		frm.getCbNCamadasCondutor().addItem("1");
		frm.getCbNCamadasCondutor().addItem("2");
		frm.getCbNCamadasCondutor().setSelectedIndex(0);
	}

	public void iniciaCbs() {

		iniciaCbNCamadasCondutor();
		iniciaCbNcirAgrupadosCondutor();
		iniciaCbBitolSucessCondutor();
		iniciaCbAgrupamentoCondutor();
		iniciaCbMultipolarCondutor();
		iniciaCbEspacaCabosCondutor();
		iniciaCbEnterradoCondutor();
		iniciaCbIsolacaoCondutor();
		iniciaCbMaterialCondutor();
		iniciaCbTempAmbienteCondutor();
		iniciaCbInstalacaoCondutor();
	}

	public void apagaDadosFrm() {

		frm.getTxtQuedaTensaoCondutor().setText("");
		frm.getTxtResistTermicaCondutor().setText("");
		frm.getCbTempAmbienteCondutor().setSelectedIndex(-1);
		frm.getTxtComprimentoCondutor().setText("");
		frm.getCbInstalacaoCondutor().setSelectedIndex(-1);
		frm.getCbMaterialCondutor().setSelectedIndex(-1);
		frm.getCbIsolacaoCondutor().setSelectedIndex(-1);
		frm.getCbEnterradoCondutor().setSelectedIndex(-1);
		frm.getCbEspacaCabosCondutor().setSelectedIndex(-1);
		frm.getCbMultipolarCondutor().setSelectedIndex(-1);
		frm.getCbAgrupamentoCondutor().setSelectedIndex(-1);
		frm.getCbBitolSucessCondutor().setSelectedIndex(-1);
		frm.getCbNcirAgrupadosCondutor().setSelectedIndex(-1);
		frm.getCbNCamadasCondutor().setSelectedIndex(-1);
		frm.getLblIdCondutor().setText(null);
	}

	public Condutor getDadosFrm() {
		
		Condutor condutor = new Condutor();
		condutor = this.condutor;

		condutor.setId(Numero.stringToInteger(frm.getLblIdCondutor().getText()));
		condutor.setQuedaTensao(Numero.stringToDouble(frm.getTxtQuedaTensaoCondutor().getText()));
		condutor.setResistiTermica(Numero.stringToDouble(frm.getTxtResistTermicaCondutor().getText()));
		condutor.setTemperatura(
				Numero.stringToDouble(frm.getCbTempAmbienteCondutor().getModel().getSelectedItem().toString()));
		condutor.setComprimento(Numero.stringToDouble(frm.getTxtComprimentoCondutor().getText()));
		condutor.setModoInstalacao(frm.getCbInstalacaoCondutor().getModel().getSelectedItem().toString());
		condutor.setMaterial(frm.getCbMaterialCondutor().getModel().getSelectedItem().toString());
		condutor.setIsolacao(frm.getCbIsolacaoCondutor().getModel().getSelectedItem().toString());
		condutor.setEnterrado(frm.getCbEnterradoCondutor().getModel().getSelectedItem().toString());
		condutor.setEspacoCabos(frm.getCbEspacaCabosCondutor().getModel().getSelectedItem().toString());
		condutor.setMultipolar(frm.getCbMultipolarCondutor().getModel().getSelectedItem().toString());
		condutor.setFormaAgrupa(frm.getCbAgrupamentoCondutor().getModel().getSelectedItem().toString());
		condutor.setBitolaSucessiva(frm.getCbBitolSucessCondutor().getModel().getSelectedItem().toString());
		condutor.setnCirAgrupa(
				Integer.parseInt(frm.getCbNcirAgrupadosCondutor().getModel().getSelectedItem().toString()));
		condutor.setnCamadas(Integer.parseInt(frm.getCbNCamadasCondutor().getModel().getSelectedItem().toString()));

		return condutor;
	}

	public void preencheFrm(Condutor condutor) {

		if (condutor != null) {
			this.condutor = condutor;

			frm.getLblIdCondutor().setText(condutor.getId().toString());
			frm.getTxtQuedaTensaoCondutor().setText(Numero.decimal(condutor.getQuedaTensao(), "##,00"));
			frm.getTxtResistTermicaCondutor().setText(Numero.decimal(condutor.getResistiTermica(), "##,00"));
			frm.getCbTempAmbienteCondutor().getModel()
					.setSelectedItem(Numero.decimal(condutor.getTemperatura(), "##,00"));
			frm.getTxtComprimentoCondutor().setText(Numero.decimal(condutor.getComprimento(), "##,00"));
			frm.getCbInstalacaoCondutor().getModel().setSelectedItem(condutor.getModoInstalacao());
			frm.getCbMaterialCondutor().getModel().setSelectedItem(condutor.getMaterial());
			frm.getCbIsolacaoCondutor().getModel().setSelectedItem(condutor.getIsolacao());
			frm.getCbEnterradoCondutor().getModel().setSelectedItem(condutor.getEnterrado());
			frm.getCbEspacaCabosCondutor().getModel().setSelectedItem(condutor.getEspacoCabos());
			frm.getCbMultipolarCondutor().getModel().setSelectedItem(condutor.getMultipolar());
			frm.getCbAgrupamentoCondutor().getModel().setSelectedItem(condutor.getFormaAgrupa());
			frm.getCbBitolSucessCondutor().getModel().setSelectedItem(condutor.getBitolaSucessiva());
			frm.getCbNcirAgrupadosCondutor().getModel().setSelectedItem(condutor.getnCirAgrupa());
			frm.getCbNCamadasCondutor().getModel().setSelectedItem(condutor.getnCamadas());

		}
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

}
