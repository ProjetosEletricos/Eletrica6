package br.aplicacao.eletrica.modelo.projeto;

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

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@TableModel
public class Quadro implements Entidade<Quadro> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "fonte_id")
	private Fonte fonte;
	@OneToMany(mappedBy = "quadro", targetEntity = Circuito.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Circuito> circuitos;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Condutor condutor;
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Curto dadosCurtoCircuito;
	private String drGeral;
	private double fd;
	private double fp;
	@Column(colName = "Local", colPosition = 1)
	private String local;
	@Column(colName = "Nome", colPosition = 0)
	private String nome;
	private double pot100PercDem;
	private String usabilidade;
	private UnidadePontencia unidade;

	public Quadro() {
		circuitos = new ArrayList<Circuito>();
	}

	public void addCircuito(Circuito circuito) {
		this.circuitos.add(circuito);
	}


	public List<Circuito> getCircuitos() {
		return circuitos;
	}

	public String getLocal() {
		return local;
	}

	public String getNome() {
		return nome;
	}

	public double getPot100PercDem() {
		return this.pot100PercDem;
	}

	public Double getDemanda() {

		double total = 0;

		for (Circuito c : this.getCircuitos()) {
			for (Equipamento e : c.getEquipamento()) {
				total += e.getQuantidade() * e.getDemanda() * e.getfSimu();
			}
		}

/*		for (Quadro subQuadro : this.getQuadros()) {

			total += subQuadro.getDemanda();
		}*/

		return total;
	}

	public double getPotenciaInstalada() {

		double total = 0;

		for (Circuito c : this.getCircuitos()) {
			for (Equipamento e : c.getEquipamento()) {
				total += e.getQuantidade() * e.getDemanda();
			}
		}

/*		for (Quadro q : this.getQuadros()) {
			for (Circuito c : q.getCircuitos()) {
				for (Equipamento e : c.getEquipamento()) {
					total += e.getQuantidade() * e.getDemanda();
				}
			}
		}*/
		return total;
	}


	public UnidadePontencia getUnidade() {
		return unidade;
	}

	public String getUsabilidade() {
		return this.usabilidade;
	}

	public String getDrGeral() {
		return this.drGeral;
	}

	public double getFd() {
		return this.fd;
	}

	public double getFp() {
		return this.fp;
	}

	public Fonte getFonte() {
		return fonte;
	}

	public void setFonte(Fonte fonte) {
		this.fonte = fonte;
	}

	public void setCircuitos(List<Circuito> circuitos) {
		this.circuitos.clear();
		this.circuitos.addAll(circuitos);
	}

	public void setDrGeral(String drGeral) {
		this.drGeral = drGeral;
	}

	public void setFd(double fd) {
		this.fd = fd;
	}

	public void setFp(double fp) {
		this.fp = fp;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Condutor getCondutor() {
		return condutor;
	}

	public void setCondutor(Condutor condutor) {
		this.condutor = condutor;
	}

	public Curto getDadosCurtoCircuito() {
		return dadosCurtoCircuito;
	}

	public void setDadosCurtoCircuito(Curto dadosCurtoCircuito) {
		this.dadosCurtoCircuito = dadosCurtoCircuito;
	}

	public void setPot100PercDem(double pot100PercDem) {
		this.pot100PercDem = pot100PercDem;
	}


	public void setUnidade(UnidadePontencia unidade) {
		this.unidade = unidade;
	}

	public void setUsabilidade(String usabilidade) {
		this.usabilidade = usabilidade;
	}

	@Override
	public Quadro clonarSemID() {
		Quadro q = copiar();
		q.setId(null);
		return this;
	}

	@Override
	public Quadro copiar() {
		Quadro q = new Quadro();
		q.setId(id);
		q.setNome(nome);
		q.setUnidade(unidade);

		for (Circuito c : q.circuitos) {
			circuitos.add(c.copiar());
		}
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())

			return false;
		final Quadro other = (Quadro) obj;
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

}
