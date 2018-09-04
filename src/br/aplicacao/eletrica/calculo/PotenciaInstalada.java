package br.aplicacao.eletrica.calculo;

import br.aplicacao.eletrica.enums.UnidadePontencia;
import br.aplicacao.eletrica.modelo.Circuito;
import br.aplicacao.eletrica.modelo.Equipamento;
import br.aplicacao.eletrica.modelo.Quadro;

public class PotenciaInstalada {

	private Quadro quadro;
	private UnidadePontencia unidadeDestino;

	public PotenciaInstalada() {

	}

	public Double valor() {
		double valor = 0;
		if (unidadeDestino == UnidadePontencia.VA) {
			for (Quadro q : quadro.getQuadros()) {
				for (Circuito c : q.getCircuitos()) {
					for (Equipamento e : c.getEquipamentos()) {
						valor += e.getQuantidade() * e.getDemanda(UnidadePontencia.VA);
					}
				}
			}
		} else if (unidadeDestino == UnidadePontencia.W) {
			for (Quadro q : quadro.getQuadros()) {
				for (Circuito c : q.getCircuitos()) {
					for (Equipamento e : c.getEquipamentos()) {
						valor += e.getQuantidade() * e.getDemanda(UnidadePontencia.W);
					}
				}
			}
		}

		return valor;
	}

	public PotenciaInstalada withQuadro(Quadro quadro) {
		this.quadro = quadro;
		return this;
	}

	public PotenciaInstalada withUnidadeDestino(UnidadePontencia unidadeDestino) {
		this.unidadeDestino = unidadeDestino;
		return this;
	}
}
