package br.aplicacao.eletrica.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.aplicacao.eletrica.calculo.CorrenteIB;
import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@Table(name = "Circuito")
@TableModel
public class Circuito implements Entidade<Circuito> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "quadro_id")
	private Quadro quadro;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(colName = "Condutor", colPosition = 1)
	private Condutor condutor;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(colName = "Dados CC", colPosition = 2)
	private Curto dadosCurtoCircuito;
	@OneToMany(mappedBy = "circuito", targetEntity = Equipamento.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Equipamento> equipamentos;
	@Column(colName = "Circuito", colPosition = 0)
	private String nome;

	public Circuito() {
		equipamentos = new ArrayList<Equipamento>();
		condutor = new Condutor();
		dadosCurtoCircuito = new Curto();
	}

	public void addEquipamento(Equipamento equipamento) {
		this.equipamentos.add(equipamento);
	}

	@Override
	public Circuito clonarSemID() {
		Circuito c = copiar();
		c.setId(null);
		return c;
	}

	@Override
	public Circuito copiar() {
		Circuito c = new Circuito();
		c.setId(id);
		c.setNome(nome);
		c.setCondutor(condutor);
		c.setCurto(dadosCurtoCircuito);

		for (Equipamento e : equipamentos) {
			c.equipamentos.add(e);
		}
		return c;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())

			return false;
		final Circuito other = (Circuito) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public double getCorrenteIB() {
		return new CorrenteIB()//
				.withEquipamentos(this.getEquipamentos())//
				.valor();
	}

	public Curto getCurto() {
		return dadosCurtoCircuito;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public Quadro getQuadro() {
		return quadro;
	}

	public void setQuadro(Quadro quadro) {
		this.quadro = quadro;
	}

	public String getNome() {
		return nome;
	}

	public List<Equipamento> getEquipamentos() {
		return equipamentos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public void setCurto(Curto dadosCurtoCircuito) {
		this.dadosCurtoCircuito = dadosCurtoCircuito;
	}

	public void setEquipamentos(List<Equipamento> equipamentosLista) {
		this.equipamentos.clear();
		this.equipamentos.addAll(equipamentosLista);
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public void apagar() {

		id = null;
		quadro = null;
		condutor = null;
		dadosCurtoCircuito = null;
		equipamentos.clear();
		nome = "";

	}
}
