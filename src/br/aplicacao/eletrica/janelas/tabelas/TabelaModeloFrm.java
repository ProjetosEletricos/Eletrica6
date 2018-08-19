package br.aplicacao.eletrica.janelas.tabelas;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

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
import javax.swing.filechooser.FileFilter;
import javax.swing.table.TableModel;

public class TabelaModeloFrm extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private TabelaControle tabelaControle;
	private JTable table;

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

		JMenuItem mntmCarregarTxt = new JMenuItem("Carregar Txt");
		mntmCarregarTxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolhedor = new JFileChooser();

				escolhedor.setFileFilter(new FileFilter() {
					@Override
					public String getDescription() {
						return "Somente diretórios e .txt"; // Exibe essa mensagem
					}

					@Override
					public boolean accept(File f) {
						return (f.getName().endsWith(".txt") || f.isDirectory());
						// Só mostra arquivos terminados em .txt ou diretórios
					}
				});

				int opcaoEscolhida = escolhedor.showOpenDialog(null); // Janela para abrir um arquivo

				if (opcaoEscolhida == JFileChooser.APPROVE_OPTION) {
					

					final Object[][] dados = new Object[5][3];
					File selectedFile = escolhedor.getSelectedFile();
					
				    final List<String> lines = selectedFile.carregarLinhas("src/data.txt");
				    for (int i = 0; i < lines.size(); i++) {
				        final String[] data = ArquivoTextoProvider.lerDados(";", lines.get(i));
				        dados[i][0] = data[2];
				        dados[i][1] = data[3];
				        dados[i][2] = data[4];
				    }
					
					
					
					
				}

			}
		});
		mnMenu.add(mntmCarregarTxt);
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

		// tabelaControle = new TabelaControle(this);
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
}
