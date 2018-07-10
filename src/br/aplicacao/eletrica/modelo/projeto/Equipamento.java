package br.aplicacao.eletrica.modelo.projeto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.aplicacao.eletrica.calculo.ConversorPotencia;
import br.aplicacao.eletrica.enums.UnidadePontencia;

@Entity
public class Equipamento implements Entidade<Equipamento> {

	private String descricao;

	private double fd = 1;
	private double fp = 1;
	private double fs = 1;
	private double fSimu = 1;
	private double fu = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne()
	@JoinColumn(name = "circuito_id")
	private Circuito circuito;
	private String ligacao;
	private String ligacaoReal;
	private String nome;
	private int nPolos;
	private double perdasReator;
	private double potencia;
	private int quantidade = 1;
	private double rendimento = 1;
	private double tensaoFN;
	private UnidadePontencia unidade;
	private String usabilidade;

	// ----------------------------------------------

	public Equipamento() {

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
		e.setTensaoFN(tensaoFN);
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

	public double getCorrente() {
		double valor = 0;
		if (this.ligacao.equals("FFF") || this.ligacao.equals("FFFN")) {
			valor = getPotenciaEmVA() / (this.tensaoFN);
		}
		if (this.ligacao.equals("FF") || this.ligacao.equals("FFN")) {
			valor = getPotenciaEmVA() / (Math.sqrt(3) * this.tensaoFN);
		}
		if (this.ligacao.equals("FN")) {
			valor = getPotenciaEmVA() / (this.tensaoFN);
		}
		return valor;
	}

	public Double getDemanda() {
		double total = 0;

		if (this.getUsabilidade().equals("Ilumina��o fluorescente")) {

			total = 1.8 * ((this.getPotenciaEmW() * this.getFd()) + (this.getPerdasReator() / this.getFp()));
		}

		if (this.getUsabilidade().equals("Geral") || this.getUsabilidade().equals("Ilumina��o incandescente")) {

			total = this.getPotenciaEmVA() * this.getFu() * this.getFd() / this.getRendimento();
		}
		return total;
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

	@Override
	public Integer getId() {
		return id;
	}

	public String getLigacao() {
		return ligacao;
	}

	public String getLigacaoReal() {
		return ligacaoReal;
	}

	public int getNFases() {
		int valor = 0;
		if (this.ligacao.equals("FN")) {
			valor = 1;
		}
		if (this.ligacao.equals("FF") || this.ligacao.equals("FFN")) {
			valor = 2;
		}
		if (this.ligacao.equals("FFF") || this.ligacao.equals("FFFN")) {
			valor = 3;
		}
		return valor;
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

	public Double getPotenciaEmVA() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidade)//
				.withUnidadeDestino(UnidadePontencia.VA)//
				.converte();
	}

	public Double getPotenciaEmW() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidade)//
				.withUnidadeDestino(UnidadePontencia.W)//
				.converte();
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getRendimento() {
		return rendimento;
	}

	public double getTensaoFN() {
		return tensaoFN;
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

	public String getUsabilidade() {
		return usabilidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
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

	public void setLigacao(String ligacao) {
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

	public void setTensaoFN(double tensaoFN) {
		this.tensaoFN = tensaoFN;
	}

	public void setUnidade(UnidadePontencia unidade) {
		this.unidade = unidade;
	}

	public void setUsabilidade(String usabilidade) {
		this.usabilidade = usabilidade;
	}

	@Override
	public String toString() {
		return nome;
	}
}
