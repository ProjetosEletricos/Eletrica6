package br.aplicacao.eletrica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@TableModel
public class CapacidadeCorrente implements Entidade<CapacidadeCorrente> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(colName = "ID", colPosition = 0)
	private Integer id;
	@Column(colName = "Material", colPosition = 6)
	private String material;
	@Column(colName = "Secao", colPosition = 2)
	private Double secao;
	@Column(colName = "Metodo", colPosition = 3)
	private String metodo;
	@Column(colName = "Condutores", colPosition = 4)
	private Integer nCondutorCarr;
	@Column(colName = "Corrente", colPosition = 5)
	private Double corrente;
	@Column(colName = "Nível tensão", colPosition = 1)
	private String nivel;

	public Double getSecao() {
		return secao;
	}

	public void setSecao(Double secao) {
		this.secao = secao;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public Integer getnCondutorCarr() {
		return nCondutorCarr;
	}

	public void setnCondutorCarr(Integer nCondutorCarr) {
		this.nCondutorCarr = nCondutorCarr;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public Double getCorrente() {
		return corrente;
	}

	public void setCorrente(Double corrente) {
		this.corrente = corrente;
	}

	@Override
	public CapacidadeCorrente clonarSemID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CapacidadeCorrente copiar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void apagar() {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
