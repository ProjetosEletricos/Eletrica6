package br.aplicacao.eletrica.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

/*@Entity
@Table(name = "Fonte")*/
@TableModel
public class Fonte2 implements Entidade<Fonte2> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne()
	private Projeto projeto;
	@OneToOne()
	@Column(colName = "Concessionária", colPosition = 2)
	private Concessionaria concessionaria;
	@OneToMany(mappedBy = "fonte", targetEntity = Quadro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Quadro> quadros;
	@Column(colName = "Nome", colPosition = 0)
	private String nome;
	@Column(colName = "TensãoFN", colPosition = 1)
	private double tensaoFN;

	public Fonte2() {
		quadros = new ArrayList<>();
	}

	public Double getPotenciaInstalada(UnidadePontencia unidadeDestino) {
		double total = 0;
		for (Quadro quadro : this.getQuadros()) {
			total += quadro.getPotenciaInstalada(unidadeDestino);
		}
		return total;
	}

	public Double getDemanda(UnidadePontencia unidadeDestino) {
		double total = 0;
		for (Quadro quadro : this.getQuadros()) {
			total += quadro.getDemanda(unidadeDestino);
		}
		return total;
	}

	public String getNome() {
		return nome;
	}

	public Concessionaria getConcessionaria() {
		return concessionaria;
	}

	public double getTensaoFN() {
		return tensaoFN;
	}

	public void setConcessionaria(Concessionaria concessionaria) {
		this.concessionaria = concessionaria;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setQuadros(List<Quadro> quadros) {
		this.quadros.clear();
		this.quadros.addAll(quadros);
	}
	
	public void addQuadro(Quadro quadro) {
		this.quadros.add(quadro);
	}

	public List<Quadro> getQuadros() {
		return quadros;
	}

	public void setTensaoFN(double tensaoFN) {
		this.tensaoFN = tensaoFN;
	}

	@Override
	public Fonte2 clonarSemID() {
		Fonte2 f = copiar();
		f.setId(null);
		return f;
	}

	@Override
	public Fonte2 copiar() {
		Fonte2 f = new Fonte2();
		f.setId(id);
		f.setNome(nome);
		f.setConcessionaria(concessionaria);
		f.setTensaoFN(tensaoFN);

		for (Quadro q : quadros) {
			f.quadros.add(q);
		}

		return f;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())

			return false;
		final Fonte2 other = (Fonte2) obj;
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

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public void apagar() {

		id = 0;
		projeto = null;
		concessionaria = null;
		quadros.clear();
		nome = "";
		tensaoFN = 0;
	}
}
