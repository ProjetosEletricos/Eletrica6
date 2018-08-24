package br.aplicacao.eletrica.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.aplicacao.eletrica.calculo.ConversorPotencia;
import br.aplicacao.eletrica.calculo.Corrente;
import br.aplicacao.eletrica.calculo.Demanda;
import br.aplicacao.eletrica.calculo.NumFases;
import br.aplicacao.eletrica.enums.Ligacao;
import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.enums.Usabilidade;
import br.aplicacao.eletrica.uteis.tableModel.Column;
import br.aplicacao.eletrica.uteis.tableModel.TableModel;

@Entity
@Table(name = "Equipamento")
@TableModel
public class Equipamento implements Entidade<Equipamento> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne()
	private Circuito circuito;
	private Ligacao ligacao;
	private String ligacaoReal;
	@Column(colName = "Nome", colPosition = 0)
	private String nome;
	private int nPolos;
	private double perdasReator;
	@Column(colName = "Potência", colPosition = 1)
	private double potencia;
	private int quantidade;
	private double rendimento = 1;
	private String descricao;
	private double fd = 1;
	private double fp = 1;
	private double fs = 1;
	private double fSimu = 1;
	private double fu = 1;
	private UnidadePontencia unidade;
	private Usabilidade usabilidade;
	private Double tensaoFN;

	// ----------------------------------------------

	public Equipamento() {

	}

	public double getCorrente() {
		return new Corrente()//
				.withLigacao(getLigacao())//
				.withPotencia(this.getPotencia())//
				.withTensao(this.getTensaoFN())//
				.withUnidade(this.getUnidade())
				.withFP(this.fp)//
				.valor();
	}

	public Double getDemanda(UnidadePontencia unidadeDestino) {
		return new Demanda()//
				.withFd(this.getFd())//
				.withFp(this.getFp())//
				.withFu(this.getFu())//
				.withPerdasReator(this.getPerdasReator())//
				.withPotencia(this.getPotencia())//
				.withRendimento(this.getRendimento())//
				.withUnidadeOrigem(this.getUnidade())//
				.withUnidadeDestino(unidadeDestino)//
				.withUsabilidade(this.getUsabilidade())//
				.valor();
	}

	public int getNFases() {
		return new NumFases()//
				.withLigacao(this.getLigacao())//
				.numero();
	}

	public Double getPotencia(UnidadePontencia unidadeDestino) {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidade)//
				.withUnidadeDestino(unidadeDestino)//
				.converte();
	}

	public Double getTensaoFN() {
		double tensaoFonte = 0;
		
		try {
			tensaoFonte = getCircuito().getQuadro().getFonte().getTensaoFN();
			if (getCircuito().getQuadro().getFonte().getTensaoFN() == this.tensaoFN) {
				tensaoFonte = this.tensaoFN;
			} else {
				System.out.println("Tensão imprópria para a Fonte!");
				tensaoFonte = 0;
			}
		} catch (Exception e) {
			System.out.println("Não tem fonte");
			tensaoFonte = this.tensaoFN;
		}
		return tensaoFonte;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getFd() {
		return fd;
	}

	public double getFp() {
		return fp;
	}

	public double getFs() {
		return fs;
	}

	public double getfSimu() {
		return fSimu;
	}

	public double getFu() {
		return fu;
	}

	public Ligacao getLigacao() {
		return ligacao;
	}

	public String getLigacaoReal() {
		return ligacaoReal;
	}

	public String getNome() {
		return nome;
	}

	public int getnPolos() {
		return nPolos;
	}

	public double getPerdasReator() {
		return perdasReator;
	}

	public double getPotencia() {
		return potencia;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getRendimento() {
		return rendimento;
	}

	public UnidadePontencia getUnidade() {
		return unidade;
	}

	public Circuito getCircuito() {
		return circuito;
	}

	public void setCircuito(Circuito circuito) {
		this.circuito = circuito;
	}

	public Usabilidade getUsabilidade() {
		return usabilidade;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setFd(double fd) {
		this.fd = fd;
	}

	public void setFp(double fp) {
		this.fp = fp;
	}

	public void setFs(double fs) {
		this.fs = fs;
	}

	public void setfSimu(double fSimu) {
		this.fSimu = fSimu;
	}

	public void setFu(double fu) {
		this.fu = fu;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setLigacao(Ligacao ligacao) {
		this.ligacao = ligacao;
	}

	public void setLigacaoReal(String ligacaoReal) {
		this.ligacaoReal = ligacaoReal;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setnPolos(int nPolos) {
		this.nPolos = nPolos;
	}

	public void setTensaoFN(Double tensaoFN) {
		this.tensaoFN = tensaoFN;
	}

	public void setPerdasReator(double perdasReator) {
		this.perdasReator = perdasReator;
	}

	public void setPotencia(double potencia) {
		this.potencia = potencia;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public void setUnidade(UnidadePontencia unidade) {
		this.unidade = unidade;
	}

	public void setUsabilidade(Usabilidade usabilidade) {
		this.usabilidade = usabilidade;
	}

	@Override
	public Equipamento clonarSemID() {
		Equipamento e = copiar();
		e.setId(null);
		return this;
	}

	@Override
	public Equipamento copiar() {
		Equipamento e = new Equipamento();
		e.setId(id);
		e.setNome(nome);
		e.setDescricao(descricao);
		e.setFd(fd);
		e.setFp(fp);
		e.setFs(fSimu);
		e.setfSimu(fSimu);
		e.setFu(fu);
		e.setLigacao(ligacao);
		e.setLigacaoReal(ligacaoReal);
		e.setnPolos(nPolos);
		e.setPerdasReator(perdasReator);
		e.setPotencia(potencia);
		e.setQuantidade(quantidade);
		e.setRendimento(rendimento);
		e.setUnidade(unidade);
		e.setUsabilidade(usabilidade);

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
		final Equipamento other = (Equipamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return nome;
	}

	@Override
	public void apagar() {

		id = null;
		circuito = null;
		ligacao = null;
		ligacaoReal = "";
		nome = "";
		nPolos = 0;
		perdasReator = 0;
		potencia = 0;
		quantidade = 0;
		rendimento = 0;
		descricao = "";
		fd = 0;
		fp = 0;
		fs = 0;
		fSimu = 0;
		fu = 0;
		unidade = null;
		usabilidade = null;

	}
}
