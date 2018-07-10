package br.aplicacao.eletrica.modelo.projeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@TableModel
public class Concessionaria implements Entidade<Concessionaria> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double carga;
	private int disjuntorTM;
	private String eletroduto;
	private int fase;
	private String fornecimento;
	@Column(colName = "Local", colPosition = 1)
	private String local;
	private String metodo;
	private int neutro;
	@Column(colName = "Nome", colPosition = 0)
	private String nome;
	private int tensaoFN;
	private int terra;

	public Concessionaria() {
	}

	public Concessionaria(String nome) {

		this.nome = nome;

	}

	@Override
	public Concessionaria clonarSemID() {
		Concessionaria p = copiar();
		p.setId(null);
		return p;
	}

	@Override
	public Concessionaria copiar() {
		Concessionaria p = new Concessionaria();
		p.setId(id);
		p.setNome(nome);
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
		Concessionaria other = (Concessionaria) obj;
		if (this.id == null) {
			if (other.id != null)
				return false;
		} else if (!this.id.equals(other.id))
			return false;
		return true;
	}

	public double getCarga() {
		return carga;
	}

	public int getDisjuntorTM() {
		return disjuntorTM;
	}

	public String getEletroduto() {
		return eletroduto;
	}

	public int getFase() {
		return fase;
	}

	public String getFornecimento() {
		return fornecimento;
	}

	@Override
	public Integer getId() {
		return id;
	}

	public String getLocal() {
		return local;
	}

	public String getMetodo() {
		return metodo;
	}

	public int getNeutro() {
		return neutro;
	}

	public String getNome() {
		return nome;
	}

	public int getTensaoFN() {
		return tensaoFN;
	}

	public int getTerra() {
		return terra;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
		return result;
	}

	public void setCarga(double carga) {
		this.carga = carga;
	}

	public void setDisjuntorTM(int disjuntorTM) {
		this.disjuntorTM = disjuntorTM;
	}

	public void setEletroduto(String eletroduto) {
		this.eletroduto = eletroduto;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	public void setFornecimento(String fornecimento) {
		this.fornecimento = fornecimento;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public void setNeutro(int neutro) {
		this.neutro = neutro;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setTensaoFN(int tensaoFN) {
		this.tensaoFN = tensaoFN;
	}

	public void setTerra(int terra) {
		this.terra = terra;
	}

	@Override
	public String toString() {
		return nome;
	}
}
