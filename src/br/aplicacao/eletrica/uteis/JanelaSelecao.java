package br.aplicacao.eletrica.uteis;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import br.aplicacao.eletrica.enums.TipoSelecao;

public class JanelaSelecao {
	private JFileChooser selecao;
	private int opcao;

	public JanelaSelecao() {
		selecao = new JFileChooser();
	}

	private FileFilter filtro() {
		FileFilter filtro = new FileFilter() {

			@Override
			public boolean accept(File f) {
				return (f.getName().endsWith(".csv") || f.getName().endsWith(".txt") || f.isDirectory());
			}

			@Override
			public String getDescription() {
				return "Somente diretórios, .csv e .txt";
			}
		};
		return filtro;
	}

	public void selecao(TipoSelecao tipo) {

		selecao.setFileFilter(filtro());
		if(tipo  == TipoSelecao.SALVAR) {
			opcao = selecao.showSaveDialog(null);
		}
		if(tipo  == TipoSelecao.ABRIR) {
			opcao = selecao.showOpenDialog(null);
		}
	}

	public boolean confirma() {
		boolean t = false;
		if (opcao == JFileChooser.APPROVE_OPTION) {
			t = true;
			opcao = -1;
		} else {
			t = false;
			opcao = -1;
		}
		return t;

	}

	public File getSelecao() {
		return this.selecao.getSelectedFile();
	}
}
