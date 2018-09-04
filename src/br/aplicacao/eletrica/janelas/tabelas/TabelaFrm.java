package br.aplicacao.eletrica.janelas.tabelas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import br.aplicacao.eletrica.enums.TipoSelecao;
import br.aplicacao.eletrica.servico.CapacidadeCorrenteService;
import br.aplicacao.eletrica.uteis.GravarCSV;
import br.aplicacao.eletrica.uteis.JanelaSelecao;
import br.aplicacao.eletrica.uteis.LerCSV;

public class TabelaFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TabelaControle tabelaControle;
	private JTable table;
	private JMenuItem mntmCarregarCSV;
	private JMenuItem mntmSalvarCSV;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					TabelaFrm frame = new TabelaFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TabelaFrm() {
		setResizable(true);
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 523, 345);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mnMenu.add(mntmImprimir);

		mntmCarregarCSV = new JMenuItem("Carregar CSV");
		mntmCarregarCSV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JanelaSelecao janela = new JanelaSelecao();
				janela.selecao(TipoSelecao.ABRIR);
				if (janela.confirma()) {
					switch (title) {
					case "CAPACIDADE DE CORRENTE":
						LerCSV dados = new LerCSV(janela.getSelecao().toString());
						String[][] tabela = dados.toMatriz();
						CapacidadeCorrenteService.salva(tabela);
						tabelaControle.iniciaTabela(CapacidadeCorrenteService.getAll());
						break;

					default:
						break;
					}
				}
			}
		});
		mntmCarregarCSV.setName("mntmCarregarCSV");
		mnMenu.add(mntmCarregarCSV);

		mntmSalvarCSV = new JMenuItem("Salvar CSV");
		mntmSalvarCSV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JanelaSelecao janela = new JanelaSelecao();
				janela.selecao(TipoSelecao.SALVAR);
				if (janela.confirma()) {
					GravarCSV arquivo = new GravarCSV(janela.getSelecao().toString() + ".csv");
					switch (title) {
					case "CAPACIDADE DE CORRENTE":
						MenuSalvarCapacidadeCorrenteTabela menuSalvar = new MenuSalvarCapacidadeCorrenteTabela(arquivo);
						menuSalvar.abre();
						break;

					default:
						break;
					}
				}
			}
		});
		mnMenu.add(mntmSalvarCSV);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 513, 292);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSurrendersFocusOnKeystroke(true);
		table.setBorder(null);
		table.setEnabled(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		scrollPane.setViewportView(table);

		// -------------------------Controle-----------------------
		this.Listen();

	}

	private void Listen() {

		tabelaControle = new TabelaControle(this);
	}

	public void setModel(TableModel model) {
		table.setModel(model);
	}

	public void setPosicao() {
		Dimension d = this.getDesktopPane().getSize();
		this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public TabelaControle getTabelaControle() {
		return tabelaControle;
	}

	public void setTabelaControle(TabelaControle tabelaControle) {
		this.tabelaControle = tabelaControle;
	}

	public JMenuItem getMntmCarregarCSV() {
		return mntmCarregarCSV;
	}

	public void setMntmCarregarCSV(JMenuItem mntmCarregarCSV) {
		this.mntmCarregarCSV = mntmCarregarCSV;
	}

	public JMenuItem getMntmSalvarCsv() {
		return mntmSalvarCSV;
	}

	public void setMntmSalvarCsv(JMenuItem mntmSalvarCsv) {
		this.mntmSalvarCSV = mntmSalvarCsv;
	}
}
