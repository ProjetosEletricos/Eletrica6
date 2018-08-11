package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.enums.Usabilidade;

public class Demanda {

	private Double potencia;
	private UnidadePontencia unidadeOrigem;
	private UnidadePontencia unidadeDestino;
	private Double fp;
	private Double fu;
	private Double fd;
	private Usabilidade usabilidade;
	private Double perdasReator;
	private Double rendimento;

	public Demanda() {

	}

	public Double valor() {
		double valor = 0;

		if (usabilidade == Usabilidade.ILUMINACAO_FLUORESCENTE) {
			if (unidadeDestino == UnidadePontencia.VA) {
				valor = 1.8 * ((this.getPotenciaEmW() * fd) + (perdasReator / fp));
			} else if (unidadeDestino == UnidadePontencia.W) {
				valor = 1.8 * ((this.getPotenciaEmW() * fd) + (perdasReator));
			}
		}
		if (usabilidade == Usabilidade.ILUMINACAO_INCADESCENTE) {
			if (unidadeDestino == UnidadePontencia.VA) {
				valor = this.getPotenciaEmVA() * fu * fd / rendimento;
			} else if (unidadeDestino == UnidadePontencia.W) {
				valor = this.getPotenciaEmW() * fu * fd / rendimento;
			}
		}
		if (usabilidade == Usabilidade.GERAL) {
			if (unidadeDestino == UnidadePontencia.VA) {
				valor = this.getPotenciaEmVA() * fu * fd / rendimento;
			} else if (unidadeDestino == UnidadePontencia.W) {
				valor = this.getPotenciaEmW() * fu * fd / rendimento;
			}
		}
		if (usabilidade == Usabilidade.MOTOR) {
			if (unidadeDestino == UnidadePontencia.VA) {
				valor = this.getPotenciaEmVA() * fu * fd / rendimento;
			} else if (unidadeDestino == UnidadePontencia.W) {
				valor = this.getPotenciaEmW() * fu * fd / rendimento;
			}
		}
		if (usabilidade == Usabilidade.EQUIPAMENTOS_ESPECIAIS) {
			if (unidadeDestino == UnidadePontencia.VA) {
				valor = this.getPotenciaEmVA() * fu * fd / rendimento;
			} else if (unidadeDestino == UnidadePontencia.W) {
				valor = this.getPotenciaEmW() * fu * fd / rendimento;
			}
		}

		return valor;
	}

	public Demanda withPotencia(Double potencia) {
		this.potencia = potencia;
		return this;
	}

	public Demanda withUnidadeOrigem(UnidadePontencia unidadeOrigem) {
		this.unidadeOrigem = unidadeOrigem;
		return this;
	}

	public Demanda withUnidadeDestino(UnidadePontencia unidadeDestino) {
		this.unidadeDestino = unidadeDestino;
		return this;
	}

	public Demanda withRendimento(Double rendimento) {
		this.rendimento = rendimento;
		return this;
	}

	public Demanda withPerdasReator(Double perdasReator) {
		this.perdasReator = perdasReator;
		return this;
	}

	public Demanda withFu(Double fu) {
		this.fu = fu;
		return this;
	}

	public Demanda withFd(Double fd) {
		this.fd = fd;
		return this;
	}

	public Demanda withFp(Double fp) {
		this.fp = fp;
		return this;
	}

	public Demanda withUsabilidade(Usabilidade usabilidade) {
		this.usabilidade = usabilidade;
		return this;
	}

	private Double getPotenciaEmVA() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidadeOrigem)//
				.withUnidadeDestino(UnidadePontencia.VA)//
				.converte();
	}

	private Double getPotenciaEmW() {
		return new ConversorPotencia()//
				.withFatorPotencia(fp)//
				.withPotencia(potencia)//
				.withUnidadeOrigem(unidadeOrigem)//
				.withUnidadeDestino(UnidadePontencia.W)//
				.converte();
	}
}
