package br.aplicacao.eletrica.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@Table(name = "Projeto")
@TableModel
public class Projeto implements Entidade<Projeto> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(colName = "Nome", colPosition = 0)
	private String nome;
	private String autor;
	@Column(colName = "Data", colPosition = 1)
	private String data;
	private String descricao;
	@OneToMany(targetEntity = Fonte.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Fonte> fontes;

	public Projeto() {
		fontes = new ArrayList<>();
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setFontes(List<Fonte> fontes) {
		this.fontes = fontes;
		this.fontes.clear();
		this.fontes.addAll(fontes);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public String getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Fonte> getFontes() {
		return fontes;
	}
	
	public void addFonte(Fonte fonte) {
		this.fontes.add(fonte);
	}

	@Override
	public Projeto clonarSemID() {
		Projeto p = copiar();
		p.setId(null);
		return p;
	}

	@Override
	public Projeto copiar() {

		Projeto p = new Projeto();
		p.setId(id);
		p.setNome(nome);
		p.setAutor(autor);
		p.setData(data);
		p.setDescricao(descricao);
		for (Fonte f : fontes) {
			p.fontes.add(f);
		}

		return p;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())

			return false;
		final Projeto other = (Projeto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public void apagar() {

		id = 0;
		nome = "";
		autor = "";
		descricao = "";
		fontes.clear();
	}
}
