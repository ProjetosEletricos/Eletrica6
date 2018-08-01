package br.aplicacao.eletrica.janelas.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import br.aplicacao.eletrica.enums.Ligacao;
import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.enums.Usabilidade;
import br.aplicacao.eletrica.janelas.circuito.CircuitoControle;
import br.aplicacao.eletrica.janelas.equipamento.EquipamentoControle;
import br.aplicacao.eletrica.janelas.fonte.FonteControle;
import br.aplicacao.eletrica.janelas.projeto.ProjetoControle;
import br.aplicacao.eletrica.janelas.quadro.QuadroControle;
import br.aplicacao.eletrica.modelo.projeto.Concessionaria;
import br.aplicacao.eletrica.modelo.projeto.Quadro;
import br.aplicacao.eletrica.servico.ConcessionariaService;
import br.aplicacao.eletrica.servico.QuadroService;
import net.miginfocom.swing.MigLayout;

public class PrincipalFrm extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	private JTabbedPane abas;
	private JButton btnCopiarCircuito;
	private JButton btnCopiarEquipamento;
	private JButton btnCopiarFonte;
	private JButton btnCopiarProjeto;
	private JButton btnCopiarQuadro;
	private JButton btnExcluirEquipamento;
	private JButton btnExcluirCircuito;
	private JButton btnExcluirFonte;
	private JButton btnExcluirProjeto;
	private JButton btnExcluirQuadro;
	private JButton btnSalvarCircuito;
	private JButton btnSalvarEquipamento;
	private JButton btnSalvarFonte;
	private JButton btnSalvarProjeto;
	private JButton btnSalvarQuadro;
	private JButton btnCurtoCirCircuito;
	private JButton btnCondutorCircuito;

	private JComboBox<Concessionaria> cbConcessionaria;
	private JComboBox<String> cbDrQuadro;
	private JComboBox<Ligacao> cbLigacaoEquipamento;
	private JComboBox<String> cbPolosEquipamento;
	private JComboBox<Quadro> cbQuadroPaiQuadro;
	private JComboBox<UnidadePontencia> cbUnidadePotEquipamento;
	private JComboBox<Usabilidade> cbUsabilidadeQuadro;
	private JPanel contentPane;
	private JLabel lblIdCircuito;
	private JLabel lblIdFonte;
	private JLabel lblIdProjeto;
	private JLabel lblIdQuadro;
	private JPanel panelCircuito;
	private JPanel panelFonte;
	private JPanel panelProjeto;
	private JPanel panelQuadro;
	private JTable tableEquipamentos;
	private JTable tableFontes;
	private JTable tableProjetos;

	private JTable tableQuadros;
	private JTextField txtAutor;
	private JTextField txtData;
	private JTextPane txtDescricaoProjeto;
	private JTextField txtFdEquipamento;
	private JTextField txtFdQuadro;

	private JTextField txtFpEquipamento;
	private JTextField txtFpQuadro;
	private JTextField txtFServicoEquipamento;
	private JTextField txtFSimutaneadadeEquipamento;
	private JTextField txtFUtilizacaoEquipamento;
	private JTextField txtLocalEquipamento;
	private JTextField txtLocalQuadro;
	private JTextField txtNomeCircuito;
	private JTextField txtNomeEquipamento;
	private JTextField txtNomeFonte;
	private JTextField txtNomeProjeto;
	private JTextField txtNomeQuadro;

	private JTextField txtPerdasEquipamento;
	private JTextField txtPotenciaEquipamento;
	private JTextField txtRendimentoEquipamento;
	private JTextField txtTensaoFonte;
	private JScrollPane scrollPane_5;
	private JTable tableCircuitos;
	private ProjetoControle projetoControle;
	private FonteControle fonteControle;
	private QuadroControle quadroControle;
	private CircuitoControle circuitoControle;
	private EquipamentoControle equipamentoControle;

	private JLabel lblIdEquipamento;
	private JTextField txtQuantidadeEquipamento;

	private JPanel panelEquipamento;

	private JButton btnCondutorQuadro;

	private JButton btnCurtoCirQuadro;
	private JComboBox<Usabilidade> cbUsabilidadeEquipamento;

	public PrincipalFrm() {
		setClosable(true);
		setIconifiable(true);
		setMaximizable(true);
		setBounds(100, 100, 700, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 0, 690, 367);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		abas = new JTabbedPane(SwingConstants.TOP);
		abas.setBounds(0, 0, 692, 370);
		panel_3.add(abas);

		panelProjeto = new JPanel();
		panelProjeto.setName("panelProjeto");
		abas.addTab("Projeto", null, panelProjeto, null);
		panelProjeto.setLayout(null);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(null, "Descri\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null,
				Color.BLUE));
		panel_10.setBounds(10, 45, 193, 284);
		panelProjeto.add(panel_10);

		JPanel panel_11 = new JPanel();
		panel_11.setBorder(null);
		panel_11.setBounds(8, 17, 179, 103);
		panel_10.add(panel_11);
		panel_11.setLayout(null);

		JLabel label_3 = new JLabel("Nome:");
		label_3.setBounds(6, 6, 45, 19);
		panel_11.add(label_3);

		txtNomeProjeto = new JTextField();
		txtNomeProjeto.setBounds(55, 6, 112, 25);
		txtNomeProjeto.setName("txtNome");
		txtNomeProjeto.setColumns(10);
		panel_11.add(txtNomeProjeto);

		JLabel label_4 = new JLabel("Data:");
		label_4.setBounds(6, 39, 39, 19);
		panel_11.add(label_4);

		txtData = new JTextField();
		txtData.setBounds(55, 39, 112, 25);
		txtData.setName("txtData");
		txtData.setColumns(10);
		txtData.setActionCommand("txtData");
		panel_11.add(txtData);

		JLabel label_5 = new JLabel("Autor:");
		label_5.setBounds(7, 72, 44, 19);
		panel_11.add(label_5);

		txtAutor = new JTextField();
		txtAutor.setBounds(55, 72, 112, 25);
		txtAutor.setName("txtAutor");
		txtAutor.setColumns(10);
		panel_11.add(txtAutor);

		JLabel label_1 = new JLabel("Descri\u00E7\u00E3o:");
		label_1.setBounds(18, 120, 88, 15);
		panel_10.add(label_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 136, 159, 136);
		panel_10.add(scrollPane);

		txtDescricaoProjeto = new JTextPane();
		scrollPane.setViewportView(txtDescricaoProjeto);

		JLabel label_2 = new JLabel("");
		label_2.setName("lblIdProjeto");
		label_2.setBounds(107, 105, 70, 15);
		panel_10.add(label_2);

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cadastrados",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_12.setBounds(205, 45, 470, 284);
		panelProjeto.add(panel_12);

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(12, 16, 446, 256);
		panel_12.add(scrollPane_3);

		tableProjetos = new JTable();
		scrollPane_3.setViewportView(tableProjetos);

		JPanel panel_18 = new JPanel();
		panel_18.setBounds(12, 0, 116, 43);
		panelProjeto.add(panel_18);
		panel_18.setLayout(new MigLayout("", "[][][][]", "[]"));

		btnSalvarProjeto = new JButton("");
		btnSalvarProjeto.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/add1-24.png")));
		btnSalvarProjeto.setName("btnSalvarProjeto");
		btnSalvarProjeto.setBackground(Color.GRAY);
		btnSalvarProjeto.setSelectedIcon(null);
		btnSalvarProjeto.setMaximumSize(new Dimension(30, 30));
		panel_18.add(btnSalvarProjeto, "cell 0 0");

		btnExcluirProjeto = new JButton("");
		btnExcluirProjeto.setName("btnExcluirProjeto");
		btnExcluirProjeto.setBackground(Color.GRAY);
		btnExcluirProjeto.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/close24.png")));
		btnExcluirProjeto.setMaximumSize(new Dimension(30, 30));
		panel_18.add(btnExcluirProjeto, "cell 1 0");

		btnCopiarProjeto = new JButton("");
		btnCopiarProjeto.setName("btnCopiarProjeto");
		btnCopiarProjeto.setBackground(Color.GRAY);
		btnCopiarProjeto.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/copy24.png")));
		btnCopiarProjeto.setMaximumSize(new Dimension(30, 30));
		panel_18.add(btnCopiarProjeto, "cell 2 0");

		lblIdProjeto = new JLabel("");
		lblIdProjeto.setBounds(146, 20, 70, 15);
		panelProjeto.add(lblIdProjeto);

		panelFonte = new JPanel();
		abas.addTab("Fonte", null, panelFonte, null);
		panelFonte.setLayout(null);

		JPanel panel_15 = new JPanel();
		panel_15.setLayout(null);
		panel_15.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_15.setBounds(12, 44, 352, 113);
		panelFonte.add(panel_15);

		JLabel label_6 = new JLabel("Tens\u00E3o nominal (F-N):");
		label_6.setBounds(22, 51, 154, 16);
		panel_15.add(label_6);

		JLabel label_9 = new JLabel("V");
		label_9.setBounds(227, 52, 18, 16);
		panel_15.add(label_9);

		JLabel label_10 = new JLabel("Concession\u00E1ria:");
		label_10.setBounds(22, 82, 125, 15);
		panel_15.add(label_10);

		txtTensaoFonte = new JTextField();
		txtTensaoFonte.setName("txtTensaoFonte");
		txtTensaoFonte.setHorizontalAlignment(SwingConstants.CENTER);
		txtTensaoFonte.setColumns(10);
		txtTensaoFonte.setBounds(178, 50, 45, 22);
		panel_15.add(txtTensaoFonte);

		cbConcessionaria = new JComboBox<Concessionaria>();
		cbConcessionaria.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<Concessionaria> lista = new ArrayList<Concessionaria>();
				lista = ConcessionariaService.getAll();
				cbConcessionaria.removeAllItems();
				setConcessionaria(lista);
			}
		});

		cbConcessionaria.setName("cbConcessionaria");
		cbConcessionaria.setBounds(144, 77, 137, 24);
		panel_15.add(cbConcessionaria);

		JLabel lblNomeFonte = new JLabel("Nome:");
		lblNomeFonte.setName("lblNomeFonte");
		lblNomeFonte.setBounds(12, 25, 53, 16);
		panel_15.add(lblNomeFonte);

		txtNomeFonte = new JTextField();
		txtNomeFonte.setName("txtNomeFonte");
		txtNomeFonte.setHorizontalAlignment(SwingConstants.CENTER);
		txtNomeFonte.setColumns(10);
		txtNomeFonte.setBounds(60, 24, 211, 22);
		panel_15.add(txtNomeFonte);

		JPanel panel_19 = new JPanel();
		panel_19.setBounds(12, 0, 116, 43);
		panelFonte.add(panel_19);
		panel_19.setLayout(new MigLayout("", "[][][]", "[]"));

		btnSalvarFonte = new JButton("");
		btnSalvarFonte.setName("btnSalvarFonte");
		btnSalvarFonte.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/add1-24.png")));
		btnSalvarFonte.setMaximumSize(new Dimension(30, 30));
		btnSalvarFonte.setBackground(Color.GRAY);
		panel_19.add(btnSalvarFonte, "cell 0 0");

		btnExcluirFonte = new JButton("");
		btnExcluirFonte.setName("btnExcluirFonte");
		btnExcluirFonte.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/close24.png")));
		btnExcluirFonte.setMaximumSize(new Dimension(30, 30));
		btnExcluirFonte.setBackground(Color.GRAY);
		panel_19.add(btnExcluirFonte, "cell 1 0");

		btnCopiarFonte = new JButton("");
		btnCopiarFonte.setName("btnCopiarFonte");
		btnCopiarFonte.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/copy24.png")));
		btnCopiarFonte.setMaximumSize(new Dimension(30, 30));
		btnCopiarFonte.setBackground(Color.GRAY);
		panel_19.add(btnCopiarFonte, "cell 2 0");

		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cadastrados",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_20.setBounds(12, 169, 352, 162);
		panelFonte.add(panel_20);
		panel_20.setLayout(null);

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(12, 19, 328, 131);
		panel_20.add(scrollPane_4);
		scrollPane_4.setName("scrollPane");

		tableFontes = new JTable();
		scrollPane_4.setViewportView(tableFontes);

		lblIdFonte = new JLabel();
		lblIdFonte.setName("lblIdFonte");
		lblIdFonte.setBounds(143, 17, 70, 15);
		panelFonte.add(lblIdFonte);

		panelQuadro = new JPanel();
		abas.addTab("Quadro", null, panelQuadro, null);
		panelQuadro.setLayout(null);

		JPanel panel_16 = new JPanel();
		panel_16.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Descri\u00E7\u00E3o",
				TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_16.setBounds(12, 43, 411, 165);
		panelQuadro.add(panel_16);
		panel_16.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][]"));

		JLabel label_7 = new JLabel("Nome:");
		panel_16.add(label_7, "cell 0 0,alignx trailing");

		txtNomeQuadro = new JTextField();
		txtNomeQuadro.setMaximumSize(new Dimension(100, 2147483647));
		txtNomeQuadro.setColumns(10);
		panel_16.add(txtNomeQuadro, "cell 1 0,growx");

		JLabel label_8 = new JLabel("Usabilidade:");
		panel_16.add(label_8, "cell 2 0,alignx trailing");

		cbUsabilidadeQuadro = new JComboBox<Usabilidade>();
		cbUsabilidadeQuadro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<Usabilidade> lista = new ArrayList<Usabilidade>();
				cbUsabilidadeQuadro.removeAllItems();
				lista.add(Usabilidade.ILUMINACAO_FLUORESCENTE);
				lista.add(Usabilidade.ILUMINACAO_INCADESCENTE);
				lista.add(Usabilidade.MOTOR);
				setUsabilidadeQuadro(lista);
			}
		});
		cbUsabilidadeQuadro.setName("cbUsabilidade");
		panel_16.add(cbUsabilidadeQuadro, "cell 3 0,growx");

		JLabel label_11 = new JLabel("Local:");
		panel_16.add(label_11, "cell 0 1,alignx trailing");

		txtLocalQuadro = new JTextField();
		txtLocalQuadro.setMaximumSize(new Dimension(100, 2147483647));
		txtLocalQuadro.setColumns(10);
		panel_16.add(txtLocalQuadro, "cell 1 1,growx");

		JLabel label_12 = new JLabel("DR Geral:");
		panel_16.add(label_12, "cell 2 1,alignx trailing");

		cbDrQuadro = new JComboBox<String>();
		cbDrQuadro.setName("cbDrQuadro");
		panel_16.add(cbDrQuadro, "cell 3 1,growx");

		JLabel label_13 = new JLabel("FD:");
		panel_16.add(label_13, "cell 0 2,alignx trailing");

		txtFdQuadro = new JTextField();
		txtFdQuadro.setName("txtFdQuadro");
		txtFdQuadro.setMaximumSize(new Dimension(100, 2147483647));
		txtFdQuadro.setColumns(10);
		panel_16.add(txtFdQuadro, "cell 1 2,growx");

		JLabel label_14 = new JLabel("Quadro pai:");
		panel_16.add(label_14, "cell 2 2,alignx trailing");

		cbQuadroPaiQuadro = new JComboBox<Quadro>();
		cbQuadroPaiQuadro.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<Quadro> lista = new ArrayList<Quadro>();
				lista.add(null);
				lista = QuadroService.getAll();
				cbQuadroPaiQuadro.removeAllItems();
				setQuadros(lista);
			}
		});
		cbQuadroPaiQuadro.setName("cbQuadroPaiQuadro");
		panel_16.add(cbQuadroPaiQuadro, "cell 3 2,growx");

		JLabel label_15 = new JLabel("FP:");
		panel_16.add(label_15, "cell 0 3,alignx trailing");

		txtFpQuadro = new JTextField();
		txtFpQuadro.setName("txtFpQuadro");
		txtFpQuadro.setMaximumSize(new Dimension(100, 2147483647));
		txtFpQuadro.setColumns(10);
		panel_16.add(txtFpQuadro, "cell 1 3,growx");

		JPanel panel_17 = new JPanel();
		panel_17.setBorder(
				new TitledBorder(null, "Cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_17.setLayout(null);
		panel_17.setBounds(427, 43, 248, 288);
		panelQuadro.add(panel_17);

		scrollPane_5 = new JScrollPane();
		scrollPane_5.setName("scrollPane");
		scrollPane_5.setBounds(12, 17, 224, 259);
		panel_17.add(scrollPane_5);

		tableQuadros = new JTable();
		tableQuadros.setName("tableQuadros");
		tableQuadros.setAutoscrolls(false);
		scrollPane_5.setViewportView(tableQuadros);

		JPanel panel_21 = new JPanel();
		panel_21.setBounds(12, 0, 116, 43);
		panelQuadro.add(panel_21);
		panel_21.setLayout(new MigLayout("", "[][][]", "[]"));

		btnSalvarQuadro = new JButton("");
		btnSalvarQuadro.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/add1-24.png")));
		btnSalvarQuadro.setName("btnSalvarQuadro");

		btnSalvarQuadro.setMaximumSize(new Dimension(30, 30));
		btnSalvarQuadro.setBackground(Color.GRAY);
		panel_21.add(btnSalvarQuadro, "cell 0 0");

		btnExcluirQuadro = new JButton("");
		btnExcluirQuadro.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/close24.png")));
		btnExcluirQuadro.setName("btnExcluirQuadro");

		btnExcluirQuadro.setMaximumSize(new Dimension(30, 30));
		btnExcluirQuadro.setBackground(Color.GRAY);
		panel_21.add(btnExcluirQuadro, "cell 1 0");

		btnCopiarQuadro = new JButton("");
		btnCopiarQuadro.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/copy24.png")));
		btnCopiarQuadro.setName("btnCopiarQuadro");

		btnCopiarQuadro.setMaximumSize(new Dimension(30, 30));
		btnCopiarQuadro.setBackground(Color.GRAY);
		panel_21.add(btnCopiarQuadro, "cell 2 0");

		lblIdQuadro = new JLabel("");
		lblIdQuadro.setName("lblIdQuadro");
		lblIdQuadro.setBounds(146, 15, 55, 16);
		panelQuadro.add(lblIdQuadro);

		btnCondutorQuadro = new JButton("Condutor");
		btnCondutorQuadro.setName("btnCondutorQuadro");
		btnCondutorQuadro.setBounds(178, 211, 100, 21);
		panelQuadro.add(btnCondutorQuadro);

		btnCurtoCirQuadro = new JButton("Curto cir.");
		btnCurtoCirQuadro.setName("btnCurtoCirQuadro");
		btnCurtoCirQuadro.setBounds(178, 236, 100, 19);
		panelQuadro.add(btnCurtoCirQuadro);

		panelCircuito = new JPanel();
		abas.addTab("Circuito", null, panelCircuito, null);
		abas.setEnabledAt(3, true);
		panelCircuito.setLayout(null);

		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cadastrados",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_6.setBounds(12, 153, 315, 178);
		panelCircuito.add(panel_6);
		panel_6.setLayout(null);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(12, 17, 291, 149);
		panel_6.add(scrollPane_2);

		tableCircuitos = new JTable();
		scrollPane_2.setViewportView(tableCircuitos);

		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_8.setBounds(12, 43, 207, 108);
		panelCircuito.add(panel_8);
		panel_8.setLayout(null);

		JLabel lblComprimento = new JLabel("Nome:");
		lblComprimento.setBounds(11, 25, 45, 15);
		panel_8.add(lblComprimento);

		txtNomeCircuito = new JTextField();
		txtNomeCircuito.setBounds(62, 22, 123, 24);
		txtNomeCircuito.setName("txtNomeCircuito");
		txtNomeCircuito.setColumns(3);
		panel_8.add(txtNomeCircuito);

		btnCurtoCirCircuito = new JButton("Curto cir.");
		btnCurtoCirCircuito.setName("btnCurtoCirCircuito");
		btnCurtoCirCircuito.setBounds(72, 77, 100, 19);
		panel_8.add(btnCurtoCirCircuito);

		btnCondutorCircuito = new JButton("Condutor");
		btnCondutorCircuito.setBounds(72, 52, 100, 21);
		panel_8.add(btnCondutorCircuito);
		btnCondutorCircuito.setName("btnCondutorCircuito");

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 0, 118, 43);
		panelCircuito.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[30px][30px][30px][]", "[30px]"));

		btnSalvarCircuito = new JButton("");
		btnSalvarCircuito.setName("btnSalvarCircuito");
		btnSalvarCircuito.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/add1-24.png")));
		btnSalvarCircuito.setMaximumSize(new Dimension(30, 30));
		btnSalvarCircuito.setBackground(Color.GRAY);
		panel_2.add(btnSalvarCircuito, "cell 0 0,grow");

		btnExcluirCircuito = new JButton("");
		btnExcluirCircuito.setName("btnExcluirCircuito");
		btnExcluirCircuito.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/close24.png")));
		btnExcluirCircuito.setMaximumSize(new Dimension(30, 30));
		btnExcluirCircuito.setBackground(Color.GRAY);
		panel_2.add(btnExcluirCircuito, "cell 1 0,grow");

		btnCopiarCircuito = new JButton("");
		btnCopiarCircuito.setSize(30, 19);
		btnCopiarCircuito.setName("btnCopiarCircuito");
		btnCopiarCircuito.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/copy24.png")));
		btnCopiarCircuito.setMaximumSize(new Dimension(30, 30));
		btnCopiarCircuito.setBackground(Color.GRAY);
		panel_2.add(btnCopiarCircuito, "cell 2 0,grow");

		lblIdCircuito = new JLabel("");
		lblIdCircuito.setBounds(426, 16, 70, 15);
		panelCircuito.add(lblIdCircuito);

		panelEquipamento = new JPanel();
		panelEquipamento.setName("panelEquipamento");
		abas.addTab("Equipamento", null, panelEquipamento, null);
		panelEquipamento.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Cadastrados",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(469, 47, 206, 284);
		panelEquipamento.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 17, 182, 255);
		panel_1.add(scrollPane_1);

		tableEquipamentos = new JTable();
		tableEquipamentos.setName("tableEquipamentos");
		scrollPane_1.setViewportView(tableEquipamentos);

		JPanel panel_22 = new JPanel();
		panel_22.setBounds(12, 0, 116, 43);
		panelEquipamento.add(panel_22);
		panel_22.setLayout(new MigLayout("", "[][][]", "[]"));

		btnSalvarEquipamento = new JButton("");
		btnSalvarEquipamento.setName("btnSalvarEquipamento");
		btnSalvarEquipamento.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/add1-24.png")));
		btnSalvarEquipamento.setMaximumSize(new Dimension(30, 30));
		btnSalvarEquipamento.setBackground(Color.GRAY);
		panel_22.add(btnSalvarEquipamento, "cell 0 0");

		btnExcluirEquipamento = new JButton("");
		btnExcluirEquipamento.setName("btnExcluirEquipamento");
		btnExcluirEquipamento.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/close24.png")));
		btnExcluirEquipamento.setMaximumSize(new Dimension(30, 30));
		btnExcluirEquipamento.setBackground(Color.GRAY);
		panel_22.add(btnExcluirEquipamento, "cell 1 0");

		btnCopiarEquipamento = new JButton("");
		btnCopiarEquipamento.setName("btnCopiarEquipamento");
		btnCopiarEquipamento.setIcon(
				new ImageIcon(PrincipalFrm.class.getResource("/br/aplicacao/eletrica/janelas/images/copy24.png")));
		btnCopiarEquipamento.setMaximumSize(new Dimension(30, 30));
		btnCopiarEquipamento.setBackground(Color.GRAY);
		panel_22.add(btnCopiarEquipamento, "cell 2 0");

		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Informa\u00E7\u00F5es",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_7.setBounds(12, 47, 451, 284);
		panelEquipamento.add(panel_7);
		panel_7.setLayout(new MigLayout("", "[][grow][grow][][grow]", "[][][][][][][][]"));

		JLabel lblNewLabel = new JLabel("Nome:");
		panel_7.add(lblNewLabel, "cell 0 0,alignx left");

		txtNomeEquipamento = new JTextField();
		txtNomeEquipamento.setName("txtNomeEquipamento");
		txtNomeEquipamento.setMaximumSize(new Dimension(120, 2147483647));
		panel_7.add(txtNomeEquipamento, "cell 1 0,growx");
		txtNomeEquipamento.setColumns(10);

		JLabel lblFp = new JLabel("FP:");
		panel_7.add(lblFp, "cell 3 0,alignx left");

		txtFpEquipamento = new JTextField();
		txtFpEquipamento.setName("txtFpEquipamento");
		txtFpEquipamento.setMaximumSize(new Dimension(50, 2147483647));
		txtFpEquipamento.setColumns(10);
		panel_7.add(txtFpEquipamento, "cell 4 0,growx");

		JLabel lblLocal = new JLabel("Local/Descr:");
		panel_7.add(lblLocal, "cell 0 1,alignx left");

		txtLocalEquipamento = new JTextField();
		txtLocalEquipamento.setName("txtLocalEquipamento");
		txtLocalEquipamento.setMaximumSize(new Dimension(120, 2147483647));
		txtLocalEquipamento.setColumns(10);
		panel_7.add(txtLocalEquipamento, "cell 1 1,growx");

		JLabel lblRendimento = new JLabel("Rendimento:");
		panel_7.add(lblRendimento, "cell 3 1,alignx left");

		txtRendimentoEquipamento = new JTextField();
		txtRendimentoEquipamento.setName("txtRendimentoEquipamento");
		txtRendimentoEquipamento.setMaximumSize(new Dimension(50, 2147483647));
		txtRendimentoEquipamento.setColumns(10);
		panel_7.add(txtRendimentoEquipamento, "cell 4 1,growx");

		JLabel lblNewLabel_1 = new JLabel("Usabilidade:");
		panel_7.add(lblNewLabel_1, "cell 0 2,alignx trailing");
		
		cbUsabilidadeEquipamento = new JComboBox<Usabilidade>();
		cbUsabilidadeEquipamento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<Usabilidade> lista = new ArrayList<Usabilidade>();
				cbUsabilidadeEquipamento.removeAllItems();
				lista.add(Usabilidade.ILUMINACAO_FLUORESCENTE);
				lista.add(Usabilidade.ILUMINACAO_INCADESCENTE);
				lista.add(Usabilidade.GERAL);
				setUsabilidadeEquipamento(lista);
			}
		});
		cbUsabilidadeEquipamento.setName("cbUsabilidadeEquipamento");
		panel_7.add(cbUsabilidadeEquipamento, "cell 1 2,growx");

		JLabel lblFd = new JLabel("Fd:");
		panel_7.add(lblFd, "cell 3 2,alignx left");

		txtFdEquipamento = new JTextField();
		txtFdEquipamento.setName("txtFdEquipamento");
		txtFdEquipamento.setMaximumSize(new Dimension(50, 2147483647));
		txtFdEquipamento.setColumns(10);
		panel_7.add(txtFdEquipamento, "cell 4 2,growx");

		JLabel lblQuantidade_1 = new JLabel("Quantidade:");
		panel_7.add(lblQuantidade_1, "cell 0 3,alignx trailing");

		txtQuantidadeEquipamento = new JTextField();
		txtQuantidadeEquipamento.setName("txtQuantidadeEquipamento");
		panel_7.add(txtQuantidadeEquipamento, "cell 1 3,growx");
		txtQuantidadeEquipamento.setColumns(10);

		JLabel lblFutil = new JLabel("FUtil:");
		panel_7.add(lblFutil, "cell 3 3,alignx left");

		txtFUtilizacaoEquipamento = new JTextField();
		txtFUtilizacaoEquipamento.setName("txtFUtilizacaoEquipamento");
		txtFUtilizacaoEquipamento.setMaximumSize(new Dimension(50, 2147483647));
		txtFUtilizacaoEquipamento.setColumns(10);
		panel_7.add(txtFUtilizacaoEquipamento, "cell 4 3,growx");

		JLabel lblQuantidade = new JLabel("Pot\u00EAncia:");
		panel_7.add(lblQuantidade, "cell 0 4,alignx left");

		txtPotenciaEquipamento = new JTextField();
		txtPotenciaEquipamento.setName("txtPotenciaEquipamento");
		txtPotenciaEquipamento.setMaximumSize(new Dimension(120, 2147483647));
		txtPotenciaEquipamento.setColumns(10);
		panel_7.add(txtPotenciaEquipamento, "cell 1 4,growx");

		cbUnidadePotEquipamento = new JComboBox<>();
		cbUnidadePotEquipamento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<UnidadePontencia> lista = new ArrayList<UnidadePontencia>();
				cbUnidadePotEquipamento.removeAllItems();
				lista.add(UnidadePontencia.BTU);
				lista.add(UnidadePontencia.CV);
				lista.add(UnidadePontencia.HP);
				lista.add(UnidadePontencia.VA);
				lista.add(UnidadePontencia.W);
				setUnidadeEquipamento(lista);
			}
		});
		cbUnidadePotEquipamento.setName("cbUnidadePotEquipamento");
		panel_7.add(cbUnidadePotEquipamento, "cell 2 4,growx");

		JLabel lblTotal = new JLabel("Total:");
		panel_7.add(lblTotal, "cell 3 4,aligny baseline");

		JLabel lblValorTotal = new JLabel("");
		panel_7.add(lblValorTotal, "cell 4 4");

		JLabel lblPlos = new JLabel("P\u00F3los:");
		panel_7.add(lblPlos, "cell 0 5,alignx left");

		cbPolosEquipamento = new JComboBox<>();
		cbPolosEquipamento.setName("cbPolosEquipamento");
		cbPolosEquipamento.setMaximumSize(new Dimension(45, 32767));
		panel_7.add(cbPolosEquipamento, "cell 1 5,growx");

		JLabel lblFserv = new JLabel("FServ:");
		panel_7.add(lblFserv, "cell 3 5,alignx left");

		txtFServicoEquipamento = new JTextField();
		txtFServicoEquipamento.setName("txtFServicoEquipamento");
		txtFServicoEquipamento.setMaximumSize(new Dimension(50, 2147483647));
		txtFServicoEquipamento.setColumns(10);
		panel_7.add(txtFServicoEquipamento, "cell 4 5,growx");

		JLabel lblLigao = new JLabel("Liga\u00E7\u00E3o:");
		panel_7.add(lblLigao, "cell 0 6,alignx left");

		cbLigacaoEquipamento = new JComboBox<Ligacao>();
		cbLigacaoEquipamento.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				List<Ligacao> lista = new ArrayList<Ligacao>();
				cbLigacaoEquipamento.removeAllItems();
				lista.add(Ligacao.BIFASICO_FF);
				lista.add(Ligacao.BIFASICO_FFN);
				lista.add(Ligacao.TRIFASICO_FFF);
				lista.add(Ligacao.TRIFASICO_FFFN);
				lista.add(Ligacao.MONOFASICO_FN);
				setLigacaoEquipamento(lista);
			}
		});
		cbLigacaoEquipamento.setName("cbLigacaoEquipamento");
		cbLigacaoEquipamento.setMinimumSize(new Dimension(40, 24));
		cbLigacaoEquipamento.setMaximumSize(new Dimension(60, 32767));
		panel_7.add(cbLigacaoEquipamento, "cell 1 6,growx");

		JLabel lblFsimu = new JLabel("FSimu:");
		panel_7.add(lblFsimu, "cell 3 6,alignx left");

		txtFSimutaneadadeEquipamento = new JTextField();
		txtFSimutaneadadeEquipamento.setName("txtFSimutaneadadeEquipamento");
		txtFSimutaneadadeEquipamento.setMaximumSize(new Dimension(50, 2147483647));
		txtFSimutaneadadeEquipamento.setColumns(10);
		panel_7.add(txtFSimutaneadadeEquipamento, "cell 4 6,growx");

		JLabel lblPerdasw = new JLabel("Perdas (W):");
		panel_7.add(lblPerdasw, "cell 0 7,alignx left");

		txtPerdasEquipamento = new JTextField();
		txtPerdasEquipamento.setName("txtPerdasEquipamento");
		txtPerdasEquipamento.setMaximumSize(new Dimension(120, 2147483647));
		txtPerdasEquipamento.setColumns(10);
		panel_7.add(txtPerdasEquipamento, "cell 1 7,growx");

		lblIdEquipamento = new JLabel("");
		lblIdEquipamento.setName("lblIdEquipamento");
		lblIdEquipamento.setBounds(146, 20, 70, 15);
		panelEquipamento.add(lblIdEquipamento);

		JPanel panel = new JPanel();
		abas.addTab("Resultados", null, panel, null);
		panel.setLayout(null);

		// -------------------------Controle-----------------------
		this.Listen();
	}

	private void Listen() {

		projetoControle = new ProjetoControle(this);
		fonteControle = new FonteControle(this);
		quadroControle = new QuadroControle(this);
		circuitoControle = new CircuitoControle(this);
		equipamentoControle = new EquipamentoControle(this);
	}

	public JButton getBtnCopiarCircuito() {
		return btnCopiarCircuito;
	}

	public JButton getBtnCopiarEquipamento() {
		return btnCopiarEquipamento;
	}

	public JButton getBtnCopiarFonte() {
		return btnCopiarFonte;
	}

	public JButton getBtnCopiarProjeto() {
		return btnCopiarProjeto;
	}

	public JButton getBtnCopiarQuadro() {
		return btnCopiarQuadro;
	}

	public JButton getBtnExcluirEquipamento() {
		return btnExcluirEquipamento;
	}

	public JButton getBtnExcluirCircuito() {
		return btnExcluirCircuito;
	}

	public JButton getBtnExcluirFonte() {
		return btnExcluirFonte;
	}

	public JButton getBtnExcluirProjeto() {
		return btnExcluirProjeto;
	}

	public JButton getBtnExcluirQuadro() {
		return btnExcluirQuadro;
	}

	public JButton getBtnSalvarCircuito() {
		return btnSalvarCircuito;
	}

	public JButton getBtnSalvarEquipamento() {
		return btnSalvarEquipamento;
	}

	public JButton getBtnSalvarFonte() {
		return btnSalvarFonte;
	}

	public JButton getBtnSalvarProjeto() {
		return btnSalvarProjeto;
	}

	public JButton getBtnSalvarQuadro() {
		return btnSalvarQuadro;
	}

	public JComboBox<Concessionaria> getCbConcessionaria() {
		return this.cbConcessionaria;
	}

	public JComboBox<String> getCbDrQuadro() {
		return cbDrQuadro;
	}

	public JComboBox<Ligacao> getCbLigacaoEquipamento() {
		return cbLigacaoEquipamento;
	}

	public JComboBox<String> getCbPolos() {
		return cbPolosEquipamento;
	}

	public JComboBox<Quadro> getCbQuadroPai() {
		return cbQuadroPaiQuadro;
	}

	public JComboBox<Usabilidade> getCbUsabilidadeQuadro() {
		return cbUsabilidadeQuadro;
	}

	public JLabel getLblIdCircuito() {
		return lblIdCircuito;
	}

	public JLabel getLblIdFonte() {
		return lblIdFonte;
	}

	public JLabel getLblIdProjeto() {
		return lblIdProjeto;
	}

	public JLabel getLblIdQuadro() {
		return lblIdQuadro;
	}

	public JPanel getPanelCircuito() {
		return panelCircuito;
	}

	public JPanel getPanelFonte() {
		return panelFonte;
	}

	public JPanel getPanelProjeto() {
		return this.panelProjeto;
	}

	public JPanel getPanelQuadro() {
		return panelQuadro;
	}

	public JTable getTableEquipamentos() {
		return tableEquipamentos;
	}

	public JTable getTableFontes() {
		return tableFontes;
	}

	public void setTableFontes(JTable tableFontes) {
		this.tableFontes = tableFontes;
	}

	public JTable getTableProjetos() {
		return tableProjetos;
	}

	public JTable getTableQuadros() {
		return tableQuadros;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JTextField getTxtData() {
		return txtData;
	}

	public JTextPane getTxtDescricaoProjeto() {
		return txtDescricaoProjeto;
	}

	public JTextField getTxtFdEquipamento() {
		return txtFdEquipamento;
	}

	public JTextField getTxtFdQuadro() {
		return txtFdQuadro;
	}

	public JTextField getTxtFpEquipamento() {
		return txtFpEquipamento;
	}

	public JTextField getTxtFpQuadro() {
		return txtFpQuadro;
	}

	public JTextField getTxtLocalEquipamento() {
		return txtLocalEquipamento;
	}

	public JTextField getTxtLocalQuadro() {
		return txtLocalQuadro;
	}

	public JTextField getTxtNomeCircuito() {
		return txtNomeCircuito;
	}

	public JTextField getTxtNomeEquipamento() {
		return txtNomeEquipamento;
	}

	public JTextField getTxtNomeFonte() {
		return this.txtNomeFonte;
	}

	public JTextField getTxtNomeProjeto() {
		return txtNomeProjeto;
	}

	public JTextField getTxtNomeQuadro() {
		return txtNomeQuadro;
	}

	public JTextField getTxtPotenciaEquipamento() {
		return txtPotenciaEquipamento;
	}

	public JTextField getTxtTensaoFonte() {
		return txtTensaoFonte;
	}

	public JComboBox<UnidadePontencia> getCbUnidadePotEquipamento() {
		return cbUnidadePotEquipamento;
	}

	public void setCbUnidadePotEquipamento(JComboBox<UnidadePontencia> cbUnidadePotEquipamento) {
		this.cbUnidadePotEquipamento = cbUnidadePotEquipamento;
	}

	public JTable getTableCircuitos() {
		return tableCircuitos;
	}

	public JButton getBtnCurtoCirCircuito() {
		return btnCurtoCirCircuito;
	}

	public void setBtnCurtoCirCircuito(JButton btnCurtoCirCircuito) {
		this.btnCurtoCirCircuito = btnCurtoCirCircuito;
	}

	public JTextField getTxtFServicoEquipamento() {
		return txtFServicoEquipamento;
	}

	public void setTxtFServicoEquipamento(JTextField txtFServicoEquipamento) {
		this.txtFServicoEquipamento = txtFServicoEquipamento;
	}

	public JTextField getTxtFSimutaneadadeEquipamento() {
		return txtFSimutaneadadeEquipamento;
	}

	public void setTxtFSimutaneadadeEquipamento(JTextField txtFSimutaneadadeEquipamento) {
		this.txtFSimutaneadadeEquipamento = txtFSimutaneadadeEquipamento;
	}

	public JTextField getTxtFUtilizacaoEquipamento() {
		return txtFUtilizacaoEquipamento;
	}

	public void setTxtFUtilizacaoEquipamento(JTextField txtFUtilizacaoEquipamento) {
		this.txtFUtilizacaoEquipamento = txtFUtilizacaoEquipamento;
	}

	public JTextField getTxtQuantidadeEquipamento() {
		return txtQuantidadeEquipamento;
	}

	public void setTxtQuantidadeEquipamento(JTextField txtQuantidadeEquipamento) {
		this.txtQuantidadeEquipamento = txtQuantidadeEquipamento;
	}

	public JTextField getTxtRendimentoEquipamento() {
		return txtRendimentoEquipamento;
	}

	public void setTxtRendimentoEquipamento(JTextField txtRendimentoEquipamento) {
		this.txtRendimentoEquipamento = txtRendimentoEquipamento;
	}

	public JPanel getPanelEquipamento() {
		return panelEquipamento;
	}

	public void setPanelEquipamento(JPanel panelEquipamento) {
		this.panelEquipamento = panelEquipamento;
	}

	public JButton getBtnCondutorCircuito() {
		return btnCondutorCircuito;
	}

	public void setBtnCondutorCircuito(JButton btnCondutorCircuito) {
		this.btnCondutorCircuito = btnCondutorCircuito;
	}

	public void setTableCircuitos(JTable tableCircuitos) {
		this.tableCircuitos = tableCircuitos;
	}

	public void setAbas(JTabbedPane abas) {
		this.abas = abas;
	}

	public JTabbedPane getAbas() {
		return abas;
	}

	public JComboBox<Usabilidade> getCbUsabilidadeEquipamento() {
		return cbUsabilidadeEquipamento;
	}

	public void setCbUsabilidadeEquipamento(JComboBox<Usabilidade> cbUsabilidadeEquipamento) {
		this.cbUsabilidadeEquipamento = cbUsabilidadeEquipamento;
	}

	public JButton getBtnCondutorQuadro() {
		return btnCondutorQuadro;
	}

	public void setBtnCondutorQuadro(JButton btnCondutorQuadro) {
		this.btnCondutorQuadro = btnCondutorQuadro;
	}

	public JButton getBtnCurtoCirQuadro() {
		return btnCurtoCirQuadro;
	}

	public void setBtnCurtoCirQuadro(JButton btnCurtoCirQuadro) {
		this.btnCurtoCirQuadro = btnCurtoCirQuadro;
	}

	public JComboBox<String> getCbPolosEquipamento() {
		return cbPolosEquipamento;
	}

	public void setCbPolosEquipamento(JComboBox<String> cbPolosEquipamento) {
		this.cbPolosEquipamento = cbPolosEquipamento;
	}

	public JTextField getTxtPerdasEquipamento() {
		return txtPerdasEquipamento;
	}

	public void setTxtPerdasEquipamento(JTextField txtPerdasEquipamento) {
		this.txtPerdasEquipamento = txtPerdasEquipamento;
	}

	public EquipamentoControle getEquipamentoControle() {
		return equipamentoControle;
	}

	public void setEquipamentoControle(EquipamentoControle equipamentoControle) {
		this.equipamentoControle = equipamentoControle;
	}

	public JLabel getLblIdEquipamento() {
		return lblIdEquipamento;
	}

	public void setLblIdEquipamento(JLabel lblIdEquipamento) {
		this.lblIdEquipamento = lblIdEquipamento;
	}

	public void setBtnCopiarCircuito(JButton btnCopiarCircuito) {
		this.btnCopiarCircuito = btnCopiarCircuito;
	}

	public void setBtnCopiarEquipamento(JButton btnCopiarEquipamento) {
		this.btnCopiarEquipamento = btnCopiarEquipamento;
	}

	public void setBtnCopiarFonte(JButton btnCopiarFonte) {
		this.btnCopiarFonte = btnCopiarFonte;
	}

	public void setBtnCopiarProjeto(JButton btnCopiarProjeto) {
		this.btnCopiarProjeto = btnCopiarProjeto;
	}

	public void setBtnCopiarQuadro(JButton btnCopiarQuadro) {
		this.btnCopiarQuadro = btnCopiarQuadro;
	}

	public void setBtnExcluirEquipamento(JButton btnExcluirEquipamento) {
		this.btnExcluirEquipamento = btnExcluirEquipamento;
	}

	public void setBtnExcluirCircuito(JButton btnExcluirCircuito) {
		this.btnExcluirCircuito = btnExcluirCircuito;
	}

	public void setBtnExcluirFonte(JButton btnExcluirFonte) {
		this.btnExcluirFonte = btnExcluirFonte;
	}

	public void setBtnExcluirProjeto(JButton btnExcluirProjeto) {
		this.btnExcluirProjeto = btnExcluirProjeto;
	}

	public void setBtnExcluirQuadro(JButton btnExcluirQuadro) {
		this.btnExcluirQuadro = btnExcluirQuadro;
	}

	public void setBtnSalvarCircuito(JButton btnSalvarCircuito) {
		this.btnSalvarCircuito = btnSalvarCircuito;
	}

	public void setBtnSalvarEquipamento(JButton btnSalvarEquipamento) {
		this.btnSalvarEquipamento = btnSalvarEquipamento;
	}

	public void setBtnSalvarFonte(JButton btnSalvarFonte) {
		this.btnSalvarFonte = btnSalvarFonte;
	}

	public void setBtnSalvarProjeto(JButton btnSalvarProjeto) {
		this.btnSalvarProjeto = btnSalvarProjeto;
	}

	public void setBtnSalvarQuadro(JButton btnSalvarQuadro) {
		this.btnSalvarQuadro = btnSalvarQuadro;
	}

	public void setCbConcessionaria(JComboBox<Concessionaria> cbConcessionaria) {
		this.cbConcessionaria = cbConcessionaria;
	}

	public void setCbDrQuadro(JComboBox<String> cbDrQuadro) {
		this.cbDrQuadro = cbDrQuadro;
	}

	public void setCbLigacaoEquipamento(JComboBox<Ligacao> cbLigacaoEquipamento) {
		this.cbLigacaoEquipamento = cbLigacaoEquipamento;
	}

	public void setCbQuadroPai(JComboBox<Quadro> cbQuadroPai) {
		this.cbQuadroPaiQuadro = cbQuadroPai;
	}

	public void setCbUsabilidadeQuadro(JComboBox<Usabilidade> cbUsabilidadeQuadro) {
		this.cbUsabilidadeQuadro = cbUsabilidadeQuadro;
	}

	public void setConcessionaria(List<Concessionaria> lista) {

		for (Concessionaria con : lista) {
			this.getCbConcessionaria().addItem(con);
		}
	}

	public void setUnidadeEquipamento(List<UnidadePontencia> lista) {

		for (UnidadePontencia con : lista) {
			this.getCbUnidadePotEquipamento().addItem(con);
		}
	}

	public void setUsabilidadeQuadro(List<Usabilidade> lista) {

		for (Usabilidade con : lista) {
			this.getCbUsabilidadeQuadro().addItem(con);
		}
	}
	
	public void setUsabilidadeEquipamento(List<Usabilidade> lista) {

		for (Usabilidade con : lista) {
			this.getCbUsabilidadeEquipamento().addItem(con);
		}
	}
	
	public void setLigacaoEquipamento(List<Ligacao> lista) {

		for (Ligacao con : lista) {
			this.getCbLigacaoEquipamento().addItem(con);
		}
	}

	public void setQuadros(List<Quadro> lista) {

		for (Quadro con : lista) {
			this.getCbQuadroPai().addItem(con);
		}
	}

	public void setLblIdCircuito(JLabel lblIdCircuito) {
		this.lblIdCircuito = lblIdCircuito;
	}

	public void setLblIdFonte(JLabel lblIdFonte) {
		this.lblIdFonte = lblIdFonte;
	}

	public void setLblIdProjeto(JLabel lblIdProjeto) {
		this.lblIdProjeto = lblIdProjeto;
	}

	public void setLblIdQuadro(JLabel lblIdQuadro) {
		this.lblIdQuadro = lblIdQuadro;
	}

	public void setPanelProjeto(JPanel panelProjeto) {
		this.panelProjeto = panelProjeto;
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	public void setTableEquipamentos(JTable tableEquipamentos) {
		this.tableEquipamentos = tableEquipamentos;
	}

	public void setTxtAutor(JTextField txtAutor) {
		this.txtAutor = txtAutor;
	}

	public void setTxtData(JTextField txtData) {
		this.txtData = txtData;
	}

	public void setTxtDescricaoProjeto(JTextPane txtDescricaoProjeto) {
		this.txtDescricaoProjeto = txtDescricaoProjeto;
	}

	public void setTxtFdEquipamento(JTextField txtFdEquipamento) {
		this.txtFdEquipamento = txtFdEquipamento;
	}

	public void setTxtFdQuadro(JTextField txtFdQuadro) {
		this.txtFdQuadro = txtFdQuadro;
	}

	public void setTxtFpEquipamento(JTextField txtFpEquipamento) {
		this.txtFpEquipamento = txtFpEquipamento;
	}

	public void setTxtFpQuadro(JTextField txtFpQuadro) {
		this.txtFpQuadro = txtFpQuadro;
	}

	public void setTxtFServico(JTextField txtFServico) {
		this.txtFServicoEquipamento = txtFServico;
	}

	public void setTxtLocalEquipamento(JTextField txtLocalEquipamento) {
		this.txtLocalEquipamento = txtLocalEquipamento;
	}

	public void setTxtLocalQuadro(JTextField txtLocalQuadro) {
		this.txtLocalQuadro = txtLocalQuadro;
	}

	public void setTxtNomeCircuito(JTextField txtNomeCircuito) {
		this.txtNomeCircuito = txtNomeCircuito;
	}

	public void setTxtNomeEquipamento(JTextField txtNomeEquipamento) {
		this.txtNomeEquipamento = txtNomeEquipamento;
	}

	public void setTxtNomeFonte(JTextField txtNomeFonte) {
		this.txtNomeFonte = txtNomeFonte;
	}

	public void setTxtNomeProjeto(JTextField txtNomeProjeto) {
		this.txtNomeProjeto = txtNomeProjeto;
	}

	public void setTxtNomeQuadro(JTextField txtNomeQuadro) {
		this.txtNomeQuadro = txtNomeQuadro;
	}

	public void setTxtPotenciaEquipamento(JTextField txtPotenciaEquipamento) {
		this.txtPotenciaEquipamento = txtPotenciaEquipamento;
	}

	public void setTxtTensaoFonte(JTextField txtTensaoFonte) {
		this.txtTensaoFonte = txtTensaoFonte;
	}

	public ProjetoControle getProjetoControle() {
		return projetoControle;
	}

	public void setProjetoControle(ProjetoControle projetoControle) {
		this.projetoControle = projetoControle;
	}

	public FonteControle getFonteControle() {
		return fonteControle;
	}

	public void setFonteControle(FonteControle fonteControle) {
		this.fonteControle = fonteControle;
	}

	public QuadroControle getQuadroControle() {
		return quadroControle;
	}

	public void setQuadroControle(QuadroControle quadroControle) {
		this.quadroControle = quadroControle;
	}

	public CircuitoControle getCircuitoControle() {
		return circuitoControle;
	}

	public void setCircuitoControle(CircuitoControle circuitoControle) {
		this.circuitoControle = circuitoControle;
	}
}
