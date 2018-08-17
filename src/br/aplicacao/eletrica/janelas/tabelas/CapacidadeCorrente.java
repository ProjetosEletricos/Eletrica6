package br.aplicacao.eletrica.janelas.tabelas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.aplicacao.eletrica.modelo.projeto.Entidade;
import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@TableModel
public class CapacidadeCorrente implements Entidade<CapacidadeCorrente> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(colName = "Secao", colPosition = 0)
	private Double secao;
	@Column(colName = "Metodo", colPosition = 1)
	private String metodo;
	@Column(colName = "Condutores", colPosition = 2)
	private Integer nCondutorCarr;
	@Column(colName = "Material", colPosition = 3)
	private String material;
	@Column(colName = "Valor", colPosition = 4)
	private Double valor;

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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
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

}
