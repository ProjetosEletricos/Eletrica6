package br.aplicacao.eletrica.janelas.curto;

import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import net.miginfocom.swing.MigLayout;

public class CurtoFrm extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private CurtoControle curtoControle;

	private JPanel contentPane;
	private JLabel lblIdCurto;
	private JLabel lblCorrenteCurto;
	private JTextField txtCorrenteCurto;
	private JTextField txtTempAdmissRegimeCurto;
	private JTextField txtTempMaxCurto;
	private JTextField txtTempoElimDefCurto;

	public CurtoFrm() {
		setTitle("Curto");
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
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][]"));

		lblCorrenteCurto = new JLabel("Corrente de curto:");
		panel.add(lblCorrenteCurto, "cell 0 0,alignx left");

		txtCorrenteCurto = new JTextField();
		txtCorrenteCurto.setName("txtCorrenteCurto");
		panel.add(txtCorrenteCurto, "cell 1 0,growx");

		JLabel lblTempoAdmissivelDeregime = new JLabel("Tempo admissivel de regime:");
		panel.add(lblTempoAdmissivelDeregime, "cell 0 1,alignx left");

		txtTempAdmissRegimeCurto = new JTextField();
		txtTempAdmissRegimeCurto.setName("txtTempAdmissRegimeCurto");
		panel.add(txtTempAdmissRegimeCurto, "cell 1 1,growx");

		JLabel lblTempoMCurto = new JLabel("Tempo máximo de curto:");
		panel.add(lblTempoMCurto, "cell 0 2,alignx left");

		txtTempMaxCurto = new JTextField();
		txtTempMaxCurto.setName("txtTempMaxCurto");
		panel.add(txtTempMaxCurto, "cell 1 2,growx");

		JLabel lblTempoDeEliminao = new JLabel("Tempo de eliminação de defeito:");
		panel.add(lblTempoDeEliminao, "cell 0 3,alignx left");

		txtTempoElimDefCurto = new JTextField();
		txtTempoElimDefCurto.setName("txtTempoElimDefCurto");
		panel.add(txtTempoElimDefCurto, "cell 1 3,growx");

		lblIdCurto = new JLabel("");
		lblIdCurto.setName("lblIdCurto");
		lblIdCurto.setBounds(433, 0, 70, 15);
		panel_5.add(lblIdCurto);

		// -------------------------Controle-----------------------
		this.Listen();
	}

	private void Listen() {

		curtoControle = new CurtoControle(this);

	}

	public JLabel getLblIdCurto() {
		return lblIdCurto;
	}

	public void setLblIdCurto(JLabel lblIdCurto) {
		this.lblIdCurto = lblIdCurto;
	}

	public JTextField getTxtCorrenteCurto() {
		return txtCorrenteCurto;
	}

	public void setTxtCorrenteCurto(JTextField txtCorrenteCurto) {
		this.txtCorrenteCurto = txtCorrenteCurto;
	}

	public JTextField getTxtTempAdmissRegimeCurto() {
		return txtTempAdmissRegimeCurto;
	}

	public void setTxtTempAdmissRegimeCurto(JTextField txtTempAdmissRegimeCurto) {
		this.txtTempAdmissRegimeCurto = txtTempAdmissRegimeCurto;
	}

	public JTextField getTxtTempMaxCurto() {
		return txtTempMaxCurto;
	}

	public void setTxtTempMaxCurto(JTextField txtTempMaxCurto) {
		this.txtTempMaxCurto = txtTempMaxCurto;
	}

	public JTextField getTxtTempoElimDefCurto() {
		return txtTempoElimDefCurto;
	}

	public void setTxtTempoElimDefCurto(JTextField txtTempoElimDefCurto) {
		this.txtTempoElimDefCurto = txtTempoElimDefCurto;
	}

	public CurtoControle getCurtoControle() {
		return curtoControle;
	}

	public JLabel getLblCorrenteCurto() {
		return lblCorrenteCurto;
	}

	public void setLblCorrenteCurto(JLabel lblCorrenteCurto) {
		this.lblCorrenteCurto = lblCorrenteCurto;
	}

	public void setCurtoControle(CurtoControle curtoControle) {
		this.curtoControle = curtoControle;
	}

}
