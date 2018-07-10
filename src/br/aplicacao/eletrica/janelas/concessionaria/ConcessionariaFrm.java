package br.aplicacao.eletrica.janelas.concessionaria;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class ConcessionariaFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ConcessionariaControle controle;
	private JButton btnCopiarConcessionaria;
	private JButton btnExcluirConcessionaria;
	private JButton btnSalvarConcessionaria;
	private JPanel contentPane;
	private JLabel lblIdConcessionaria;
	private JTable tableConcessionarias;
	private JTextField txtNomeConcessionaria;
	private JLabel label;
	private JTextField txtLocalConcessionaria;

	public ConcessionariaFrm() {
		setTitle("Concessionárias");
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 700, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 0, 687, 343);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cadastrados",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(474, 47, 201, 284);
		panel_5.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 17, 177, 255);
		panel_1.add(scrollPane_1);

		tableConcessionarias = new JTable();
		tableConcessionarias.setName("tableConcessionarias");
		scrollPane_1.setViewportView(tableConcessionarias);

		JPanel panel_22 = new JPanel();
		panel_22.setBounds(12, 0, 116, 43);
		panel_5.add(panel_22);
		panel_22.setLayout(new MigLayout("", "[][][]", "[]"));

		btnSalvarConcessionaria = new JButton("");
		btnSalvarConcessionaria.setName("btnSalvarConcessionaria");
		btnSalvarConcessionaria.setIcon(new ImageIcon(
				ConcessionariaFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/add1-24.png")));
		btnSalvarConcessionaria.setMaximumSize(new Dimension(30, 30));
		btnSalvarConcessionaria.setBackground(Color.GRAY);
		panel_22.add(btnSalvarConcessionaria, "cell 0 0");

		btnExcluirConcessionaria = new JButton("");
		btnExcluirConcessionaria.setName("btnExcluirConcessionaria");
		btnExcluirConcessionaria.setIcon(new ImageIcon(
				ConcessionariaFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/close24.png")));
		btnExcluirConcessionaria.setMaximumSize(new Dimension(30, 30));
		btnExcluirConcessionaria.setBackground(Color.GRAY);
		panel_22.add(btnExcluirConcessionaria, "cell 1 0");

		btnCopiarConcessionaria = new JButton("");
		btnCopiarConcessionaria.setName("btnCopiarConcessionaria");
		btnCopiarConcessionaria.setIcon(
				new ImageIcon(ConcessionariaFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/copy24.png")));
		btnCopiarConcessionaria.setMaximumSize(new Dimension(30, 30));
		btnCopiarConcessionaria.setBackground(Color.GRAY);
		panel_22.add(btnCopiarConcessionaria, "cell 2 0");

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(12, 47, 246, 78);
		panel_5.add(panel);
		panel.setLayout(new MigLayout("", "[][grow]", "[][]"));

		JLabel lblNewLabel = new JLabel("Nome:");
		panel.add(lblNewLabel, "cell 0 0,alignx left");

		txtNomeConcessionaria = new JTextField();
		txtNomeConcessionaria.setName("txtNomeConcessionaria");
		txtNomeConcessionaria.setMaximumSize(new Dimension(120, 2147483647));
		panel.add(txtNomeConcessionaria, "cell 1 0,growx");
		txtNomeConcessionaria.setColumns(10);
		
		label = new JLabel("Local/Descr:");
		panel.add(label, "cell 0 1,alignx trailing");
		
		txtLocalConcessionaria = new JTextField();
		txtLocalConcessionaria.setName("txtLocalConcessionaria");
		txtLocalConcessionaria.setMaximumSize(new Dimension(120, 2147483647));
		txtLocalConcessionaria.setColumns(10);
		panel.add(txtLocalConcessionaria, "cell 1 1,growx");

		lblIdConcessionaria = new JLabel("0");
		lblIdConcessionaria.setBounds(146, 20, 70, 15);
		panel_5.add(lblIdConcessionaria);

		// -------------------------Controle-----------------------
		this.listen();
	}

	public JButton getBtnCopiarConcessionaria() {
		return this.btnCopiarConcessionaria;
	}

	public JButton getBtnExcluirConcessionaria() {
		return this.btnExcluirConcessionaria;
	}

	public JButton getBtnSalvarConcessionaria() {
		return this.btnSalvarConcessionaria;
	}

	public JLabel getLblIdConcessionaria() {
		return this.lblIdConcessionaria;
	}

	public JTable getTableConcessionarias() {
		return this.tableConcessionarias;
	}

	public JTextField getTxtNomeConcessionaria() {
		return this.txtNomeConcessionaria;
	}

	public void listen() {
		controle = new ConcessionariaControle(this);
	}

	public JTextField getTxtLocalConcessionaria() {
		return txtLocalConcessionaria;
	}

	public void setTxtLocalConcessionaria(JTextField txtLocalConcessionaria) {
		this.txtLocalConcessionaria = txtLocalConcessionaria;
	}

	public void setBtnCopiarConcessionaria(JButton btnCopiarConcessionaria) {
		this.btnCopiarConcessionaria = btnCopiarConcessionaria;
	}

	public void setBtnExcluirConcessionaria(JButton btnExcluirConcessionaria) {
		this.btnExcluirConcessionaria = btnExcluirConcessionaria;
	}

	public void setBtnSalvarConcessionaria(JButton btnSalvarConcessionaria) {
		this.btnSalvarConcessionaria = btnSalvarConcessionaria;
	}

	public void setLblIdConcessionaria(JLabel lblIdConcessionaria) {
		this.lblIdConcessionaria = lblIdConcessionaria;
	}

	public void setTableConcessionarias(JTable tableConcessionarias) {
		this.tableConcessionarias = tableConcessionarias;
	}


	public void setTxtNomeConcessionaria(JTextField txtNomeConcessionaria) {
		this.txtNomeConcessionaria = txtNomeConcessionaria;
	}

	public ConcessionariaControle getControle() {
		return controle;
	}

	public void setControle(ConcessionariaControle controle) {
		this.controle = controle;
	}

}
