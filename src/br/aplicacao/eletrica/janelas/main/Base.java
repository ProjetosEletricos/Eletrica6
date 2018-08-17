package br.aplicacao.eletrica.janelas.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import br.aplicacao.eletrica.janelas.concessionaria.ConcessionariaFrm;

public class Base extends JFrame {

	public static JDesktopPane desktopPane;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BaseControle baseControle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					Base frame = new Base();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JPanel contentPanePrincipal;
	private JMenuItem mntmCapacidade1;

	/**
	 * Create the frame.
	 */
	public Base() {
		setTitle("PROJETOS EL\u00C9TRICOS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 713);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnJanelas = new JMenu("Menu");
		menuBar.add(mnJanelas);

		JMenuItem mntmNovoProjeto = new JMenuItem("Projetos");
		mntmNovoProjeto.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrincipalFrm form = new PrincipalFrm();

				Base.desktopPane.add(form);
				form.setVisible(true);
				form.setPosicao();
			}
		});
		mnJanelas.add(mntmNovoProjeto);

		JMenuItem mntmConcessionria = new JMenuItem("Concessionária");
		mntmConcessionria.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConcessionariaFrm form = new ConcessionariaFrm();

				Base.desktopPane.add(form);
				form.setVisible(true);
			}
		});
		mnJanelas.add(mntmConcessionria);

		JMenu mnTabelas = new JMenu("Tabelas");
		menuBar.add(mnTabelas);

		JMenuItem mntmTiposDeLinhas = new JMenuItem("Tipos de linhas");
		mnTabelas.add(mntmTiposDeLinhas);

		JMenu mntmCapacidadeDeConduo = new JMenu("Capacidade de condução:");
		mnTabelas.add(mntmCapacidadeDeConduo);

		mntmCapacidade1 = new JMenuItem("PVC:70°:Métodos A1, A2, B1, B2, C e D");
		mntmCapacidade1.setName("mntmCapacidade1");
		mntmCapacidadeDeConduo.add(mntmCapacidade1);
		contentPanePrincipal = new JPanel();
		contentPanePrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanePrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPanePrincipal);

		Base.desktopPane = new JDesktopPane();
		contentPanePrincipal.add(Base.desktopPane, BorderLayout.CENTER);

		// -------------------------Controle-----------------------
		this.Listen();
	}

	private void Listen() {
		baseControle = new BaseControle(this);
	}

	public JPanel getContentPanePrincipal() {
		return contentPanePrincipal;
	}

	public void setContentPanePrincipal(JPanel contentPanePrincipal) {
		this.contentPanePrincipal = contentPanePrincipal;
	}

	public JMenuItem getMntmCapacidade1() {
		return mntmCapacidade1;
	}

	public void setMntmCapacidade1(JMenuItem mntmCapacidade1) {
		this.mntmCapacidade1 = mntmCapacidade1;
	}

	public BaseControle getBaseControle() {
		return baseControle;
	}

	public void setBaseControle(BaseControle baseControle) {
		this.baseControle = baseControle;
	}

}
