package br.aplicacao.eletrica.janelas.condutor;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class CondutorFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CondutorControle condutorControle;

	private JPanel contentPane;
	private JLabel lblIdCondutor;
	private JLabel lblMaterial;
	private JComboBox<String> cbMaterialCondutor;
	private JComboBox<String> cbEnterradoCondutor;
	private JTextField txtComprimentoCondutor;
	private JTextField txtQuedaTensaoCondutor;

	private JComboBox<String> cbIsolacaoCondutor;

	private JComboBox<String> cbAgrupamentoCondutor;

	private JComboBox<String> cbMultipolarCondutor;

	private JComboBox<String> cbEspacaCabosCondutor;

	private JComboBox<String> cbInstalacaoCondutor;

	private JComboBox<String> cbBitolSucessCondutor;

	private JComboBox<String> cbNcirAgrupadosCondutor;

	private JComboBox<String> cbNCamadasCondutor;

	private JComboBox<String> cbTempAmbienteCondutor;
	private JTextField txtResistTermicaCondutor;

	public CondutorFrm() {

		setTitle("Condutor");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 513, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 503, 295);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(12, 12, 481, 275);
		panel_5.add(panel);
		panel.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][][]"));

		JLabel lblEnterrado = new JLabel("Enterrado:");
		panel.add(lblEnterrado, "cell 0 0,alignx left");

		cbEnterradoCondutor = new JComboBox<String>();
		cbEnterradoCondutor.setName("cbEnterradoCondutor");
		panel.add(cbEnterradoCondutor, "cell 1 0,growx");

		lblMaterial = new JLabel("Material:");
		panel.add(lblMaterial, "cell 2 0,alignx trailing");

		cbMaterialCondutor = new JComboBox<String>();
		cbMaterialCondutor.setName("cbMaterialCondutor");
		panel.add(cbMaterialCondutor, "cell 3 0,growx");

		JLabel lblIsolao = new JLabel("Isolação:");
		panel.add(lblIsolao, "cell 0 1,alignx left");

		cbIsolacaoCondutor = new JComboBox<String>();
		cbIsolacaoCondutor.setName("cbIsolacaoCondutor");
		panel.add(cbIsolacaoCondutor, "cell 1 1,growx,aligny bottom");

		JLabel lblAgrupamento = new JLabel("Agrupamento:");
		panel.add(lblAgrupamento, "cell 2 1,alignx trailing");

		cbAgrupamentoCondutor = new JComboBox<String>();
		cbAgrupamentoCondutor.setName("cbAgrupamentoCondutor");
		panel.add(cbAgrupamentoCondutor, "cell 3 1,growx");

		JLabel lblMultipolar = new JLabel("Multipolar:");
		panel.add(lblMultipolar, "cell 0 2,alignx left");

		cbMultipolarCondutor = new JComboBox<String>();
		cbMultipolarCondutor.setName("cbMultipolarCondutor");
		panel.add(cbMultipolarCondutor, "cell 1 2,growx");

		JLabel lblEspaocabos = new JLabel("Espaço/Cabos:");
		panel.add(lblEspaocabos, "cell 2 2,alignx trailing");

		cbEspacaCabosCondutor = new JComboBox<String>();
		cbEspacaCabosCondutor.setName("cbEspacaCabosCondutor");
		panel.add(cbEspacaCabosCondutor, "cell 3 2,growx");

		JLabel lblInstalao = new JLabel("Instalação:");
		panel.add(lblInstalao, "cell 0 3,alignx left");

		cbInstalacaoCondutor = new JComboBox<String>();
		cbInstalacaoCondutor.setName("cbInstalacaoCondutor");
		panel.add(cbInstalacaoCondutor, "cell 1 3,growx");

		JLabel lblBitolaSucess = new JLabel("Bitola/Sucessiva:");
		panel.add(lblBitolaSucess, "cell 2 3,alignx trailing");

		cbBitolSucessCondutor = new JComboBox<String>();
		cbBitolSucessCondutor.setName("cbBitolSucessCondutor");
		panel.add(cbBitolSucessCondutor, "cell 3 3,growx");

		JLabel lblNCirAgrupados = new JLabel("N° cir. agrupados:");
		panel.add(lblNCirAgrupados, "cell 0 4,alignx left");

		cbNcirAgrupadosCondutor = new JComboBox<String>();
		cbNcirAgrupadosCondutor.setName("cbNcirAgrupadosCondutor");
		panel.add(cbNcirAgrupadosCondutor, "cell 1 4,growx");

		JLabel lblNCamadas = new JLabel("N° camadas:");
		panel.add(lblNCamadas, "cell 2 4,alignx trailing");

		cbNCamadasCondutor = new JComboBox<String>();
		cbNCamadasCondutor.setName("cbNCamadasCondutor");
		panel.add(cbNCamadasCondutor, "cell 3 4,growx");

		JLabel lblTemperaturaAmb = new JLabel("Temperatura amb.:");
		panel.add(lblTemperaturaAmb, "cell 0 5,alignx left");

		cbTempAmbienteCondutor = new JComboBox<String>();
		cbTempAmbienteCondutor.setName("cbTempAmbienteCondutor");
		panel.add(cbTempAmbienteCondutor, "cell 1 5,growx");

		JLabel lblRest = new JLabel("Resist/Térmica:");
		panel.add(lblRest, "cell 2 5,alignx trailing");

		txtResistTermicaCondutor = new JTextField();
		txtResistTermicaCondutor.setName("txtResistTermicaCondutor");
		panel.add(txtResistTermicaCondutor, "cell 3 5,growx");
		txtResistTermicaCondutor.setColumns(10);

		JLabel lblQuedaDeTenso = new JLabel("Queda de tensão:");
		panel.add(lblQuedaDeTenso, "cell 0 6,alignx left");

		txtQuedaTensaoCondutor = new JTextField();
		txtQuedaTensaoCondutor.setName("txtQuedaTensaoCondutor");
		panel.add(txtQuedaTensaoCondutor, "cell 1 6,growx");
		txtQuedaTensaoCondutor.setColumns(10);

		JLabel lblComprimento = new JLabel("Comprimento:");
		panel.add(lblComprimento, "cell 2 6,alignx trailing");

		txtComprimentoCondutor = new JTextField();
		txtComprimentoCondutor.setName("txtComprimentoCondutor");
		panel.add(txtComprimentoCondutor, "cell 3 6,growx");
		txtComprimentoCondutor.setColumns(10);

		lblIdCondutor = new JLabel("0");
		lblIdCondutor.setName("lblIdCondutor");
		lblIdCondutor.setBounds(421, 0, 70, 15);
		panel_5.add(lblIdCondutor);

		// -------------------------Controle-----------------------
		this.Listen();
	}

	private void Listen() {

		condutorControle = new CondutorControle(this);

	}

	public JLabel getLblIdCondutor() {
		return lblIdCondutor;
	}

	public void setLblIdCondutor(JLabel lblIdCondutor) {
		this.lblIdCondutor = lblIdCondutor;
	}

	public JLabel getLblMaterial() {
		return lblMaterial;
	}

	public void setLblMaterial(JLabel lblMaterial) {
		this.lblMaterial = lblMaterial;
	}

	public JComboBox<String> getCbMaterialCondutor() {
		return cbMaterialCondutor;
	}

	public void setCbMaterialCondutor(JComboBox<String> cbMaterialCondutor) {
		this.cbMaterialCondutor = cbMaterialCondutor;
	}

	public JTextField getTxtComprimentoCondutor() {
		return txtComprimentoCondutor;
	}

	public void setTxtComprimentoCondutor(JTextField txtComprimentoCondutor) {
		this.txtComprimentoCondutor = txtComprimentoCondutor;
	}

	public JTextField getTxtQuedaTensaoCondutor() {
		return txtQuedaTensaoCondutor;
	}

	public void setTxtQuedaTensaoCondutor(JTextField txtQuedaTensaoCondutor) {
		this.txtQuedaTensaoCondutor = txtQuedaTensaoCondutor;
	}

	public JTextField getTxtResistTermicaCondutor() {
		return txtResistTermicaCondutor;
	}

	public void setTxtResistTermicaCondutor(JTextField txtResistTermicaCondutor) {
		this.txtResistTermicaCondutor = txtResistTermicaCondutor;
	}

	public JComboBox<String> getCbEnterradoCondutor() {
		return cbEnterradoCondutor;
	}

	public void setCbEnterradoCondutor(JComboBox<String> cbEnterradoCondutor) {
		this.cbEnterradoCondutor = cbEnterradoCondutor;
	}

	public JComboBox<String> getCbIsolacaoCondutor() {
		return cbIsolacaoCondutor;
	}

	public void setCbIsolacaoCondutor(JComboBox<String> cbIsolacaoCondutor) {
		this.cbIsolacaoCondutor = cbIsolacaoCondutor;
	}

	public JComboBox<String> getCbAgrupamentoCondutor() {
		return cbAgrupamentoCondutor;
	}

	public void setCbAgrupamentoCondutor(JComboBox<String> cbAgrupamentoCondutor) {
		this.cbAgrupamentoCondutor = cbAgrupamentoCondutor;
	}

	public JComboBox<String> getCbMultipolarCondutor() {
		return cbMultipolarCondutor;
	}

	public void setCbMultipolarCondutor(JComboBox<String> cbMultipolarCondutor) {
		this.cbMultipolarCondutor = cbMultipolarCondutor;
	}

	public JComboBox<String> getCbEspacaCabosCondutor() {
		return cbEspacaCabosCondutor;
	}

	public void setCbEspacaCabosCondutor(JComboBox<String> cbEspacaCabosCondutor) {
		this.cbEspacaCabosCondutor = cbEspacaCabosCondutor;
	}

	public JComboBox<String> getCbInstalacaoCondutor() {
		return cbInstalacaoCondutor;
	}

	public void setCbInstalacaoCondutor(JComboBox<String> cbInstalacaoCondutor) {
		this.cbInstalacaoCondutor = cbInstalacaoCondutor;
	}

	public JComboBox<String> getCbBitolSucessCondutor() {
		return cbBitolSucessCondutor;
	}

	public void setCbBitolSucessCondutor(JComboBox<String> cbBitolSucessCondutor) {
		this.cbBitolSucessCondutor = cbBitolSucessCondutor;
	}

	public JComboBox<String> getCbNcirAgrupadosCondutor() {
		return cbNcirAgrupadosCondutor;
	}

	public void setCbNcirAgrupadosCondutor(JComboBox<String> cbNcirAgrupadosCondutor) {
		this.cbNcirAgrupadosCondutor = cbNcirAgrupadosCondutor;
	}

	public JComboBox<String> getCbNCamadasCondutor() {
		return cbNCamadasCondutor;
	}

	public void setCbNCamadasCondutor(JComboBox<String> cbNCamadasCondutor) {
		this.cbNCamadasCondutor = cbNCamadasCondutor;
	}

	public JComboBox<String> getCbTempAmbienteCondutor() {
		return cbTempAmbienteCondutor;
	}

	public void setCbTempAmbienteCondutor(JComboBox<String> cbTempAmbienteCondutor) {
		this.cbTempAmbienteCondutor = cbTempAmbienteCondutor;
	}

	public CondutorControle getCondutorControle() {
		return condutorControle;
	}

	public void setCondutorControle(CondutorControle condutorControle) {
		this.condutorControle = condutorControle;
	}

}
