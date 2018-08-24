package br.aplicacao.eletrica.janelas.tabelas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;

import br.aplicacao.eletrica.uteis.LerCSV;

public class TabelaModeloFrm extends JInternalFrame {

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
			public void run() {
				try {
					TabelaModeloFrm frame = new TabelaModeloFrm();
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
	public TabelaModeloFrm() {
		setTitle("Tabela");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);

		JMenuItem mntmImprimir = new JMenuItem("Imprimir");
		mnMenu.add(mntmImprimir);

		mntmCarregarCSV = new JMenuItem("Carregar CSV");
/*		mntmCarregarCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser selecao = new JFileChooser();
				selecao.setFileFilter(null);
				int opcao = selecao.showSaveDialog(null);
				if (opcao == JFileChooser.APPROVE_OPTION) {

					LerCSV dados = new LerCSV(selecao.getSelectedFile().toString());
					String[][] tabela = dados.lerTabela();
					Util.salvarMatrizToTabelaCapacidadeCorrente(tabela);
					System.out.println("Passou por aqui novamente");
					System.out.println("Passou por aqui");

				}
			}
		});*/
		mntmCarregarCSV.setName("mntmCarregarCSV");
		mnMenu.add(mntmCarregarCSV);

		mntmSalvarCSV = new JMenuItem("Salvar CSV");
		mnMenu.add(mntmSalvarCSV);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 435, 235);
		contentPane.add(scrollPane);

		table = new JTable();
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
