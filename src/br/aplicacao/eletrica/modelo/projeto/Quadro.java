package br.aplicacao.eletrica.modelo.projeto;

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
import javax.persistence.Transient;

import br.aplicacao.eletrica.calculo.PotenciaInstalada;
import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.enums.Usabilidade;
import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@Table(name = "Quadro")
@TableModel
public class Quadro implements Entidade<Quadro> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne()
	private Fonte fonte;
	@OneToMany(mappedBy = "quadro", targetEntity = Circuito.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Circuito> circuitos;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(colName = "Condutor", colPosition = 2)
	private Condutor condutor;
	@OneToOne(cascade = CascadeType.ALL)
	@Column(colName = "Dados CC", colPosition = 3)
	private Curto curto;
	private String drGeral;
	private double fd = 1;
	private double fp = 1;
	@Column(colName = "Local", colPosition = 1)
	private String local;
	@Column(colName = "Nome", colPosition = 0)
	private String nome;
	private double pot100PercDem;
	private Usabilidade usabilidade;
	private UnidadePontencia unidade;
	@Transient
	private Quadro quadroPaiQuadro;
	@OneToMany(targetEntity = Quadro.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Quadro> quadros;

	public Quadro() {
		circuitos = new ArrayList<Circuito>();
	}

	public Double getDemanda(UnidadePontencia unidadeDestino) {
		double total = 0;

		for (Circuito c : this.getCircuitos()) {
			for (Equipamento e : c.getEquipamentos()) {
				total += e.getQuantidade() * e.getDemanda(unidadeDestino) * e.getfSimu();
			}
		}

		try {
			for (Quadro subQuadro : this.getQuadros()) {
				total += subQuadro.getDemanda(unidadeDestino);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return total;
	}

	public double getPotenciaInstalada(UnidadePontencia unidadeDestino) {
		return new PotenciaInstalada()//
				.withQuadro(this)//
				.withUnidadeDestino(unidadeDestino)//
				.valor();
	}

	public void addQuadro(Quadro quadro) {
		this.quadros.add(quadro);
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

	public UnidadePontencia getUnidade() {
		return unidade;
	}

	public Usabilidade getUsabilidade() {
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

	public Quadro getQuadroPaiQuadro() {
		return quadroPaiQuadro;
	}

	public void setQuadroPaiQuadro(Quadro quadroPaiQuadro) {
		this.quadroPaiQuadro = quadroPaiQuadro;
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

	public Curto getCurto() {
		return curto;
	}

	public void setCurto(Curto dadosCurtoCircuito) {
		this.curto = dadosCurtoCircuito;
	}

	public void setPot100PercDem(double pot100PercDem) {
		this.pot100PercDem = pot100PercDem;
	}

	public void setUnidade(UnidadePontencia unidade) {
		this.unidade = unidade;
	}

	public void setUsabilidade(Usabilidade usabilidade) {
		this.usabilidade = usabilidade;
	}

	public List<Quadro> getQuadros() {
		return quadros;
	}

	public void setQuadros(List<Quadro> quadros) {
		this.quadros = quadros;
	}

	@Override
	public Quadro clonarSemID() {
		Quadro q = copiar();
		q.setId(null);
		return q;
	}

	@Override
	public Quadro copiar() {
		Quadro q = new Quadro();
		q.setId(id);
		q.setNome(nome);
		q.setUnidade(unidade);

		for (Circuito c : circuitos) {
			q.circuitos.add(c);
		}
		return q;
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

	@Override
	public void apagar() {

		id = null;
		fonte = null;
		circuitos.clear();
		condutor = null;
		curto = null;
		drGeral = "";
		fd = 0;
		fp = 0;
		local = "";
		nome = "";
		pot100PercDem = 0;
		usabilidade = null;
		unidade = null;
		quadroPaiQuadro = null;
		quadros.clear();
	}
}
